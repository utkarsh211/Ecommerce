package com.example.utkar.ecommerce;
import android.app.NotificationManager;
import android.content.Context;
import android.app.PendingIntent;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;

import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.Calendar;

public class sampleNotification extends AppCompatActivity {

    Button button;
    ImageView img;
    Bitmap bitmap;
    String URLIMAGE="https://rukminim1.flixcart.com/flap/2500/2500/image/e7ddbf.jpg?q=80";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_notification);
        button=findViewById(R.id.notify_btn);
        img=findViewById(R.id.imageView);
        img.setVisibility(View.INVISIBLE);
        new GetImageFromURL(img).execute(URLIMAGE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle();

                style.bigPicture(bitmap);
                NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Intent resultIntent=new Intent(sampleNotification.this,saleNotification.class);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent= PendingIntent.getActivity(getApplicationContext(),(int) Calendar.getInstance().getTimeInMillis(),resultIntent,0);


                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext())
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.sterlin_select1)
                        .setContentTitle("Flat 50% off for new Users!")
                        .setContentText("Offer Valid only for the next 24 hours, Hurry Up!")
                        .setStyle(style)
                        .addAction(R.drawable.ic_launcher_foreground,"Show Offers",pendingIntent);
                notificationManager.notify(0,builder.build());

            }
        });

    }
    public class GetImageFromURL extends AsyncTask<String,Void,Bitmap>{
        ImageView imgV;
        public GetImageFromURL(ImageView imgV)
        {
            this.imgV=imgV;
        }
        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay=url[0];
            img= null;
            try{
                InputStream srt= new java.net.URL(urldisplay).openStream();
                bitmap=BitmapFactory.decodeStream(srt);
            }catch(Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            imgV.setImageBitmap(bitmap);

        }
    }



}

