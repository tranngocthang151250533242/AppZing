package com.example.jonel.appzing.JSON;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Ngọc Thắng on 11/11/2017.
 */

public class JSONParser {
    InputStream is=null;
    JSONObject jobj=null;
    String json;

    public JSONObject getJSONFromUrl(String url)
    {
        try{
            //khoi tao
            DefaultHttpClient client=new DefaultHttpClient();
            HttpPost httppost=new HttpPost(url);

            //thuc thi , lay ve noi dung
            HttpResponse httpresponse=client.execute(httppost);
            HttpEntity httpentity=httpresponse.getEntity();
            is=httpentity.getContent();

            //doc du lieu
            BufferedReader reader=
                    new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb=new StringBuilder();
            String line=null;
            while((line=reader.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            is.close();
            json=sb.toString(); //doc StringBuilder vao chuoi

            jobj=new JSONObject(json); //dua chuoi vao doi tuong json

        }catch(Exception e)
        {
            Log.d("loi", e.toString());
        }
        return jobj;
    }
}
