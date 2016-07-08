package com.rash1k.moneyflow.fragments;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import java.util.Locale;

public class IncomesFragment extends Fragment implements LoaderManager.LoaderCallbacks<HashMap<String, String>> {

    private TextView tvCurrentFragmentIncomes;
    private static final String CURRENT_MONTH = "current";
    private ContentObserver observer = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);

            getActivity().getSupportLoaderManager().initLoader(Prefs.ID_LOADER_INCOMES_FRAGMENT, null, IncomesFragment.this);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getContentResolver().registerContentObserver(Prefs.URI_INCOMES, false, observer);

    }

    @Override
    public void onPause() {
        super.onPause();

        getActivity().getContentResolver().unregisterContentObserver(observer);
    }

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

        if (id == Prefs.ID_LOADER_INCOMES_FRAGMENT) {

            return new HashMapLoader(getActivity());
        }

        return null;
    }

    @Override
    public void onLoadFinished(Loader<HashMap<String, String>> loader, HashMap<String, String> data) {
        tvCurrentFragmentIncomes.setText(data.get(CURRENT_MONTH));
    }

    @Override
    public void onLoaderReset(Loader<HashMap<String, String>> loader) {

    }

    private static class HashMapLoader extends Loader<HashMap<String, String>> {
        HashMap<String, String> result;

        HashMapLoader(Context context) {
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

            if (cursor != null && cursor.getCount() != 0) {
                double value = 0;

                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    value += cursor.getDouble(cursor.getColumnIndex(Prefs.INCOMES_FIELD_VOLUME));
                }
//                With an accuracy of two decimal
                result.put(CURRENT_MONTH, String.format(Locale.getDefault(), "%.2f", value));
                deliverResult(result);
                cursor.close();
            } else {
                result.put(CURRENT_MONTH, "0");
                deliverResult(result);
            }
        }
    }
}
