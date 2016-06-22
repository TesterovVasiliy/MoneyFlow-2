package com.rash1k.moneyflow.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rash1k.moneyflow.R;
import com.rash1k.moneyflow.util.Prefs;

import java.util.HashMap;

public class IncomesFragment extends Fragment implements LoaderManager.LoaderCallbacks<HashMap<String, String>> {

    TextView tvCurrentFragmentIncomes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incomes, container, false);

        tvCurrentFragmentIncomes = (TextView) view.findViewById(R.id.tvCurrentFragmentIncomes);

        getActivity().getSupportLoaderManager().initLoader(Prefs.ID_LOADER_INCOMES_FRAGMENT, null, this);

        return view;
    }


    @Override
    public Loader<HashMap<String, String>> onCreateLoader(int id, Bundle args) {

        if (id == Prefs.ID_LOADER_EXPENSES_FRAGMENT) {

            // TODO: 16.06.2016

        }

        return new HashMapLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<HashMap<String, String>> loader, HashMap<String, String> data) {

    }

    @Override
    public void onLoaderReset(Loader<HashMap<String, String>> loader) {

    }

    public static class HashMapLoader extends Loader<HashMap<String, String>> {
        HashMap<String, String> result;

        public HashMapLoader(Context context) {
            super(context);
            result = new HashMap<>();
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override
        protected void onForceLoad() {
            super.onForceLoad();

            Cursor cursor = getContext().getContentResolver().query(Prefs.URI_INCOMES, new String[]{Prefs.INCOMES_FIELD_VOLUME}, null, null, null);

            if (cursor != null && cursor.getCount() != 0){
                double value = 0;

                for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                    // TODO: 18.06.2016

                }
                cursor.close();
            }
        }
    }
}
