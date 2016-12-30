package com.example.vcssolution.myapplication123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by VCSSolution on 12/29/2016.
 */

public class CustomAdaptor  extends BaseAdapter {
    Context cts;
    ArrayList<Samplepojo> als;
    LayoutInflater li;
    public CustomAdaptor(Context cts,ArrayList<Samplepojo> als) {
        this.cts=cts;
        this.als=als;
        li=LayoutInflater.from(cts);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VIEWHOLDER vh;
//        View rowview = null;

        if (convertView == null) {
            convertView = li.inflate(R.layout.custom, null);
            vh = new VIEWHOLDER();
            vh.t1 = (TextView) convertView.findViewById(R.id.textView);
            vh.t2 = (TextView) convertView.findViewById(R.id.textView2);
            vh.t3 = (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(vh);

        } else {
            vh = (VIEWHOLDER) convertView.getTag();
        }
        if (als!=null) {
            Samplepojo st=als.get(position);

            vh.t1.setText(st.getS1());
            vh.t2.setText(st.getS2());
            vh.t3.setText(st.getS3());

        }
        return convertView;

    }
    static class VIEWHOLDER{
TextView t1,t2,t3;
    }
}
