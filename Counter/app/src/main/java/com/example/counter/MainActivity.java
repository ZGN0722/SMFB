package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    Button add,sub,more,empty,delete,percent,division,equal,mult,point;
    TextView history,main1,main2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        delete = findViewById(R.id.delete);
        division = findViewById(R.id.division);
        more = findViewById(R.id.more);
        empty = findViewById(R.id.empty);
        equal = findViewById(R.id.equal);
        percent = findViewById(R.id.percent);
        point = findViewById(R.id.point);

        main1 = findViewById(R.id.main1);
        main2 = findViewById(R.id.main2);

        //滑动开关
        main1.setMovementMethod(ScrollingMovementMethod.getInstance());
        //左右滑动
        //main1.setHorizontallyScrolling(true);



        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num0.getText().toString());
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num1.getText().toString());
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num2.getText().toString());
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num3.getText().toString());
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num4.getText().toString());
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num5.getText().toString());
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num6.getText().toString());
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num7.getText().toString());
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num8.getText().toString());
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+num9.getText().toString());
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+mult.getText().toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+add.getText().toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+sub.getText().toString());
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+division.getText().toString());
            }
        });
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText("");
                main1.setHint("0");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main1.getText().toString().length()>0) {
                    main1.setText(main1.getText().toString().substring(0, main1.getText().toString().length() - 1));
                    if(main1.getText().toString().length()==0)
                        main1.setHint("0");
                }
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+more.getText().toString());
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+point.getText().toString());
            }
        });
        //百分号小数点
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (main1.getText().toString().length()==2)
                    main1.setText("0"+main1.getText().toString().substring(0,main1.getText().toString().length()-2)+"."+main1.getText().toString().substring(main1.getText().toString().length()-2,main1.getText().toString().length()));
                else if(main1.getText().toString().length()==1)
                    main1.setText("0"+main1.getText().toString().substring(0,main1.getText().toString().length()-1)+".0"+main1.getText().toString().substring(main1.getText().toString().length()-1,main1.getText().toString().length()));
                else
                    main1.setText(main1.getText().toString().substring(0,main1.getText().toString().length()-2)+"."+main1.getText().toString().substring(main1.getText().toString().length()-2,main1.getText().toString().length()));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString()+equal.getText().toString());
            }
        });
    }
}