package com.example.lonie.firebasenndoyeleonie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText idvalue = (EditText) rootView.findViewById(R.id.idstudent);
        final EditText namevalue = (EditText)rootView.findViewById(R.id.studentname);
        Button submit =(Button)rootView.findViewById(R.id.submitbutton);
        submit.setOnClickListener((new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Managestudent data =new Managestudent(getContext());
                data.addStudent(Integer.valueOf(idvalue.getText().toString()),namevalue.getText().toString());

            }
        }));


        return rootView;

    }
    public static class Managestudent extends SQLiteOpenHelper{

            public static String dbname="students";
            public static int dbversion = 2;

        public Managestudent(Context context) {
            super(context, dbname, null, dbversion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqldb) {
            sqldb.execSQL("CREATE TABLE students (id INTEGER PRIMARY KEY, name TEXT);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
        public  void onOpen(SQLiteDatabase sqldb){
            super.onOpen(sqldb);
        }

        public void addStudent(int id, String name){
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",name);
            values.put("id",id);
            db.insert("students",null,values);

        }
    }
}