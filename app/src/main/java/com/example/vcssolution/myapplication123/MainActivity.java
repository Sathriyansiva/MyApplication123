package com.example.vcssolution.myapplication123;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b1,b2,b3,b4,b5;
    TextView tv;
    ArrayList<Samplepojo> arrayList =new ArrayList<Samplepojo>();
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.edt_id);
        et2=(EditText) findViewById(R.id.edt_name);
        et3=(EditText) findViewById(R.id.edt_email);
        b1=(Button) findViewById(R.id.btn_insert);
        b2=(Button) findViewById(R.id.btn_update);
        b3=(Button) findViewById(R.id.btn_delete);
        b4=(Button) findViewById(R.id.btn_select);
        b5=(Button) findViewById(R.id.btn_selectall);
        tv=(TextView)findViewById(R.id.textView4);
        l=(ListView) findViewById(R.id.lv1);
        final Adapterclass a=new Adapterclass(MainActivity.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
                a.insert(et2.getText().toString(),et3.getText().toString());
                a.close();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
                a.Update(Integer.parseInt(et1.getText().toString()),et2.getText().toString(),et3.getText().toString());
                a.close();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
                a.delete(Integer.parseInt(et1.getText().toString()));
                a.close();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
                Cursor c=a.select(Integer.parseInt(et1.getText().toString()));
                if(c.moveToFirst())
                {
                    String S1,S2,S3;
                    S1=c.getString(0);
                    S2=c.getString(1);
                    S3=c.getString(2);
                    Toast.makeText(MainActivity.this, S1+"\n"+S2+"\n"+S3, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Value not Found",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.open();
                Cursor c=a.selectAll();

//                ArrayAdapter<String>a1;
//                String S1,S2,S3;
//                String list[]={S1+"\n"+S2+"\n"+S3};
//                a1=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
                while (c.moveToNext())
                {
                    String S1,S2,S3;
                    S1=c.getString(0);
                    S2=c.getString(1);
                    S3=c.getString(2);

                    Toast.makeText(MainActivity.this, S1+"\n"+S2+"\n"+S3, Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(MainActivity.this, Listactivity.class);
//                    startActivity(intent);
                      //tv.setText(S1+"\n"+S2+"\n"+S3);
                }
            }
        });
    }


    public void movenext(View view)
    {
//        Intent intent = new Intent(MainActivity.this, Listactivity.class);
//        intent.putExtra("arraylist",arrayList);
//        startActivity(intent);
        int size=arrayList.size();
     for(int i=0;i<size;i++)
       {
           String s = arrayList.toArray().toString();
           Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
        }
        }
    }



