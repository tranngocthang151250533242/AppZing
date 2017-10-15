package com.example.jonel.appzing.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jonel.appzing.R;
import com.example.jonel.appzing.model.SQLite;

public class TrangChu extends AppCompatActivity {
    private Button caNhan;
    private SQLite db = new SQLite(this);
    String SQL = "SELECT * FROM thanhvien";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        caNhan = (Button)findViewById(R.id.CaNhan);
        caNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ttCaNhan = new Intent(TrangChu.this, MainActivity.class);
                startActivity(ttCaNhan);
            }
        });

    }


}
