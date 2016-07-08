package com.rash1k.moneyflow.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rash1k.moneyflow.util.Prefs;


public class DBHelper extends SQLiteOpenHelper {

     /*Table expenses
    - id
    - id passive - id from table passive
    -volume - volume of money
    -date -date when expenses made
    * */

    private static final String CREATE_TABLE_EXPENSES = String.format(
            "create table %s (%s integer primary key autoincrement, " +
            "%s integer, %s real, %s text);",
            Prefs.TABLE_NAME_EXPENSES,
            Prefs.FIELD_ID,
            Prefs.EXPENSES_FIELD_ID_PASSIVE,
            Prefs.EXPENSES_FIELD_VOLUME,
            Prefs.EXPENSES_FIELD_DATE);

    /*
Table expense_names
- _id
- name - name of expense
- critical - is it necessary to make the expense constantly
*/

    private static final String CREATE_TABLE_EXPENSE_NAMES = String.format(
            "CREATE TABLE %s (%s integer primary key autoincrement, %s text, %s integer);",
            Prefs.TABLE_NAME_EXPENSES_NAMES,
            Prefs.FIELD_ID,
            Prefs.EXPENSES_NAMES_FIELD_NAME,
            Prefs.EXPENSES_NAMES_FIELD_CRITICAL);

     /*Table incomes
    - id
    - id passive - id from table passive
    -volume - volume of money
    -date -date when incomes made
    * */

    private static final String CREATE_TABLE_INCOMES = String.format(
            "CREATE TABLE %s (%s integer primary key autoincrement, %s integer, %s real, %s text);",
            Prefs.TABLE_NAME_INCOMES,
            Prefs.FIELD_ID,
            Prefs.INCOMES_FIELD_ID_PASSIVE,
            Prefs.INCOMES_FIELD_VOLUME,
            Prefs.INCOMES_FIELD_DATE);

                 /*
    Table income_names
    - _id
    - name - name of income
    */

    private static final String CREATE_TABLE_INCOME_NAMES = String.format(
            "CREATE TABLE %s (%s integer primary key autoincrement, %s text);",
            Prefs.TABLE_NAME_INCOMES_NAMES,
            Prefs.FIELD_ID,
            Prefs.INCOMES_NAMES_FIELD_NAME);


    /*
    * Table monthlyCash
    * - id
    * - month - accounting monthly
    * - year - accounting year
    * - expense - expense for current monthly
    * - income - income for current monthly
    * - cashFlow - the difference between income and expenditure
    * - entry-balance  cashFlow + start-up balance
    * e-plane - planned expense for next month
    * i-plane - planed income for next month
    */
      private static final String CREATE_TABLE_MONTHLY_CASH = String.format(
            "CREATE TABLE %s (%s integer primary key autoincrement, %s text, %s integer, " +
                    "%s real, %s real, %s real, %s real, %s real, %s real);",
            Prefs.TABLE_NAME_MONTHLY_CASH,
            Prefs.FIELD_ID,
            Prefs.MONTHLY_FIELD_MONTH,
            Prefs.MONTHLY_FIELD_YEAR,
            Prefs.MONTHLY_FIELD_CASH_FLOW,
            Prefs.MONTHLY_FIELD_EXPENSE,
            Prefs.MONTHLY_FIELD_INCOME,
            Prefs.MONTHLY_FIELD_ENTRY_BALANCE,
            Prefs.MONTHLY_FIELD_EXPENSE_PLAN,
            Prefs.MONTHLY_FIELD_INCOME_PLAN);

    public DBHelper(Context context, int version) {
        super(context, Prefs.DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EXPENSES);
        db.execSQL(CREATE_TABLE_EXPENSE_NAMES);
        db.execSQL(CREATE_TABLE_INCOMES);
        db.execSQL(CREATE_TABLE_INCOME_NAMES);
        db.execSQL(CREATE_TABLE_MONTHLY_CASH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      /*  Log.w(Prefs.LOG_WARN_SQL, "onUpgrade: " + oldVersion + " on the version: " + newVersion);

        if (oldVersion < newVersion) {
            db.execSQL(CREATE_TABLE_EXPENSE_NAMES);
            db.execSQL(CREATE_TABLE_INCOMES);
            db.execSQL(CREATE_TABLE_INCOME_NAMES);
            db.execSQL(CREATE_TABLE_MONTHLY_CASH);
        } else {
            Log.d(Prefs.LOG_TAG, "You have current version");
        }*/
    }
}
