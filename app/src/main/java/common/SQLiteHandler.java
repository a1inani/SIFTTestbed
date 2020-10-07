package common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Alinani on 19/02/2017.
 */

public class SQLiteHandler extends SQLiteOpenHelper {
    private static final String TAG = "SQLiteHandler";
    private static final int DATABASE_VERSION = 5;
    public static final String TABLE_6DAY_LEFT = "table_6day_left";
    public static final String TABLE_6WEEK_LEFT = "table_6week_left";
    public static final String TABLE_10WEEK_LEFT = "table_10week_left";
    public static final String TABLE_14WEEK_LEFT = "table_14week_left";
    public static final String TABLE_4MONTH_LEFT = "table_4month_left";
    public static final String TABLE_5MONTH_LEFT = "table_5month_left";
    public static final String TABLE_6MONTH_LEFT = "table_6month_left";
    public static final String TABLE_7MONTH_LEFT = "table_7month_left";
    public static final String TABLE_8MONTH_LEFT = "table_8month_left";
    public static final String TABLE_9MONTH_LEFT = "table_9month_left";
    public static final String COLUMN_TEST_ID = "_teid";
    public static final String COLUMN_FILE_NAME = "t_name";
    public static final String COLUMN_GENDER = "t_gender";
    public static final String COLUMN_FEATURE = "t_feature";
    public static final String TABLE_6DAY_LEFT30 = "table_6day_left30";
    public static final String TABLE_6WEEK_LEFT30 = "table_6week_left30";
    public static final String TABLE_10WEEK_LEFT30 = "table_10week_left30";
    public static final String TABLE_14WEEK_LEFT30 = "table_14week_left30";
    public static final String TABLE_4MONTH_LEFT30 = "table_4month_left30";
    public static final String TABLE_5MONTH_LEFT30 = "table_5month_left30";
    public static final String TABLE_6MONTH_LEFT30 = "table_6month_left30";
    public static final String TABLE_7MONTH_LEFT30 = "table_7month_left30";
    public static final String TABLE_8MONTH_LEFT30 = "table_8month_left30";
    public static final String TABLE_9MONTH_LEFT30 = "table_9month_left30";
    public static final String TABLE_6DAY_RIGHT = "table_6day_right";
    public static final String TABLE_6WEEK_RIGHT = "table_6week_right";
    public static final String TABLE_10WEEK_RIGHT = "table_10week_right";
    public static final String TABLE_14WEEK_RIGHT = "table_14week_right";
    public static final String TABLE_4MONTH_RIGHT = "table_4month_right";
    public static final String TABLE_5MONTH_RIGHT = "table_5month_right";
    public static final String TABLE_6MONTH_RIGHT = "table_6month_right";
    public static final String TABLE_7MONTH_RIGHT = "table_7month_right";
    public static final String TABLE_8MONTH_RIGHT = "table_8month_right";
    public static final String TABLE_9MONTH_RIGHT = "table_9month_right";
    public static final String TABLE_6DAY_RIGHT30 = "table_6day_right30";
    public static final String TABLE_6WEEK_RIGHT30 = "table_6week_right30";
    public static final String TABLE_10WEEK_RIGHT30 = "table_10week_right30";
    public static final String TABLE_14WEEK_RIGHT30 = "table_14week_right30";
    public static final String TABLE_4MONTH_RIGHT30 = "table_4month_right30";
    public static final String TABLE_5MONTH_RIGHT30 = "table_5month_right30";
    public static final String TABLE_6MONTH_RIGHT30 = "table_6month_right30";
    public static final String TABLE_7MONTH_RIGHT30 = "table_7month_right30";
    public static final String TABLE_8MONTH_RIGHT30 = "table_8month_right30";
    public static final String TABLE_9MONTH_RIGHT30 = "table_9month_right30";
    public static final String COLUMN_TRAIN_ID = "_trid";
    public static final String TABLE_SCORE_MATRIX = "table_score_matrix";
    public static final String COLUMN_SCORE_MATRIX_ID = "_smid";
    public static final String COLUMN_LEFT = "t_left";
    public static final String COLUMN_RIGHT = "t_right";
    public static final String COLUMN_DISTANCE = "t_distance";

    public SQLiteHandler(Context context, String dbName) {
        super(context, dbName, null, DATABASE_VERSION);
    }

