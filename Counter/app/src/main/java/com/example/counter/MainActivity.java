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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "test";

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button add, sub, more1,more2, empty, delete, percent, division, equal, mult, point;
    Button sin,cos,tan,lg,ln,xy,e,tx,x1;
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

        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        lg = findViewById(R.id.lg);
        ln = findViewById(R.id.ln);
        xy = findViewById(R.id.xy);
        e = findViewById(R.id.e);
        tx = findViewById(R.id.tx);
        x1 = findViewById(R.id.x1);

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
                    if(main1.getText().toString().charAt(main1.getText().toString().length()-2) == 'l')
                        main1.setText(main1.getText().toString().substring(0, main1.getText().toString().length() - 2));
                    else if(main1.getText().toString().charAt(main1.getText().toString().length()-1) == 'n'
                            || main1.getText().toString().charAt(main1.getText().toString().length()-1) == 's')
                        main1.setText(main1.getText().toString().substring(0, main1.getText().toString().length() - 3));
                    else
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
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString()+sin.getText().toString());
                    //main2.setText(String.valueOf((int) Math.sin(Math.PI/2)));
                }
            });
            cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + cos.getText().toString());
                }
            });
            tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + tan.getText().toString());
                }
            });
            lg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString()+lg.getText().toString());
                    //main2.setText(String.valueOf((int) Math.sin(Math.PI/2)));
                }
            });
            ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + ln.getText().toString());
                }
            });
            xy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + xy.getText().toString());
                }
            });
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + String.valueOf(Math.E));
                }
            });
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + "√");
                }
            });
            x1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    main1.setText(main1.getText().toString() + "!");
                    cal(main1.getText().toString());
                }
            });
        }
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
        //Log.d(tag, numArray[0]);
        Log.d(tag, numArray[0]);
        for (int i=0;i<numArray.length;i++)
            if(numArray[i].charAt(0)=='s' ||numArray[i].charAt(0)=='c' || numArray[i].charAt(0)=='t')
                sct(numArray,i);
            else if(numArray[i].charAt(0)=='l')
                let(numArray,i);
            else if(numArray[i].contains("^"))
                nl(numArray,i);
            else if(numArray[i].contains("√")) {
                double tx = Double.parseDouble(numArray[i].substring(1));
                tx = Math.sqrt(tx);
                numArray[i]=String.valueOf(tx);
            }
            else if(numArray[i].contains("!")) {
                int x1 = Integer.parseInt(numArray[i].substring(0,numArray[i].length()-1));
                Log.d(tag, String.valueOf(x1));
                int s = 1;
                for(int j =1 ;j<=x1;j++)
                    s=s*j;
                numArray[i]=String.valueOf(s);
            }
        if(numArray.length<2) {
            //Log.d(tag, "结束");
            main2.setText("="+numArray[0]);
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
                        //Log.d(tag, "8");
                        cal(s1, s2);
                        s2.push(charArray[charPointer-1]);
                    }

                    break;
            }
        }
        if(s1.size()==2)
            cal(s1,s2);
        while(true) {
            //Log.d(tag, String.valueOf(s1.peek().charAt(s1.peek().length() - 1)));
            if (s1.peek().charAt(s1.peek().length() - 1) == '0' ) {
                if(s1.peek().charAt(s1.peek().length() - 2) == '.') {
                    st1 = s1.peek().substring(0, s1.peek().length() - 2);
                    s1.pop();
                    s1.push(st1);
                    break;
                }
                //Log.d(tag, "省略");
                st1 = s1.peek().substring(0, s1.peek().length() - 1);
                s1.pop();
                s1.push(st1);
            } else {
                //这里有问题
                break;
            }
        }
        Log.d(tag, String.valueOf(s1.peek().length()));
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
                s1.push(String.valueOf(BigDecimal.valueOf(Double.parseDouble(s1.pop())).multiply(BigDecimal.valueOf(Double.parseDouble(s1.pop())))));
                break;
            case "÷":
                Log.d(tag, "除法");
                double a = Double.parseDouble(s1.pop());
                double b = Double.parseDouble(s1.pop());
                //Log.d(tag, String.valueOf(b)+"/"+String.valueOf(a));
                s1.push(String.valueOf(BigDecimal.valueOf(b).divide(BigDecimal.valueOf(a),5)));
                //Log.d(tag, s1.peek());
                break;
            case "＋":
                Log.d(tag, "加法");
                s1.push(String.valueOf(BigDecimal.valueOf(Double.parseDouble(s1.pop())).add(BigDecimal.valueOf(Double.parseDouble(s1.pop())))));
                break;
            case "－":
                Log.d(tag, "减法");
                double c = Double.parseDouble(s1.pop());
                double d = Double.parseDouble(s1.pop());
                s1.push(String.valueOf(BigDecimal.valueOf(d).subtract(BigDecimal.valueOf(c))));
                break;
        }
        return 0;
    }

    public void sct(String[] numArray, int i) {
        switch (numArray[i].charAt(0)){
            case 's':
                double x1 = Math.sin((Math.toRadians(Double.parseDouble(numArray[i].substring(3)))));
                BigDecimal x2 = new BigDecimal(x1);
                x1 = x2.setScale(15, RoundingMode.HALF_UP).doubleValue();
                numArray[i] = String.valueOf(x1);
                break;
            case 'c':
                double y1 = Math.cos((Math.toRadians(Double.parseDouble(numArray[i].substring(3)))));
                BigDecimal y2 = new BigDecimal(y1);
                y1 = y2.setScale(15, RoundingMode.HALF_UP).doubleValue();
                numArray[i] = String.valueOf(y1);
                break;
            case 't':
                double z1 = Math.tan((Math.toRadians(Double.parseDouble(numArray[i].substring(3)))));
                BigDecimal z2 = new BigDecimal(z1);
                z1 = z2.setScale(15, RoundingMode.HALF_UP).doubleValue();
                numArray[i] = String.valueOf(z1);
                break;
        }
    }
    public void let(String[] numArray, int i) {
        switch (numArray[i].charAt(1)){
            case 'g':
                double x1 = Math.log10(Double.parseDouble(numArray[i].substring(2)));
                BigDecimal x2 = new BigDecimal(x1);
                x1 = x2.setScale(15, RoundingMode.HALF_UP).doubleValue();
                numArray[i] = String.valueOf(x1);
                break;
            case 'n':
                double z1 = Math.log(Double.parseDouble(numArray[i].substring(2)))/Math.log(Math.E);
                BigDecimal z2 = new BigDecimal(z1);
                z1 = z2.setScale(15, RoundingMode.HALF_UP).doubleValue();
                numArray[i] = String.valueOf(z1);
                break;
        }
    }
    //°
    public void nl(String[] numArray, int i) {
        double nt1=0,nt2=0;
        for(int j=0;j<numArray[i].length();j++) {
            if (numArray[i].charAt(j) == '^') {
                nt1 = Double.parseDouble(numArray[i].substring(0, j));
                nt2 = Double.parseDouble(numArray[i].substring(j+1));
                break;
            }
        }
        Log.d(tag, String.valueOf(nt1));
        Log.d(tag, String.valueOf(nt2));
        //Log.d(tag, Arr[1]+"1");
        double nt = Math.pow(nt1,nt2);
        BigDecimal nt3 = new BigDecimal(nt);
        nt = nt3.setScale(15, RoundingMode.HALF_UP).doubleValue();
        numArray[i] = String.valueOf(nt);
    }
}