package com.example.jonel.appzing.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// phần function
public class SQLite extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="qldangnhap";
    private static final String TABLE_NAME="thanhvien";
    private static final String ID="id";
    private static final String MAVUNG="maVung";
    private static final String SDT="SDT";
    private static int VERSION= 1;
    private String SQLQuery = "CREATE TABLE "+TABLE_NAME+" ("+
            ID+" INTEGER PRIMARY KEY, "+
            MAVUNG+" TEXT, "+
            SDT + " TEXT)";
    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    // truy vấn không trả kết quả
    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    // truy vấn có kết quả
    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    // insert database
    public void AddThanhVien(Login login){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAVUNG, login.getMaVung());
        values.put(SDT, login.getSDT());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
