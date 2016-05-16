package com.example.shravankumar.volleyapi;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.ViewHolder> {
    public String[] NAMES2;
    public String[] ANAMES2;
    public int[] IMAGES2;
    ArrayList<String> mylist = new ArrayList<String>();


    static Activity activity;

    public MyDataAdapter(Activity activity, String[] NAMES1, String[] ANAMES1, int[] IMAGES1) {
        this.NAMES2 = NAMES1;
        this.ANAMES2 = ANAMES1;
        this.IMAGES2 = IMAGES1;
        this.activity = activity;
        }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_custom, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.info_textView.setText(NAMES_DATA[position]);
        holder.tv_name.setText(NAMES2[position]);
        holder.tv_aname.setText(ANAMES2[position]);
        holder.imv.setImageResource(IMAGES2[position]);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return NAMES2.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_aname;
        ImageView imv;

        public ViewHolder(View view) {
            super(view);
            this.tv_name = (TextView) view.findViewById(R.id.name_id);
            this.imv = (ImageView) view.findViewById(R.id.imv_id);
            this.tv_aname = (TextView)view.findViewById(R.id.authorName_id);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(activity, info_textView.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }}
