package com.rash1k.moneyflow.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rash1k.moneyflow.R;
import com.rash1k.moneyflow.fragments.ExpensesFragment;
import com.rash1k.moneyflow.fragments.IncomesFragment;


public class DashboardPagerAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_CASH_FLOW = 0;
    public static final int FRAGMENT_EXPENSES = 1;
    public static final int FRAGMENT_INCOMES = 2;

    private Context context;

    public DashboardPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle argBundle;

        switch (position) {
            case FRAGMENT_CASH_FLOW:
                fragment = new DefaultFragment();
                argBundle = new Bundle();
                argBundle.putString(DefaultFragment.KEY_NAME, context.getResources().getString(R.string.title_tab_cash_flow));
                fragment.setArguments(argBundle);
                break;
            case FRAGMENT_EXPENSES:
                fragment = new ExpensesFragment();
                break;
            case FRAGMENT_INCOMES:
                fragment = new IncomesFragment();
                break;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = null;

        switch (position) {
            case FRAGMENT_CASH_FLOW:
                pageTitle =  context.getResources().getString(R.string.title_tab_cash_flow);
                break;
            case FRAGMENT_EXPENSES:
                pageTitle =  context.getResources().getString(R.string.title_tab_expenses);
                break;
            case FRAGMENT_INCOMES:
                pageTitle =  context.getResources().getString(R.string.title_tab_incomes);
                break;
        }
        return pageTitle;
    }

    public static class DefaultFragment extends Fragment {

        private static final String KEY_NAME = "name";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, container, false);
            String name = getArguments().getString(KEY_NAME);
            ((TextView) view.findViewById(android.R.id.text1)).setText(name);

            return view;
        }
    }

   }
