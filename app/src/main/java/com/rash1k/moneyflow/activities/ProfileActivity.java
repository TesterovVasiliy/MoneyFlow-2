package com.rash1k.moneyflow.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.rash1k.moneyflow.R;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PreferenceManager.setDefaultValues(this,R.xml.profile,false);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }


    public static class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.profile);

        }


        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


            if (key.equals(getString(R.string.pref_key_sex))) {
/*
                SwitchPreference switchPreference = (SwitchPreference) findPreference(key);

                CharSequence summaryOnSwitchPreferenceSex = switchPreference.getSwitchTextOn();
                CharSequence summaryOffSwitchPreferenceSex = switchPreference.getSwitchTextOff();
                switchPreference.setSummaryOn(summaryOnSwitchPreferenceSex);
                switchPreference.setSummaryOff(summaryOffSwitchPreferenceSex);*/

            } else if (key.equals(getString(R.string.pref_summary_login))) {
               /* String summary = sharedPreferences.getString(key, getString(R.string.pref_summary_login));

                EditTextPreference editTextPreference = (EditTextPreference) findPreference(key);
                editTextPreference.setSummary(summary);*/
            }

        }


        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }

    }
}
