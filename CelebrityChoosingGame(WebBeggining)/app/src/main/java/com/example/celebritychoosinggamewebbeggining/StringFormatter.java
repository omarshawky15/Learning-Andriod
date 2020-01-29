package com.example.celebritychoosinggamewebbeggining;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {
    Matcher m;
    Pattern p;
    String regex;
    String s, found;
    ArrayList<String> arr;
    int i = -1;
    String link, name;

    public StringFormatter(String regex) {
        p = Pattern.compile(regex);
    }

    public void setString(String s) {
        this.s = s;
        m = p.matcher(s);
        arr = new ArrayList<>();
        while (m.find()) {
            arr.add(m.group(1));
        }
        p = Pattern.compile("\"(.*?)\"");
        i = 0;
    }

    public boolean next() {
        if (i != -1 && i != arr.size()) {
            m = p.matcher(arr.get(i));
            i++;
            if (m.find())
                link = m.group(1);
            else link = "";
            if (m.find())
                name = m.group(1);
            else name = "";
            return true;
        } else return false;
    }

    public String getLink() {
            return link;
    }

    public String getName() {
       return name ;
    }
}
