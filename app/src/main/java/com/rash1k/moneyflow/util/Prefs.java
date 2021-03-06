package com.rash1k.moneyflow.util;

import android.net.Uri;

public final class Prefs {

    //    The Log constance
    public static final String LOG_TAG = "MoneyFlow";
    public static final String LOG_WARN_SQL = "SQLite";

    public static final String RAW_QUERY_ALL_EXPENSES = "SELECT expense_names.name, expenses.volume, expense_names.critical, expenses.date FROM expenses INNER JOIN expense_names ON expense_names._id = expenses.id_passive;";
    public static final String RAW_QUERY_ALL_EXPENSES_2 = Prefs.TABLE_NAME_EXPENSES + " INNER JOIN " +
            Prefs.TABLE_NAME_EXPENSES_NAMES + " ON (" +
            Prefs.TABLE_NAME_EXPENSES_NAMES + "." +
            Prefs.FIELD_ID + " = " +
            Prefs.TABLE_NAME_EXPENSES + "." +
            Prefs.EXPENSES_FIELD_ID_PASSIVE + ");";

    public static final String RAW_QUERY_ALL_INCOMES = Prefs.TABLE_NAME_INCOMES + " INNER JOIN " +
            Prefs.TABLE_NAME_INCOMES_NAMES + " ON (" + Prefs.TABLE_NAME_INCOMES_NAMES + "." +
            Prefs.FIELD_ID + " = " + Prefs.TABLE_NAME_INCOMES + "." +
            Prefs.INCOMES_FIELD_ID_PASSIVE + ");";

    //The password constants:
    public static final String FN_FIELD_NAME = "first_name";
    public static final String LN_FIELD_NAME = "last_name";
    public static final String BIRTHDAY_FIELD_NAME = "birthday";
    public static final String EMAIL_FIELD_NAME = "email";
    public static final String API_SERVER = "http://cityfinder.esy.es";


    //The Database constants:
    public static final String DB_NAME = "Money_Flow_DB";
    public static final int DB_CURRENT_VERSION = 2;
    public static final String FIELD_ID = "_id";

    //The Table Expenses constants:

    //The Table Expenses:

    public static final String TABLE_NAME_EXPENSES = "expenses";
    public static final String EXPENSES_FIELD_ID_PASSIVE = "id_passive";
    public static final String EXPENSES_FIELD_VOLUME = "volume";
    public static final String EXPENSES_FIELD_DATE = "date";

    //The Table Expense Names
    public static final String TABLE_NAME_EXPENSES_NAMES = "expense_names";
    public static final String EXPENSES_NAMES_FIELD_NAME = "name";
    public static final String EXPENSES_NAMES_FIELD_CRITICAL = "critical";

    //The Table Incomes constants:

    //The Table Incomes:

    public static final String TABLE_NAME_INCOMES = "incomes";
    public static final String INCOMES_FIELD_ID_PASSIVE = "id_passive";
    public static final String INCOMES_FIELD_VOLUME = "volume";
    public static final String INCOMES_FIELD_DATE = "date";
    //The Table Income_names:

    public static final String TABLE_NAME_INCOMES_NAMES = "income_names";
    public static final String INCOMES_NAMES_FIELD_NAME = "name";

//    The Table Monthly_cash:

    public static final String TABLE_NAME_MONTHLY_CASH = "monthly_cash";
    public static final String MONTHLY_FIELD_MONTH = "month";
    public static final String MONTHLY_FIELD_YEAR = "year";
    public static final String MONTHLY_FIELD_CASH_FLOW = "cash_flow";
    public static final String MONTHLY_FIELD_EXPENSE = "expense";
    public static final String MONTHLY_FIELD_INCOME = "income";
    public static final String MONTHLY_FIELD_ENTRY_BALANCE = "entry_balance";
    public static final String MONTHLY_FIELD_EXPENSE_PLAN = "expense_plan";
    public static final String MONTHLY_FIELD_INCOME_PLAN = "income_plan";



    //The provider constants:

    //Expenses Constants:

    public static final String URI_EXPENSES_AUTHORITIES = "com.rash1k.moneyflow.provider";
    public static final String URI_EXPENSES_PATH = "expenses";
    public static final String URI_SCHEMA_PROVIDER = "content://";
    public static final Uri URI_EXPENSES = Uri.parse(URI_SCHEMA_PROVIDER + URI_EXPENSES_AUTHORITIES + "/" + URI_EXPENSES_PATH);

    //Expense Names Constants:

    public static final String URI_EXPENSES_NAMES_AUTHORITIES = "com.rash1k.moneyflow.provider";
    public static final String URI_EXPENSES_NAMES_PATH = "expenses_names";
    public static final Uri URI_EXPENSES_NAMES = Uri.parse(URI_SCHEMA_PROVIDER + URI_EXPENSES_NAMES_AUTHORITIES + "/" + URI_EXPENSES_NAMES_PATH);

    public static final String URI_ALL_EXPENSES_PATH = "all_expenses";
    public static final Uri URI_ALL_EXPENSES = Uri.parse("content://" + URI_EXPENSES_NAMES_AUTHORITIES + "/" + URI_ALL_EXPENSES_PATH);

    //Incomes Constants:

    public static final String URI_INCOMES_AUTHORITIES = "com.rash1k.moneyflow.provider";
    public static final String URI_INCOMES_PATH = "incomes";
    public static final Uri URI_INCOMES = Uri.parse(URI_SCHEMA_PROVIDER + URI_INCOMES_AUTHORITIES + "/" + URI_INCOMES_PATH);

    //Income Names:

    public static final String URI_INCOMES_NAMES_AUTHORITIES = "com.rash1k.moneyflow.provider";
    public static final String URI_INCOMES_NAMES_PATH = "income_names";
    public static final Uri URI_INCOMES_NAMES = Uri.parse(URI_SCHEMA_PROVIDER + URI_INCOMES_NAMES_AUTHORITIES + "/" + URI_INCOMES_NAMES_PATH);

    public static final String URI_ALL_INCOMES_PATH = "all_incomes";
    public static final Uri URI_ALL_INCOMES = Uri.parse(URI_SCHEMA_PROVIDER + URI_INCOMES_NAMES_AUTHORITIES + "/" + URI_ALL_INCOMES_PATH);

//    Monthly Cash:

    public static final String URI_MONTHLY_PATH = "monthly_cash";
    public static final String URI_MONTHLY_AUTHORITIES = "com.rash1k.moneyflow.provider";
    public static final Uri URI_MONTHLY_CASH = Uri.parse(URI_SCHEMA_PROVIDER + URI_MONTHLY_AUTHORITIES + "/" + URI_MONTHLY_PATH);

    //Loader Constants
    public static final int ID_LOADER_EXPENSES_NAMES = 1;
    public static final int ID_LOADER_INCOMES_NAMES = 2;
    public static final int ID_LOADER_EXPENSES_FRAGMENT = 3;
    public static final int ID_LOADER_INCOMES_FRAGMENT = 4;
}
