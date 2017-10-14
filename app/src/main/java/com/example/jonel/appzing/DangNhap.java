package com.example.jonel.appzing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonel.appzing.main.MainActivity;
import com.example.jonel.appzing.main.register;
import com.example.jonel.appzing.model.SQLite;

public class DangNhap extends AppCompatActivity {
    private Button btnDN, regiter, qmk;
    private EditText user,pass;
    private SQLite db = new SQLite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        _anhxa();
        _Click();
    }
    public void _anhxa(){
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);
        btnDN = (Button) findViewById(R.id.btnDN);
        regiter = (Button) findViewById(R.id.regiter);
    }
//    public boolean Login(String username, String password) {
//        Cursor mCursor = db.GetData("SELECT * FROM ThanhVien WHERE MaTV like "+username+" AND password="+password);
//        if (mCursor != null) {
//            if(mCursor.getCount() > 0)
//            {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean Login1(String username, String password){
        String a="";
        String b="";
        if (username.equals(a) && password.equals(b))
            return true;
        else return false;
    }
    public void _Click(){
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = user.getText().toString();
                String pw = pass.getText().toString();
                if (Login1(tk,pw) == true){
                    Intent trangChu = new Intent(DangNhap.this, MainActivity.class);
                    startActivity(trangChu);
                }else Toast.makeText(DangNhap.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
            }
        });
        // sự kiện register
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DangKy = new Intent(DangNhap.this, register.class);
                startActivity(DangKy);
            }
        });
        // sự kiện quên mật khẩu
    }
}
