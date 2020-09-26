package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Target;

public class ChangeActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();
    private Fragment f =null;
    private LengthFragment lf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        lf =new LengthFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,lf).commitAllowingStateLoss();
        //返回计算器界面
        Button count = findViewById(R.id.count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //fragment菜单
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);

        text1.setOnClickListener(l);
        text2.setOnClickListener(l);
        text3.setOnClickListener(l);

}
    View.OnClickListener l = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            FragmentTransaction ft = fm.beginTransaction();
            switch (view.getId()){
                case R.id.text1:
                    f=new LengthFragment();
                    break;
                case R.id.text2:
                    f=new VolumeFragment();
                    break;
                case R.id.text3:
                    f=new SystemFragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };
}