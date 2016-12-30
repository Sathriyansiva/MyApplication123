package com.example.vcssolution.myapplication123;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listactivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Samplepojo> als = new ArrayList<Samplepojo>();
    CustomAdaptor ca;
    Adapterclass ListAdapter;
    SQLiteDatabase db;
    Cursor cursor;

    //    private GoogleApiClient client;
//sqliteheloer adap
//    sqlite list cust
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);
       lv=(ListView)findViewById(R.id.listView);
        Intent pass = getIntent();
//        als = pass.getSerializableExtra("arraylist");
//        als=method();
       ca=new  CustomAdaptor (this,als);
//
////        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        lv.setAdapter(new CustomAdaptor(this, als));
//
//
//    }
//    private ArrayList<Samplepojo> method() {
//        ArrayList<Samplepojo> als_als=new ArrayList<>();
//        for(int i=0;i<s1.length;i++)
//        {
//            Samplepojo sp=new Samplepojo();
//            sp.setS1(s1[i]);
//            sp.setS2(s2[i]);
//            sp.setI(s3[i]);
//            als_als.add(sp);
//        }
//        return als_als;
    }

  }