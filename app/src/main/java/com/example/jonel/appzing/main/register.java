package com.example.jonel.appzing.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonel.appzing.R;
import com.example.jonel.appzing.model.Login;
import com.example.jonel.appzing.model.SQLite;


public class register extends AppCompatActivity {
    private Button btnDK;
    private EditText TaiKhoan,MatKhau,ReMatKhau;
    private SQLite db = new SQLite(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        _anhxa();
        _click();



    }
    public void _anhxa(){
        TaiKhoan = (EditText)findViewById(R.id.TaiKhoan);
        MatKhau = (EditText)findViewById(R.id.MatKhau);
        ReMatKhau = (EditText)findViewById(R.id.RMatKhau);
        btnDK = (Button)findViewById(R.id.btnDK);
    }
    public void _click(){
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taiKhoan = TaiKhoan.getText().toString();
                String sdt = String.valueOf(TaiKhoan.getText());
                String a="",b="";
                Login add = CreateThanhVien();
                // kiểm tra nếu tạo Thành viên null thì báo lỗi còn kho
                if (a.equals(taiKhoan)||b.equals(sdt)){
                    Toast.makeText(register.this, "Bạn chưa nhập đủ thông tin!!!", Toast.LENGTH_SHORT).show();
                }
//                else   if(checkTK(maVung)==true)
//                    Toast.makeText(register.this, "Số điện thoại đã tồn tại!!!", Toast.LENGTH_SHORT).show();
                else
                    if(add!=null){
                        db.AddThanhVien(add);
                        Toast.makeText(register.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent DangNhap = new Intent(register.this, DangNhap.class);
                        startActivity(DangNhap);
                    }
                    else Toast.makeText(register.this, "Lỗi !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // hàm tạo tài khoản
    private Login CreateThanhVien(){
        String taiKhoan = TaiKhoan.getText().toString();
        String matKhau = String.valueOf(MatKhau.getText());
        Login register = new Login(taiKhoan,matKhau);
        return register;
    }
    public boolean checkTK(String sdt){
        String SQL = "SELECT * FROM thanhvien WHERE maVung = "+"'"+sdt+"'"+"";
        if (db.check(SQL)==true)
            return true;
        else    return false;
    }


}
