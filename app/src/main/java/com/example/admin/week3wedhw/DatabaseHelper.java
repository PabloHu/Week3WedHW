package com.example.admin.week3wedhw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admin on 9/13/2017.
 */


import java.util.List;

/**
 * Created by Admin on 9/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    List<Animal> animalList=new ArrayList<>();

    private static final String DATABASE_NAME="myAnimalsDatabase";
    private static final int DATABASE_VERSION=2;
    public static final String TABLE_NAME="Animal";

    public static final String ANIMAL_ID ="ID";
    public static final String ANIMAL_NAME ="Name";
    public static final String ANIMAL_TYPE ="Type";
    public static final String ANIMAL_AGE ="Age";
    public static final String ANIMAL_WEIGHT ="Weight";
    public static final String ANIMAL_IMAGE ="Image";
    public static final String KIWI_TIMESTAMP ="TimeStamp";
    private static final String TAG = "DatabaseTAG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       // String Truncate = "TRUNCATE TABLE "+ TABLE_NAME;
        //sqLiteDatabase.execSQL(Truncate);
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
                ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ANIMAL_NAME + " CHAR(50) NOT NULL," +
                ANIMAL_TYPE + " CHAR(50)," +
                ANIMAL_AGE + " INT," +
                ANIMAL_WEIGHT + " INT," +
                ANIMAL_IMAGE + " INT," +
                KIWI_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: ");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        Log.d(TAG, "onUpgrade: ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //CREATE
    public void createAnimal(String animalName, String animalType, int animalAge, int animalWeight, int animalImage){
        Log.d(TAG, "create: "+"Start");
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ANIMAL_NAME, animalName);
            contentValues.put(ANIMAL_TYPE, animalType);
            contentValues.put(ANIMAL_AGE, animalAge);
            contentValues.put(ANIMAL_WEIGHT, animalWeight);
            contentValues.put(ANIMAL_IMAGE, animalImage);

            long rowNumber = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            Log.d(TAG, "createAnimal completed: "+rowNumber);
        }
        catch(Exception e){
            Log.d(TAG, "create err: "+e);
        }
    }

    //READ
    public List<Animal> readAllAnimalsInformation(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT "+
                ANIMAL_ID + ", "+
                ANIMAL_NAME + ", "+
                ANIMAL_TYPE+", " +
                ANIMAL_AGE+", " +
                ANIMAL_WEIGHT+", " +
                ANIMAL_IMAGE+", " +
                KIWI_TIMESTAMP +" FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        animalList.clear();

        Animal animalObject;
        if (cursor.moveToFirst()) {
            do {

                animalObject = new Animal();
                animalObject.setANIMAL_ID(cursor.getInt(0));
                animalObject.setANIMAL_NAME(cursor.getString(1));
                animalObject.setANIMAL_TYPE(cursor.getString(2));
                animalObject.setANIMAL_AGE(cursor.getInt(3));
                animalObject.setANIMAL_WEIGHT(cursor.getInt(4));
                animalObject.setANIMAL_IMAGE(cursor.getInt(5));
                animalObject.setKIWI_TIMESTAMP(cursor.getString(6));
                animalList.add(animalObject);

                Log.d(TAG, "getContacts: " +
                        "ID: " + cursor.getString(0) +
                        " name: " + cursor.getString(1) +
                        " type: " + cursor.getString(2) +
                        " age: " + cursor.getString(3) +
                        " weight: " + cursor.getString(4) +
                        " image: " + cursor.getString(5) +
                        " TimeStamp: " + cursor.getString(6));

            } while (cursor.moveToNext());
        }

        for (int i = 0; i < animalList.size() ; i++) {
            Log.d(TAG, "getForSpinner:  ID:"+ animalList.get(i).getANIMAL_ID()+
                    " NAME: " + animalList.get(i).getANIMAL_NAME());
        }
        return animalList;
    }

/*
    //UPDATE
    public void updateKiwi(int id, String firstName, String lastName, int cell, String note){

        Log.d(TAG, "updateKiwi id: " + id);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE "+ TABLE_NAME+ " SET " +
                KIWI_FIRSTNAME+ " = '"+ firstName +"', "+
                KIWI_LASTNAME+ " = '"+ lastName +"', "+
                KIWI_CELL+ " = '"+ cell +"', "+
                KIWI_NOTE+ " = '"+ note +"' "+
                "WHERE " + KIWI_ID + " = " + id;
        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "updateKiwi work");
        }
        catch (Exception e){
            Log.d(TAG, "updateKiwi err: " + e.toString());
        }
    }
*/
    //DELETE
    public void delete(int id)
    {
        Log.d(TAG, "deleteid: " + id);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "DELETE FROM "+ TABLE_NAME+ " WHERE " + ANIMAL_ID + " = " + id;

        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "DeleteKiwi work");
        }
        catch (Exception e){
            Log.d(TAG, "DeleteKiwi err: " + e.toString());
        }

    }
}
