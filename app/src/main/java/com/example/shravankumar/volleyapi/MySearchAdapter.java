package com.example.shravankumar.volleyapi;

/**
 * Created by shravankumar on 15-04-2016.
 */
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

public class MySearchAdapter extends RecyclerView.Adapter<MySearchAdapter.ViewHolder> {
    public String[] NAMES3;
    public String[] ANAMES3;
    public int[] IMAGES3;
    ArrayList<String> mylist = new ArrayList<String>();


    static Activity activity;

    public MySearchAdapter(Activity activity, String[] NAMES2, String[] ANAMES2, int[] IMAGES2) {
        this.NAMES3 = NAMES2;
        this.ANAMES3 = ANAMES2;
        this.IMAGES3 = IMAGES2;
        this.activity = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_custom1, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.info_textView.setText(NAMES_DATA[position]);
        holder.tv_nameS.setText(NAMES3[position]);
        holder.tv_anameS.setText(ANAMES3[position]);
        holder.imvS.setImageResource(IMAGES3[position]);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return NAMES3.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nameS,tv_anameS;
        ImageView imvS;

        public ViewHolder(View view) {
            super(view);
            this.tv_nameS = (TextView) view.findViewById(R.id.name_idS);
            this.imvS = (ImageView) view.findViewById(R.id.imv_idS);
            this.tv_anameS = (TextView)view.findViewById(R.id.authorName_idS);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(activity, info_textView.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }}
