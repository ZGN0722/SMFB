package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SPActivity extends AppCompatActivity {
    private final static String SharedPreferencesFileName="config";
    private final static String Key_UserName="UserName";
    private final static String Key_LoginDate="LoginDate";
    private final static String Key_UserType="UserType";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private String MyFileName ="NewTextFile.txt";
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p);

        preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor = preferences.edit();
        Button btnWrite = (Button) findViewById(R.id.write);
        Button btnRead = (Button) findViewById(R.id.read);
        Button buttonAll = findViewById(R.id.read1);

        /*btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strLoginDate = simpleDateFormat.format(new Date());
                editor.putString(Key_UserName, "张桂宁");
                editor.putString(Key_LoginDate, strLoginDate);
                editor.putInt(Key_UserType, 2018011263);
                Toast.makeText(SPActivity.this, "已保存学生信息" , Toast.LENGTH_LONG).show();
                editor.apply();
            }
        });*/
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream fileOutputStream = openFileOutput(MyFileName, MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String content = "名字：张桂宁  学号：2018011263";
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                        Toast.makeText(SPActivity.this, "已保存信息", Toast.LENGTH_LONG).show();
                    } finally {
                        if (out != null)
                            out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /*btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                String strLoginDate = preferences.getString(Key_LoginDate, null);
                int nUserType=preferences.getInt(Key_UserType,0);
                if (strUserName != null && strLoginDate != null)
                    Toast.makeText(SPActivity.this, "名字:" + strUserName +"学号:"+nUserType, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SPActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });*/
        btnRead.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                InputStream in = null;
                try {
                    FileInputStream fileInputStream = openFileInput(MyFileName);
                    in = new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while ((c = in.read()) != -1) {
                            stringBuilder.append((char) c);
                        }
                        Toast.makeText(SPActivity.this, new String(stringBuilder.toString().getBytes(StandardCharsets.ISO_8859_1), "UTF-8"), Toast.LENGTH_LONG).show();
                    } finally {
                        if (in != null)
                            in.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        buttonAll.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext()) {
                    String msg;
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    msg = "id:" + id;
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    msg = msg + " name:" + name;

                    Cursor phoneNumbers = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id, null, null);
                    while (phoneNumbers.moveToNext()) {
                        String phoneNumber = phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        msg = msg + " phone:" + phoneNumber;
                    }

                    Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + id, null, null);
                    while (emails.moveToNext()) {
                        String email = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        msg = msg + " email:" + email;
                    }
                    Log.i("tag", msg);
                }
            }
        });
    }

}