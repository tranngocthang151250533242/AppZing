package com.example.jonel.appzing.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.jonel.appzing.R;

public class register extends AppCompatActivity {
    private SQLite db = new SQLite(this, "quanLyDangNhap.sqlite", null ,1);
    private Button btnDK;
    private EditText user,pw,tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        user = (EditText)findViewById(R.id.user);
//        pw = (EditText)findViewById(R.id.pass);
//        tt = (EditText)findViewById(R.id.tentk);
//        btnDK = (Button)findViewById(R.id.btnDN);



    }
}
