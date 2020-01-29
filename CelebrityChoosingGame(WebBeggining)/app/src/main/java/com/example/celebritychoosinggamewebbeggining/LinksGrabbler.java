package com.example.celebritychoosinggamewebbeggining;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinksGrabbler {
    public LinksGrabbler() {
    }

    public String getHTML(String link) {
        String s = "";
        URL url;
        HttpURLConnection urlConnection;
        InputStream in;
        try {
            url = new URL(link);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int i = in.read();
            while (i != -1) {
                s += (char) i;
                i = in.read();
            }
        } catch (Exception e) {
            return null;
        }
        return s;
    }

    public Bitmap getImage(String link) {
        Bitmap bitmap;
        URL url;
        HttpURLConnection urlConnection;
        InputStream in;
        try {
            url = new URL(link);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            return null;
        }
        return bitmap;
    }
}
