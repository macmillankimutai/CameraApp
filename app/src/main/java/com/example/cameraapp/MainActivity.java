package com.example.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCapture;
    private ImageView imgCapture;
    private Button btnCaptured;
    private ImageView imgCaptured;
    private static final int Image_Capture_Code = 1;
    private static final int Image_Capture = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCapture = (Button) findViewById(R.id.btnTakePicture);
        imgCapture = (ImageView) findViewById(R.id.capturedImage);

        btnCaptured = (Button) findViewById(R.id.btnTakePictured);
        imgCaptured = (ImageView) findViewById(R.id.capturedImaged);

        btnCaptured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(dInt, Image_Capture);
            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt, Image_Capture_Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imgCapture.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == Image_Capture) {
            if (resultCode == RESULT_OK) {
                Bitmap db = (Bitmap) data.getExtras().get("data");
                imgCaptured.setImageBitmap(db);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}


