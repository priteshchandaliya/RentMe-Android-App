package com.sjsu.priteshchandaliya.rentme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by priteshchandaliya on 7/3/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public static final String BEDROOM_NUM = "bedroom_no";
    public static final String BATHROOM_NUM = "bathroom_no";
    public static final String AVAILABILITY = "availability";
    public static final String SR_NO = "serial_no";
    public static final String DATABASE_NAME = "floorplans_database4";
    public static final String TABLE_NAME = "floorplans_table";
    private static SQLiteDatabase db = null;


    //constructor
    public DatabaseOperations(Context context)
    {
        super(context, DATABASE_NAME, null, database_version);
        db = this.getWritableDatabase();
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        String CREATE_FLOORPLAN_TABLE = "CREATE TABLE "+ TABLE_NAME+"("+ SR_NO + " TEXT," + BEDROOM_NUM+ " TEXT,"+
                BATHROOM_NUM+" TEXT," + AVAILABILITY+ " TEXT)";
        try {
            sdb.execSQL(CREATE_FLOORPLAN_TABLE);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.d("Database operations", "Table is created");
    }

    public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2)
    {
        arg0.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(arg0);
    }

    //Insert data in a row
    public void InsertInformation (FloorPlans floorplan)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SR_NO, floorplan.getSerial_no());
        values.put(BEDROOM_NUM, floorplan.getBedroom());
        values.put(BATHROOM_NUM, floorplan.getBathroom());
        values.put(AVAILABILITY, floorplan.getAvailability());

        sdb.insert(TABLE_NAME, null, values);
        Log.d("Database operations", "Row Inserted");
        sdb.close();
    }

    // Getting one row
    public FloorPlans getFloorPlan() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        Log.d("TP", "Trying to print message");

        cursor= db.query(TABLE_NAME, new String[]{SR_NO, BEDROOM_NUM, BATHROOM_NUM, AVAILABILITY}, SR_NO + "=?", new String[]{"1"}, null, null, null, null);

        FloorPlans getFloorplan = new FloorPlans(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        //Log.d("Printing!", cursor.getString(0) + " and " +
          //      cursor.getString(1) + " and " + cursor.getString(2) + " and " + cursor.getString(3));
        return getFloorplan;
    }


}
