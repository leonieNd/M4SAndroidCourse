package com.example.lonie.firebasenndoyeleonie;

/**
 * Created by Léonie on 01/08/2016.
 */
public class Student {

    String id;
    String name;

    public Student(String id, String name) {
        this.id=id;
        this.name = name;
    }


    public Student(){
        this.id="0";
        this.name="thename";
    }

    public String getId(){ return id;}
    public String  getName(){return name;}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
