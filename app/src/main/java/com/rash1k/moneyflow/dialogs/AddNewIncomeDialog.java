package com.rash1k.moneyflow.dialogs;

import android.app.AlertDialog;
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
import android.view.View;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.rash1k.moneyflow.R;
import com.rash1k.moneyflow.services.MyIntentService;
import com.rash1k.moneyflow.util.Prefs;

public class AddNewIncomeDialog extends DialogFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private AutoCompleteTextView acNameOfIncome;
    private EditText etVolumeOfIncome;
    private SimpleCursorAdapter simpleCursorAdapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_add_new_income_dialog, null, false);

        acNameOfIncome = (AutoCompleteTextView) view.findViewById(R.id.acNameOfIncome);
        etVolumeOfIncome = (EditText) view.findViewById(R.id.etVolumeOfIncome);

        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_dropdown_item_1line,
                null, new String[]{Prefs.INCOMES_NAMES_FIELD_NAME}, new int[]{android.R.id.text1},
                Adapter.NO_SELECTION);

        acNameOfIncome.setAdapter(simpleCursorAdapter);

        builder.setView(view)
                .setMessage(R.string.message_add_new_income_dialog)
                .setTitle(R.string.title_add_new_income_dialog)
                .setPositiveButton(R.string.positive_button_add_new_income_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addNewIncome();
                    }
                })
                .setNegativeButton(R.string.negative_button_add_new_income_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        getActivity().getSupportLoaderManager().initLoader(Prefs.ID_LOADER_INCOMES_NAMES, null, this);

        return builder.create();
    }

    private void addNewIncome() {

        String name = acNameOfIncome.getText().toString();
        double volume = Double.parseDouble(etVolumeOfIncome.getText().toString());

        if (!name.equals("")) {

            MyIntentService.startActionInsertIncome(getActivity(), name, volume);
        } else {
            dismiss();
        }
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (id == Prefs.ID_LOADER_INCOMES_NAMES) {
            return new CursorLoader(getActivity(), Prefs.URI_INCOMES_NAMES, null, null, null, null);
        }
        return null;
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
