package com.example.shravankumar.volleyapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent insaF = getIntent();
        et = (EditText)findViewById(R.id.editText_search_id);
        bt = (Button)findViewById(R.id.button_search_id);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String searchS = et.getText().toString();
        if(TextUtils.isEmpty(searchS)){
            et.setError("please enter");
            et.requestFocus();
            return;
        }
        Intent insa = new Intent(getApplicationContext(),SearchFoundActivity.class);
        insa.putExtra("result", searchS);
        startActivity(insa);
    }
}