    private static final String TABLE_CREATE_6DAY_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6DAY_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6WEEK_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6WEEK_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_10WEEK_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_10WEEK_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_14WEEK_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_14WEEK_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_4MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_4MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_5MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_5MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_7MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_7MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_8MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_8MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_9MONTH_LEFT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_9MONTH_LEFT).append("(").append(COLUMN_TEST_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").
            append(COLUMN_FILE_NAME).append(" TEXT NOT NULL, ").
            append(COLUMN_GENDER).append(" TEXT, ").append(COLUMN_FEATURE).
            append(" TEXT NOT NULL").append("); ").toString();

    private static final String TABLE_CREATE_6DAY_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6DAY_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6WEEK_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6WEEK_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_10WEEK_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_10WEEK_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_14WEEK_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_14WEEK_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_4MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_4MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_5MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_5MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_7MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_7MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_8MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_8MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_9MONTH_LEFT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_9MONTH_LEFT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();

    private static final String TABLE_CREATE_6DAY_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6DAY_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6WEEK_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6WEEK_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_10WEEK_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_10WEEK_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_14WEEK_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_14WEEK_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_4MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_4MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_5MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_5MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_7MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_7MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_8MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_8MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_9MONTH_RIGHT = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_9MONTH_RIGHT).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();

    private static final String TABLE_CREATE_6DAY_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6DAY_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6WEEK_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6WEEK_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_10WEEK_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_10WEEK_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_14WEEK_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_14WEEK_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_4MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_4MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_5MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_5MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_6MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_6MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_7MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_7MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_8MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_8MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();
    private static final String TABLE_CREATE_9MONTH_RIGHT30 = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_9MONTH_RIGHT30).append("(").append(COLUMN_TRAIN_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_FILE_NAME).
            append(" TEXT NOT NULL, ").append(COLUMN_GENDER).append(" TEXT, ").
            append(COLUMN_FEATURE).append(" TEXT NOT NULL").append("); ").toString();

    private static final String TABLE_CREATE_SCORE_MATRIX = new StringBuilder().append("CREATE TABLE ").
            append(TABLE_SCORE_MATRIX).append("(").append(COLUMN_SCORE_MATRIX_ID).
            append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_LEFT).
            append(" TEXT NOT NULL, ").append(COLUMN_RIGHT).append(" TEXT NOT NULL, ").
            append(COLUMN_DISTANCE).append(" REAL NOT NULL);").toString();

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate InternalDbManager");
        db.execSQL(TABLE_CREATE_6DAY_LEFT);
        db.execSQL(TABLE_CREATE_6WEEK_LEFT);
        db.execSQL(TABLE_CREATE_10WEEK_LEFT);
        db.execSQL(TABLE_CREATE_14WEEK_LEFT);
        db.execSQL(TABLE_CREATE_4MONTH_LEFT);
        db.execSQL(TABLE_CREATE_5MONTH_LEFT);
        db.execSQL(TABLE_CREATE_6MONTH_LEFT);
        db.execSQL(TABLE_CREATE_7MONTH_LEFT);
        db.execSQL(TABLE_CREATE_8MONTH_LEFT);
        db.execSQL(TABLE_CREATE_9MONTH_LEFT);
        db.execSQL(TABLE_CREATE_6DAY_LEFT30);
        db.execSQL(TABLE_CREATE_6WEEK_LEFT30);
        db.execSQL(TABLE_CREATE_10WEEK_LEFT30);
        db.execSQL(TABLE_CREATE_14WEEK_LEFT30);
        db.execSQL(TABLE_CREATE_4MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_5MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_6MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_7MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_8MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_9MONTH_LEFT30);
        db.execSQL(TABLE_CREATE_6DAY_RIGHT);
        db.execSQL(TABLE_CREATE_6WEEK_RIGHT);
        db.execSQL(TABLE_CREATE_10WEEK_RIGHT);
        db.execSQL(TABLE_CREATE_14WEEK_RIGHT);
        db.execSQL(TABLE_CREATE_4MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_5MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_6MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_7MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_8MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_9MONTH_RIGHT);
        db.execSQL(TABLE_CREATE_6DAY_RIGHT30);
        db.execSQL(TABLE_CREATE_6WEEK_RIGHT30);
        db.execSQL(TABLE_CREATE_10WEEK_RIGHT30);
        db.execSQL(TABLE_CREATE_14WEEK_RIGHT30);
        db.execSQL(TABLE_CREATE_4MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_5MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_6MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_7MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_8MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_9MONTH_RIGHT30);
        db.execSQL(TABLE_CREATE_SCORE_MATRIX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6DAY_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6WEEK_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_10WEEK_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_14WEEK_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_4MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_5MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_7MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_8MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_9MONTH_LEFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6DAY_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6WEEK_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_10WEEK_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_14WEEK_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_4MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_5MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_7MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_8MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_9MONTH_LEFT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6DAY_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6WEEK_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_10WEEK_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_14WEEK_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_4MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_5MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_7MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_8MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_9MONTH_RIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6DAY_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6WEEK_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_10WEEK_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_14WEEK_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_4MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_5MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_6MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_7MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_8MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_9MONTH_RIGHT30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE_MATRIX);
        onCreate(db);
    }

    /**
     * @return a hashmap containing all the patients
     */
    public PatientHashMap getAllMaleTrainPatients() {
        PatientHashMap patientHashMap = new PatientHashMap();
        EarFeature ef;
        String selectQuery = "SELECT  * FROM table_target1 WHERE t_gender = 'male'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                patientHashMap.addPatient(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d(TAG, "Returning all Male Train patients");
        return patientHashMap;
    }

    /**
     * @return a hashmap containing all the patients
     */
    public PatientHashMap getAllFemaleTrainPatients() {
        PatientHashMap patientHashMap = new PatientHashMap();
        EarFeature ef;
        String selectQuery = "SELECT  * FROM table_target1 WHERE t_gender = 'female'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                patientHashMap.addPatient(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d(TAG, "Returning all Female Train patients");
        return patientHashMap;
    }

    public ArrayList<Patient> getAllLeft30Ears() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6DAY_LEFT30;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAllTestEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM table_test";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll6DayRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6DAY_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll6WeekRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6WEEK_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll10WeekRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_10WEEK_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll14WeekRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_14WEEK_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll4MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_4MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll5MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_5MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll6MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll7MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_7MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll8MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_8MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAll9MonthRightEars() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_9MONTH_RIGHT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public ArrayList<Patient> getAllRight30Ears() {
        ArrayList<Patient> trainPatients = new ArrayList<>();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6DAY_RIGHT30;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                trainPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return trainPatients;
    }

    public Patient get6DayLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6DayRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6DayRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient getTrainPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM table_train WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6WeekRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6WeekRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get10WeekRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get14WeekRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get4MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get5MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get7MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get8MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get9MonthRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get7MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get9MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get5MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get4MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get14WeekLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get10WeekRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get14WeekRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get4MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get5MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get7MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get8MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get9MonthRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6DayLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6WeekLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6WeekLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get10WeekLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get10WeekLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get14WeekLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get4MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get5MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get6MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get7MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get8MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get8MonthLeftPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_LEFT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient get9MonthLeft30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient getRightPatient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public Patient getRight30Patient(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Patient p = new Patient();
        p.setFileName(c.getString(c.getColumnIndex(COLUMN_FILE_NAME)));
        p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        p.addFeature(ef);
        c.close();
        db.close();
        return p;
    }

    public EarFeature getLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        return ef;
    }

    public EarFeature get6DayRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        return ef;
    }

    public EarFeature get6WeekRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        return ef;
    }

    public EarFeature get10WeekRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        return ef;
    }

    public EarFeature get6DayRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6DAY_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get6WeekRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get10WeekRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_10WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get14WeekLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get14WeekRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get14WeekRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_14WEEK_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get4MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get4MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get4MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_4MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get5MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get5MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get5MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_5MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get6MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get6MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get6MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_6MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get7MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get7MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get7MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_7MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get8MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get8MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get8MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_8MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get9MonthLeft30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_LEFT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get9MonthRightPatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_RIGHT + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public EarFeature get9MonthRight30PatientFeature(String filename) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_9MONTH_RIGHT30 + " WHERE t_name = '" + filename + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        EarFeature ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
        c.close();
        db.close();
        Log.d(TAG, "Returning Train patient");
        return ef;
    }

    public ArrayList<Patient> getAll6DayLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6DAY_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll6WeekLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6WEEK_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll10WeekLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_10WEEK_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll14WeekLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_14WEEK_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll4MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_4MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll5MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_5MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll6MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_6MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll7MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_7MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll8MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_8MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<Patient> getAll9MonthLeftEars() {
        ArrayList<Patient> testPatients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        EarFeature ef;
        String selectQuery = "SELECT * FROM " + TABLE_9MONTH_LEFT;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Patient p = new Patient();
                p.setFileName(c.getString((c.getColumnIndex(COLUMN_FILE_NAME))));
                p.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                ef = new EarFeature(c.getString(c.getColumnIndex(COLUMN_FEATURE)));
                p.addFeature(ef);
                testPatients.add(p);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return testPatients;
    }

    public ArrayList<String> getTopTen(String filename) {
        //if(patient.getGender().isEmpty()) {
            ArrayList<String> topTen = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " WHERE t_left = '" +
                    filename + "' ORDER BY t_distance ASC LIMIT 10";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    topTen.add(c.getString(c.getColumnIndex(COLUMN_RIGHT)));
                } while (c.moveToNext());
            }
        c.close();
            db.close();
            Log.d(TAG, "Returning top ten matches");
            return topTen;
        /*} else {
            ArrayList<String> topTen = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            //get scores with matching gender
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " INNER JOIN table_target1 " +
                    "on table_target1.t_name = table_score_matrix.t_target WHERE t_gender='" +
                    patient.getGender() + "' AND t_source=" + patient.getFileName() + " ORDER BY t_distance ASC LIMIT 10";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    topTen.add(c.getString(c.getColumnIndex(COLUMN_TARGET)));
                } while (c.moveToNext());
            }
            db.close();
            Log.d(TAG, "Returning top ten matches");
            return topTen;
        }*/
    }

    public ArrayList<String> getTopTen(Patient patient, int threshold) {
        //if(patient.getGender().isEmpty()) {
        ArrayList<String> topTen = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " WHERE t_left = '" +
                patient.getFileName() + "' AND t_distance <= " + threshold + " ORDER BY t_distance ASC LIMIT 10";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                topTen.add(c.getString(c.getColumnIndex(COLUMN_RIGHT)));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d(TAG, "Returning top ten matches");
        return topTen;
        /*} else {
            ArrayList<String> topTen = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            //get scores with matching gender
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " INNER JOIN table_target1 " +
                    "on table_target1.t_name = table_score_matrix.t_target WHERE t_gender='" +
                    patient.getGender() + "' AND t_source=" + patient.getFileName() + " ORDER BY t_distance ASC LIMIT 10";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    topTen.add(c.getString(c.getColumnIndex(COLUMN_TARGET)));
                } while (c.moveToNext());
            }
            db.close();
            Log.d(TAG, "Returning top ten matches");
            return topTen;
        }*/
    }

    public String getTop(String filename) {
        //if(patient.getGender().isEmpty()) {
            String result = "";
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " WHERE t_left = '" +
                    filename + "' ORDER BY t_distance ASC LIMIT 1";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    result = c.getString(c.getColumnIndex(COLUMN_RIGHT));
                } while (c.moveToNext());
            }
            c.close();
            db.close();
            Log.d(TAG, "Returning top match");
            return result;
        /*} else {
            String result = "";
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " INNER JOIN table_target1 " +
                    "on table_target1.t_name = table_score_matrix.t_target WHERE t_gender ='" +
                    patient.getGender() + "' AND t_source=" + patient.getFileName() + " ORDER BY t_distance ASC LIMIT 1";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    result = c.getString(c.getColumnIndex(COLUMN_TARGET));
                } while (c.moveToNext());
            }
            db.close();
            Log.d(TAG, "Returning top match");
            return result;
        }*/
    }

    public String getTop(Patient patient, int threshold) {
        //if(patient.getGender().isEmpty()) {
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " WHERE t_left = '" +
                patient.getFileName() + "' AND t_distance <= " + threshold + " ORDER BY t_distance ASC LIMIT 1";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                result = c.getString(c.getColumnIndex(COLUMN_RIGHT));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d(TAG, "Returning top match");
        return result;
        /*} else {
            String result = "";
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " INNER JOIN table_target1 " +
                    "on table_target1.t_name = table_score_matrix.t_target WHERE t_gender ='" +
                    patient.getGender() + "' AND t_source=" + patient.getFileName() + " ORDER BY t_distance ASC LIMIT 1";
            Cursor c = db.rawQuery(selectQuery, null);
            if (c.moveToFirst()) {
                do {
                    result = c.getString(c.getColumnIndex(COLUMN_TARGET));
                } while (c.moveToNext());
            }
            db.close();
            Log.d(TAG, "Returning top match");
            return result;
        }*/
    }

    public Double getScore(Patient patientSource, Patient patientTarget) {
        Double result = 0.0;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_SCORE_MATRIX + " WHERE t_left = '" +
                patientSource.getFileName() + "' AND t_right = '" + patientTarget.getFileName() + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                result = c.getDouble(c.getColumnIndex(COLUMN_DISTANCE));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d(TAG, "Returning distance");
        return result;
    }

    public void addToScoreMatrix(Patient patientSource, Patient patientTarget, Double distance) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEFT, patientSource.getFileName());
        values.put(COLUMN_RIGHT, patientTarget.getFileName());
        values.put(COLUMN_DISTANCE, distance);
        this.getWritableDatabase().insert(TABLE_SCORE_MATRIX, null, values);
        Log.d(TAG, "Score has been added");
    }

    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
