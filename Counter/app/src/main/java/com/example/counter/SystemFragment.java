package com.example.counter;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class SystemFragment extends Fragment {
    @Nullable
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button delete,empty;
    private static final String tag = "test";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.system,null);
        final Spinner spinner1 = view.findViewById(R.id.sys_spin_one);
        final Spinner spinner2 = view.findViewById(R.id.sys_spin_two);
        final TextView length1 = view.findViewById(R.id.sys_length1);
        final TextView length2 = view.findViewById(R.id.sys_length2);

        num0 = view.findViewById(R.id.sys_num0);
        num1 = view.findViewById(R.id.sys_num1);
        num2 = view.findViewById(R.id.sys_num2);
        num3 = view.findViewById(R.id.sys_num3);
        num4 = view.findViewById(R.id.sys_num4);
        num5 = view.findViewById(R.id.sys_num5);
        num6 = view.findViewById(R.id.sys_num6);
        num7 = view.findViewById(R.id.sys_num7);
        num8 = view.findViewById(R.id.sys_num8);
        num9 = view.findViewById(R.id.sys_num9);

        delete = view.findViewById(R.id.sys_delete);
        empty = view.findViewById(R.id.sys_empty);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( !length1.getText().toString().equals("")) {
                    length1.setText(change(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), length2.getText().toString()));
                    length2.setText(change(spinner2.getSelectedItem().toString(), spinner1.getSelectedItem().toString(), length1.getText().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( !length1.getText().toString().equals("")) {
                    length2.setText(change(spinner2.getSelectedItem().toString(), spinner1.getSelectedItem().toString(), length1.getText().toString()));
                    length1.setText(change(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), length2.getText().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num0.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num1.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num2.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num3.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num4.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num5.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num6.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num7.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num8.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString() + num9.getText().toString());
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText(length2.getText().toString().substring(0,length2.getText().toString().length()-1));
                length1.setText(change(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),length2.getText().toString()));
            }
        });
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length2.setText("");
                length1.setText("");
            }
        });

        return view;

    }

    public String change(String str1, String str2,String length){
        String lenCha = "";
        if(length.equals(""))
            return lenCha;
        Log.d(tag,str1+str2);
        switch (str2){
            case "二进制":
                switch (str1){
                    case "二进制":
                        lenCha=length;
                        break;
                    case "八进制":
                        lenCha=Integer.toOctalString(Integer.valueOf(length,2));
                        break;
                    case "十进制":
                        lenCha=String.valueOf(Integer.valueOf(length,2));
                        break;
                    case "十六进制":
                        lenCha=Integer.toHexString(Integer.valueOf(length,2));
                        break;
                }
                break;
            case "八进制":
                switch (str1){
                    case "二进制":
                        lenCha=Integer.toBinaryString(Integer.valueOf(length,8));
                        break;
                    case "八进制":
                        lenCha=length;
                        break;
                    case "十进制":
                        lenCha=String.valueOf(Integer.valueOf(length,8));
                        break;
                    case "十六进制":
                        lenCha=Integer.toHexString(Integer.valueOf(length,8));
                        break;
                }
                break;
            case "十进制":
                switch (str1){
                    case "二进制":
                        lenCha=Integer.toBinaryString(Integer.valueOf(length));
                        break;
                    case "八进制":
                        lenCha=Integer.toOctalString(Integer.valueOf(length));
                        break;
                    case "十进制":
                        lenCha=length;
                        break;
                    case "十六进制":
                        lenCha=Integer.toHexString(Integer.valueOf(length));
                        break;
                }
                break;
            case "十六进制":
                switch (str1){
                    case "二进制":
                        lenCha=Integer.toBinaryString(Integer.valueOf(length,16));
                        break;
                    case "八进制":
                        lenCha=Integer.toOctalString(Integer.valueOf(length,16));
                        break;
                    case "十进制":
                        lenCha=String.valueOf(Integer.valueOf(length,16));
                        break;
                    case "十六进制":
                        lenCha=length;
                        break;
                }
                break;
        }
        return lenCha;
    }
}
