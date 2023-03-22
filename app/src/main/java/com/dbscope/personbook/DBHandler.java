package com.dbscope.personbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper {
    public static final String Table="Person_Details";       //Table = Contains table name "Person Details"
    public static final String colID="ID";                   //colID = Column ID
    public static final String pName="Name";                 //pName = person name
    public static final String pAge="Age";                   //pAge  = person age
    public static final String pBgrp="Blood_Group";          //pBgrp = person's blood group
    public static final String pCon="Mobile_No";             //pCon  = person's Contact no.

    public DBHandler(@Nullable Context cont){
        super(cont,"pLogBook.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String statement = "CREATE TABLE " + Table + " ( " + colID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + pName + " Text, " + pAge + " Int, " + pBgrp + " Text, " + pCon + " Text )";
        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(personDB DATASET){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues conval= new ContentValues();
        conval.put(pName, DATASET.getName());
        conval.put(pAge, DATASET.getAge());
        conval.put(pBgrp, DATASET.getBgroup());
        conval.put(pCon, DATASET.getContact());

        long insert=db.insert(Table,null,conval);
        return insert != -1;   //we can write this, instead of "if(insert==-1) return false  else return true"
    }

    public List<personDB>getEveryOne(){
        List<personDB> returnDB=new ArrayList<>();

        String query=" SELECT * FROM " + Table;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor curs = db.rawQuery(query,null);
        if(curs.moveToFirst()){
            do{
                int persID=curs.getInt(0);
                String name=curs.getString(1);
                int age=curs.getInt(2);
                String bgrp=curs.getString(3);
                String contact=curs.getString(4);
                personDB showDB = new personDB(persID,name,age,bgrp,contact);
                returnDB.add(showDB);
            }while(curs.moveToNext());
        }
        else{

        }
        curs.close();
        db.close();
        return returnDB;
    }

}
