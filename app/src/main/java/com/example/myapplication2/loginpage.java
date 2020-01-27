package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class loginpage extends AppCompatActivity {

    Camera camera;
    FrameLayout frameLayout;
    showcamera showcamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        camera= Camera.open();
        frameLayout= (FrameLayout)findViewById(R.id.frame);

        showcamera = new showcamera(this,camera);
        frameLayout.addView(showcamera);



    }

    Camera.PictureCallback mpicturecallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {


            File picture_file = getOutputMediaFile();

            if(picture_file == null)
            {
                return;
            }
            else {
                try {
                    FileOutputStream fu = new FileOutputStream(picture_file);
                    fu.write(data);
                    fu.close();

                    camera.startPreview();

                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    };

    private File getOutputMediaFile() {
        String state = Environment.getExternalStorageState();
        if(!state.equals(Environment.MEDIA_MOUNTED))
        {
            return null;
        }
        else
        {
            File folder1= new File( Environment.getExternalStorageDirectory()+ File.separator + "Image");
            if(folder1.exists())
            {
                folder1.mkdirs();
            }
            File outputfile = new File(folder1,"temp.jpg");
            return outputfile;
        }

    }

    public  void captureimage (View v)
    {
        if(camera!=null)
            camera.takePicture(null,null,mpicturecallback);

    }
}
