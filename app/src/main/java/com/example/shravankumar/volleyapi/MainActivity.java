package com.example.shravankumar.volleyapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private String jsonResponse;

    String[] str1;


    RecyclerView recyclerView;
    StaggeredGridLayoutManager staggeredGridLayoutManagerVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        staggeredGridLayoutManagerVertical = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManagerVertical);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest req = new JsonArrayRequest("http://172.37.33.10:81/App/public/getDocs",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("ViewFrag", "Worked! " + response.toString());

                        try {
                            jsonResponse = "";
                            int j;

                            for (j = 0;j < response.length();j++){
                            }
                            Log.e("ViewFragm test1", "! " +j +j +"  ");
                            str1 = new String[j];String[] NAMES = new String[j];String[] ANAMES = new String[j];
                            int[] IMAGES = new int[j];

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject person = (JSONObject) response.get(i);
                                //String name = person.getString("id");
                                String name = person.getString("name");
                                String type = person.getString("type");
                                String author_name = person.getString("author_name");
                                NAMES[i]=name;
                                ANAMES[i]=author_name;
                                if (type.equals("txt")){
                                    IMAGES[i] = R.drawable.txtphoto;
                                }
                                else {
                                    IMAGES[i] = R.drawable.pdfphoto;
                                }

                                Log.e("ViewFragm", "Worked! " +name);
                            }
                            MyDataAdapter myDataAdapter = new MyDataAdapter(MainActivity.this,NAMES,ANAMES,IMAGES);
                            recyclerView.setAdapter(myDataAdapter);
                            myDataAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Array is out of Bounds"+e);
                            Log.e("ViewFragmao", "Worked! " + "array o b");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ViewFrag", "Didnt work" + error.getMessage());
            }
        });
        queue.add(req);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_menu_id) {
            Intent inm = new Intent(getApplicationContext(),SearchActivity.class);
            startActivity(inm);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
