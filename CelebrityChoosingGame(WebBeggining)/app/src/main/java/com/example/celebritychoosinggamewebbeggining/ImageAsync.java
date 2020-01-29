package com.example.celebritychoosinggamewebbeggining;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class ImageAsync extends AsyncTask<String ,Void , Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        LinksGrabbler link = new LinksGrabbler();
        return link.getImage(strings[0]);
    }
}
