package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Worker extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        //其它代码略
        final TextView textView = (TextView) findViewById(R.id.Worker_text);
        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                textView.setText(msg.arg1+"是素数");
            }
            /*handler.post(new Runnable(){
                @Override
                public void run() {
                textView.setText("123");
            }*/

        };
        final Runnable myWorker = new Runnable() {
            @Override
            public void run() {
                //int progress = 0;
                /*while(progress <= 100){
                    Message msg = new Message();
                    msg.arg1 = progress;
                    handler.sendMessage(msg);
                    progress += 10;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message msg = handler.obtainMessage();
                new Message();
                msg.arg1 = -1;*/
                int i = 1;
                while(i <=10) {
                    for(int j=1; j<=i; j++) {
                        Message msg = new Message();;
                        if (i % j == 0 && j != 1 && j != i) {
                            break;
                        }
                        if(j==i) {
                            msg.arg1 = i;
                            handler.sendMessage(msg);
                        }
                    }
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Button Worker_button = findViewById(R.id.Worker_button);
        Worker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread workThread = new Thread(null, myWorker, "WorkThread");
                workThread.start();
            }
        });
    }
}


