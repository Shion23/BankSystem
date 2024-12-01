package com.example.bankaccsystem.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "bankingSystem.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_BANK = "Bank";
    private static final String TABLE_CONTACT = "Contact";
    private static final String TABLE_ADDRESS = "Address";
    private static final String TABLE_CUSTOMER = "Customer";
    private static final String TABLE_ACCOUNT = "Account";
    private static final String TABLE_STATEMENT = "Statement";
    private static final String TABLE_SAVING_ACCOUNT = "SavingAccount";
    private static final String TABLE_CHECKING_ACCOUNT = "CheckingAccount";
    private static final String TABLE_FLEXIBLE_SAVING_ACCOUNT = "FlexibleSavingAccount";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BANK_TABLE = "CREATE TABLE " + TABLE_BANK + "("
                + "bank_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT" + ")";

        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_CONTACT + "("
                + "contact_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "phone_number TEXT,"
                + "mobile TEXT,"
                + "email TEXT" + ")";

        String CREATE_ADDRESS_TABLE = "CREATE TABLE " + TABLE_ADDRESS + "("
                + "address_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "street TEXT,"
                + "house_number TEXT,"
                + "zipcode TEXT,"
                + "city TEXT" + ")";

        String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
                + "customer_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "first_name TEXT,"
                + "surname TEXT,"
                + "contact_id INTEGER,"
                + "address_id INTEGER,"
                + "FOREIGN KEY (contact_id) REFERENCES " + TABLE_CONTACT + "(contact_id),"
                + "FOREIGN KEY (address_id) REFERENCES " + TABLE_ADDRESS + "(address_id)" + ")";

        String CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_ACCOUNT + "("
                + "account_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "balance REAL,"
                + "interest_rate REAL,"
                + "interest_period TEXT,"
                + "bank_id INTEGER,"
                + "customer_id INTEGER,"
                + "FOREIGN KEY (bank_id) REFERENCES " + TABLE_BANK + "(bank_id),"
                + "FOREIGN KEY (customer_id) REFERENCES " + TABLE_CUSTOMER + "(customer_id)" + ")";

        String CREATE_STATEMENT_TABLE = "CREATE TABLE " + TABLE_STATEMENT + "("
                + "statement_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "date TEXT,"
                + "content TEXT,"
                + "account_id INTEGER,"
                + "FOREIGN KEY (account_id) REFERENCES " + TABLE_ACCOUNT + "(account_id)" + ")";

        String CREATE_SAVING_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_SAVING_ACCOUNT + "("
                + "account_id INTEGER PRIMARY KEY,"
                + "FOREIGN KEY (account_id) REFERENCES " + TABLE_ACCOUNT + "(account_id)" + ")";

        String CREATE_CHECKING_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_CHECKING_ACCOUNT + "("
                + "account_id INTEGER PRIMARY KEY,"
                + "FOREIGN KEY (account_id) REFERENCES " + TABLE_ACCOUNT + "(account_id)" + ")";

        String CREATE_FLEXIBLE_SAVING_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_FLEXIBLE_SAVING_ACCOUNT + "("
                + "account_id INTEGER PRIMARY KEY,"
                + "FOREIGN KEY (account_id) REFERENCES " + TABLE_ACCOUNT + "(account_id)" + ")";

        db.execSQL(CREATE_BANK_TABLE);
        db.execSQL(CREATE_CONTACT_TABLE);
        db.execSQL(CREATE_ADDRESS_TABLE);
        db.execSQL(CREATE_CUSTOMER_TABLE);
        db.execSQL(CREATE_ACCOUNT_TABLE);
        db.execSQL(CREATE_STATEMENT_TABLE);
        db.execSQL(CREATE_SAVING_ACCOUNT_TABLE);
        db.execSQL(CREATE_CHECKING_ACCOUNT_TABLE);
        db.execSQL(CREATE_FLEXIBLE_SAVING_ACCOUNT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATEMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAVING_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKING_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FLEXIBLE_SAVING_ACCOUNT);

        onCreate(db);
    }
}
