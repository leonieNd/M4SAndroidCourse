package com.example.lonie.firebasenndoyeleonie;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String id;
    private String name;
    EditText idvalue = null;
    EditText namevalue = null;
    Button submit;
    DatabaseReference rootref;
    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        idvalue = (EditText) rootView.findViewById(R.id.idstudent);
        namevalue = (EditText)rootView.findViewById(R.id.studentname);
        submit =(Button)rootView.findViewById(R.id.submitbutton);
        rootref = FirebaseDatabase.getInstance().getReference();
        submit.setOnClickListener((new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Managestudent data =new Managestudent(getContext());
                data.addStudent(Integer.valueOf(idvalue.getText().toString()),namevalue.getText().toString());
                id=idvalue.getText().toString().trim();
                name=namevalue.getText().toString().trim();
                Student newstudent = new Student(id,name);
                rootref.push().setValue(newstudent);
            }
        }));



        return rootView;

    }
    public  class Config extends Application {
        @Override
        public void onCreate(){
            super.onCreate();
            Firebase.setAndroidContext(this);

        }

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