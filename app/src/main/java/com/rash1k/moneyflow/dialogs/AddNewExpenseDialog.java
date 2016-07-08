package com.rash1k.moneyflow.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.rash1k.moneyflow.R;
import com.rash1k.moneyflow.services.MyIntentService;
import com.rash1k.moneyflow.util.Prefs;


public class AddNewExpenseDialog extends DialogFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private EditText etVolumeOfExpenses;
    private AutoCompleteTextView acNameOfExpenses;
    private CheckBox chbCritical;
    private SimpleCursorAdapter simpleCursorAdapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_add_new_expense_dialog, new LinearLayout(getActivity()), false);


        etVolumeOfExpenses = (EditText) view.findViewById(R.id.etVolumeOfExpense);
        acNameOfExpenses = (AutoCompleteTextView) view.findViewById(R.id.acNameOfExpense);
        chbCritical = (CheckBox) view.findViewById(R.id.chbCriticalExpense);

        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_dropdown_item_1line,
                null,
                new String[]{Prefs.EXPENSES_NAMES_FIELD_NAME},
                new int[]{android.R.id.text1},
                Adapter.NO_SELECTION);
        acNameOfExpenses.setAdapter(simpleCursorAdapter);

        builder.setView(view)
                .setMessage(R.string.message_add_new_expense_dialog)
                .setTitle(R.string.title_add_new_expense_dialog)
                .setPositiveButton(R.string.positive_button_add_new_expense_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        addNewExpense();
                    }
                })
                .setNegativeButton(R.string.negative_button_add_new_expense_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        getActivity().getSupportLoaderManager().initLoader(Prefs.ID_LOADER_EXPENSES_NAMES, null, this);
        return builder.create();
    }


    private void addNewExpense() {

        String name = acNameOfExpenses.getText().toString();
        double volume = Double.parseDouble(etVolumeOfExpenses.getText().toString());
        int critical = chbCritical.isChecked() ? 1 : 0;

        if (!name.equals("")) {
            MyIntentService.startActionInsertExpense(getActivity(), name, volume, critical);
        } else dismiss();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(getActivity(), Prefs.URI_EXPENSES_NAMES, null, null, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        simpleCursorAdapter.swapCursor(data);
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        simpleCursorAdapter.swapCursor(null);
    }

}
