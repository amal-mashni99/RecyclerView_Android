package com.cs.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class OrderActivity extends AppCompatActivity {
    static final String url ="http://192.168.1.102/mobile/post_data.php";
    private static final String ERROR_MSG = "Google Play services are unavailable.";
    private static final int LOCATION_PERMISSION_REQUEST = 1;

    private TextView mTextView,textView1,textView2,textView3,textView4;
    Button bt;
    Button submit;
    FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    submit=findViewById(R.id.order);
    bt= findViewById(R.id.location);
    mTextView = findViewById(R.id.myLocationText);
    textView1 = findViewById(R.id.name);
    textView2= findViewById(R.id.price);
    textView3 = findViewById(R.id.count);
    textView4= findViewById(R.id.total);

       Intent n = getIntent();
       textView1.setText(n.getStringExtra("name"));
       textView2.setText(n.getIntExtra("price",0)+"");
       textView3.setText(n.getIntExtra("count",0)+"");
        textView4.setText(n.getIntExtra("price",0)*
                n.getIntExtra("count",0)+"");

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(OrderActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {


                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(OrderActivity.this
                            , new String[]{ACCESS_FINE_LOCATION}, 44);
                }
            }
        });


    }





    private void getLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(OrderActivity.this);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            Geocoder geocoder = new Geocoder(OrderActivity.this);
                            try{
                                List<Address> address = geocoder.getFromLocation(location.getLatitude(),
                                        location.getLongitude(), 1);
                                mTextView.setText(address.get(0).getAddressLine(0));
                            }catch(Exception e){
                                mTextView.setText("Cannot get Street Address!");
                            }



                        }
                    });
    }
        }







}