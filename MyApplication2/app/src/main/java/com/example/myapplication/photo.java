package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class photo extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Button button = findViewById(R.id.photo_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {    //设备上有相机
                    Log.d(TAG,"照相1");
                    dispatchTakePictureIntent();
                }
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imageView = findViewById(R.id.photo_image);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            Log.d(TAG,"照相2");
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}