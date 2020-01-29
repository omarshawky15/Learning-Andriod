package com.example.celebritychoosinggamewebbeggining;

import android.os.AsyncTask;

public class HTMLAsync extends AsyncTask<String , Void , String> {

    @Override
    protected String doInBackground(String... strings) {
        LinksGrabbler link = new LinksGrabbler();
        return link.getHTML(strings[0]);
    }
}
