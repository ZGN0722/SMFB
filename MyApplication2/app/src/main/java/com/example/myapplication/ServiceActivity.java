package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.service.MyService;

public class ServiceActivity extends AppCompatActivity {
    MyService myService=null;
    private static final String TAG="myServiceTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.v(TAG, "onServiceConnected");
                myService = ((MyService.LocalBinder) iBinder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.v(TAG, "onServiceDisconnected");
            }
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button service1 = findViewById(R.id.service1);
        Button service2 = findViewById(R.id.service2);
        Button service3 = findViewById(R.id.service3);
        Button service4 = findViewById(R.id.service4);
        Button service5 = findViewById(R.id.service5);
        Button service6 = findViewById(R.id.service6);

        service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(ServiceActivity.this, MyService.class);
                //intent.putExtra("num", 10);
                //startService(intent);
                Intent intent=new Intent(ServiceActivity.this,MyService.class);
                bindService(intent,serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });
        service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(ServiceActivity.this, MyService.class);
                //stopService(intent);
                unbindService(serviceConnection);
            }
        });
        service3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myService!=null){
                    Log.v(TAG,"Using Service:9+3="+myService.add(9,3));
                }
            }
        });
        service4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myService!=null){
                    Log.v(TAG,"Using Service:9-3="+myService.sud(9,3));
                }
            }
        });
        service5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myService!=null){
                    Log.v(TAG,"Using Service:9*3="+myService.mul(9,3));
                }
            }
        });
        service6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myService!=null){
                    Log.v(TAG,"Using Service:9/3="+myService.div(9,3));
                }
            }
        });

    }
}