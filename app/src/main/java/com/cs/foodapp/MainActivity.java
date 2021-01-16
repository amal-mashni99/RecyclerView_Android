package com.cs.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


//import com.google.android.material.appbar.AppBarLayout;



public class MainActivity extends AppCompatActivity {
    static final String url ="http://192.168.1.102/mobile/get_data.php";
    static final String imgPath ="http://192.168.1.102/mobile/img/";

    ArrayList<Food> foods = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private  RecyclerView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         r = findViewById(R.id.recyclerView);
        r.setLayoutManager(new LinearLayoutManager(this));

        getProducts ();

    }

    private void getProducts (){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array

                                JSONObject product = array.getJSONObject(i);

                                String img= imgPath+(String) product.get("img");
                                String name = (String) product.get("Name");
                                String des= (String) product.get("Description");
                                int price= (int) product.get("Price");

                                Food f=new Food(img,name,des,price);
foods.add(f);
                            }
Food.foods =foods;
                            //creating adapter object and setting it to recyclerview
                            CustomAdapter adapter = new CustomAdapter(foods);
                            r.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);



    }
}