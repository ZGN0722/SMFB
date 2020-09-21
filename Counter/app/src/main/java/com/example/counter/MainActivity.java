package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
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
    Button add, sub, more1,more2, empty, delete, percent, division, equal, mult, point;
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
        more1 = findViewById(R.id.more1);
        more2 = findViewById(R.id.more2);
        empty = findViewById(R.id.empty);
        equal = findViewById(R.id.equal);
        percent = findViewById(R.id.percent);
        point = findViewById(R.id.point);

        main1 = findViewById(R.id.main1);
        main2 = findViewById(R.id.main2);
        history = findViewById(R.id.history);

        //滑动开关
        main1.setMovementMethod(ScrollingMovementMethod.getInstance());
        history.setMovementMethod(ScrollingMovementMethod.getInstance());
        //左右滑动
        //main1.setHorizontallyScrolling(true);


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num0.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num1.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num2.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num3.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num4.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num5.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num6.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num7.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num8.getText().toString());
                cal(main1.getText().toString());
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + num9.getText().toString());
                cal(main1.getText().toString());
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
                main2.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (main1.getText().toString().length() > 0) {
                    main1.setText(main1.getText().toString().substring(0, main1.getText().toString().length() - 1));
                    main2.setText("="+main1.getText().toString());
                    if (main1.getText().toString().length() == 0) {
                        main1.setHint("0");
                        main2.setText("");
                    }
                }
            }
        });
        more1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + more1.getText().toString());
            }
        });
        more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1.setText(main1.getText().toString() + more2.getText().toString());
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
                history.setText(history.getText()+""+main1.getText()+""+main2.getText()+"\n");
                main1.setText(main2.getText().toString().substring(1,main2.getText().toString().length()));
            }
        });
    }

    public String cal(String str) {
        String st1="";
        String st2="";
        for(int i =0;i<str.length();i++) {
            if ( str.charAt(i)!='(' && str.charAt(i)!=')')
                st1 = st1 + str.charAt(i);
        }
        for(int i =0;i<str.length();i++) {
            if ( str.charAt(i)=='×' || str.charAt(i)=='÷' || str.charAt(i)=='＋' || str.charAt(i)=='－' || str.charAt(i)=='(' || str.charAt(i)==')')
                st2 = st2 + str.charAt(i);
        }
        String[] numArray = st1.split("[×÷－＋]");
        String[] charArray = st2.split("");

        if(numArray.length<2) {
            Log.d(tag, "结束");
            main2.setText(numArray[0]);
            return "";
        }
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        //Log.d(tag, String.valueOf(charArray.length));
        //Log.d(tag, String.valueOf(numArray.length));
        int numPointer = 0;
        int charPointer = 0;
        if(charArray[charPointer].equals("(")){
            s1.push(numArray[numPointer]);
            s1.push(numArray[numPointer+1]);
            s2.push(charArray[charPointer]);
            charPointer++;
            s2.push(charArray[charPointer]);
        } else {
            s1.push(numArray[numPointer]);
            s1.push(numArray[numPointer+1]);
            s2.push(charArray[charPointer]);
        }
        /*s1.push(numArray[numPointer]);
        s1.push(numArray[numPointer+1]);
        s2.push(charArray[charPointer]);
         */
        numPointer=2;
        charPointer++;
        while (charPointer<charArray.length || numPointer<numArray.length){
            //Log.d(tag, "0");
            switch (charArray[charPointer]) {
                case "×":
                case "÷":
                    if(s2.peek().equals("÷")){
                        cal(s1, s2);
                        s1.push(numArray[numPointer]);
                        s2.push(charArray[charPointer]);
                        charPointer++;
                        numPointer++;
                    } else {
                        s1.push(numArray[numPointer]);
                        s2.push(charArray[charPointer]);
                        numPointer++;
                        charPointer++;
                        cal(s1, s2);
                    }
                    break;
                //Log.d(tag, "2");
                //Log.d(tag, "3");
                case "＋":
                case "－":
                    if(s2.peek().equals("(")){
                        s1.push(numArray[numPointer]);
                        s2.push(charArray[charPointer]);
                        numPointer++;
                        charPointer++;
                        cal(s1, s2);
                    }else {
                        cal(s1, s2);
                        s1.push(numArray[numPointer]);
                        s2.push(charArray[charPointer]);
                        numPointer++;
                        charPointer++;
                    }
                    break;
                case "(":
                    s2.push(charArray[charPointer]);
                    charPointer++;
                    break;
                case ")":
                    if(s2.peek().equals("(") || s2.peek().equals(")"))
                        s2.pop();
                    else {
                        String chat= s2.pop();
                        s2.pop();
                        s2.push(chat);
                    }
                    charPointer++;
                    if(charPointer<=charArray.length) {
                        Log.d(tag, "8");
                        cal(s1, s2);
                        s2.push(charArray[charPointer-1]);
                    }

                    break;
            }
        }
        if(s1.size()==2)
            cal(s1,s2);
        if(s1.peek().charAt(s1.peek().length()-1)=='0' && s1.peek().charAt(s1.peek().length()-2)=='.') {
            st1 = s1.peek().substring(0, s1.peek().length() - 2);
            s1.pop();
            s1.push(st1);
        }
        if(Double.parseDouble(s1.peek())<0) {
            st2 = s1.peek().replace('-', '－');
            s1.pop();
            s1.push(st2);
        }
        main2.setText("="+s1.peek());
        return "";
    }
    public double cal(Stack<String> s1,Stack<String> s2) {
        switch (s2.pop()){
            case "×":
                Log.d(tag, "乘法");
                s1.push(String.valueOf(Double.parseDouble(s1.pop())*Double.parseDouble(s1.pop())));
                break;
            case "÷":
                Log.d(tag, "除法");
                double a = Double.parseDouble(s1.pop());
                double b = Double.parseDouble(s1.pop());
                //Log.d(tag, String.valueOf(b)+"/"+String.valueOf(a));
                s1.push(String.valueOf(b/a));
                //Log.d(tag, s1.peek());
                break;
            case "＋":
                Log.d(tag, "加法");
                s1.push(String.valueOf(Double.parseDouble(s1.pop())+Double.parseDouble(s1.pop())));
                break;
            case "－":
                Log.d(tag, "减法");
                double c = Double.parseDouble(s1.pop());
                double d = Double.parseDouble(s1.pop());
                s1.push(String.valueOf(d-c));
                break;
        }
        return 0;
    }
}