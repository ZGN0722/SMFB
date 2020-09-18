package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "test";

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button add, sub, more, empty, delete, percent, division, equal, mult, point;
    TextView history, main1, main2;

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
        history = findViewById(R.id.history);

        //滑动开关
        main1.setMovementMethod(ScrollingMovementMethod.getInstance());
        //左右滑动
        //main1.setHorizontallyScrolling(true);


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num0.getText().toString());
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num1.getText().toString());
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num2.getText().toString());
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num3.getText().toString());
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num4.getText().toString());
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num5.getText().toString());
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num6.getText().toString());
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num7.getText().toString());
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num8.getText().toString());
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num9.getText().toString());
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + mult.getText().toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + add.getText().toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + sub.getText().toString());
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + division.getText().toString());
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
                if (main1.getText().toString().length() > 0) {
                    main1.setText(main1.getText().toString().substring(0, main1.getText().toString().length() - 1));
                    if (main1.getText().toString().length() == 0)
                        main1.setHint("0");
                }
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + more.getText().toString());
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + point.getText().toString());
            }
        });
        //百分号小数点
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double i = Double.parseDouble(main1.getText().toString()) / 100;
                main1.setText(String.valueOf(i));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal(main1.getText().toString());
            }
        });
    }

    public String cal(String str) {
        String[] numArray = str.split("[＋÷×－]");
        String[] charArray = str.split("[1234567890.] *");
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        Log.d(tag, String.valueOf(charArray.length));
        Log.d(tag, String.valueOf(""));

        for (int i = 0; i < numArray.length; i++)
            s1.push(numArray[i]);
        for (int i = 1; i < charArray.length; i++)
            s2.push(charArray[i]);
        //Log.d(tag, String.valueOf(s2.elementAt(0)));
        //Log.d(tag, String.valueOf(s2.elementAt(1)));
        double i = 0;
        if ("＋".equals(s2.pop())) {
            while (!s2.isEmpty()) {
                if (s2.peek().equals("×")){
                    String st = s1.pop();
                    Log.d(tag, "乘法");
                    i = Double.parseDouble(s1.pop()) * Double.parseDouble(s1.pop());
                    s1.push(String.valueOf(i));
                    s1.push(st);
                    s2.pop();
                } else if (s2.peek().equals("÷")) {
                    String st = s1.pop();
                    Log.d(tag, "除法");
                    double a = Double.parseDouble(s1.pop());
                    i = 1 / a;
                    s1.push(String.valueOf(i));
                    s1.push(st);
                    s2.pop();
                    s2.push("×");
                } else if (s2.peek().equals("－")) {
                    Log.d(tag, "减法");
                    i = Double.parseDouble(s1.pop()) - Double.parseDouble(s1.pop());
                    s1.push(String.valueOf(i));
                    s2.pop();
                } else if (s2.peek().equals("＋")) {
                    Log.d(tag, "加法");
                    i = Double.parseDouble(s1.pop()) + Double.parseDouble(s1.pop());
                    s1.push(String.valueOf(i));
                    s2.pop();
                } else
                    s2.pop();
            }
            Log.d(tag, "结果");
            i = Double.parseDouble(s1.pop()) + Double.parseDouble(s1.pop());
            main2.setText(String.valueOf(i));
        }
        return "";
    }
}