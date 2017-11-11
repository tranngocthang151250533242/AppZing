package com.example.jonel.appzing.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonel.appzing.JSON.JSONParser;
import com.example.jonel.appzing.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class DangNhap extends AppCompatActivity {
    private Button btnDN, regiter, qmk;
    private EditText user, pass;
    String tk;
    String pw;
    String userID = "";
    String userPassword = "";
    String MangTV[];
    //    private SQLite db = new SQLite(this);
    private static String url = "https://117accept.000webhostapp.com/display.php";
    // JSON Node names
    private static final String TAG_CONTACTS = "accounts";
    private static final String TAG_USER = "acc_user";
    private static final String TAG_PASS = "acc_pwd";
    // contacts JSONArray
    JSONArray contacts = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        _anhxa();
        _Click();
    }


    public void _anhxa() {
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


    public void _Click() {
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tk = user.getText().toString();     // lấy giá trị trong EditText
                pw = pass.getText().toString();
                ChayJSON();
                String a = "", b = "";
                if (a.equals(tk) || b.equals(pw))
                    Toast.makeText(DangNhap.this, "Không được để trống tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                else if (tk.equals(userID) & pw.equals(userPassword)) {
                    Toast.makeText(DangNhap.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();
                    Intent trangChu = new Intent(DangNhap.this, MainActivity.class);
                    startActivity(trangChu);
                } else Toast.makeText(DangNhap.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
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
//    public boolean Login(String username, String password){
//        String SQL = "SELECT * FROM thanhvien WHERE maVung = "+"'"+username+"'"+" AND SDT="+"'"+password+"'";
//            if (db.check(SQL)==true)
//                return true;
//            else    return false;
//    }

    // Json
    public void ChayJSON() {
        JSONParser jsonparse = new JSONParser();
        //lay doi tuong json
        JSONObject jsonobject = jsonparse.getJSONFromUrl(url);

        try {
            //tao mang contacts
            contacts = jsonobject.getJSONArray(TAG_CONTACTS);

            //duyet tung contacts
            for (int i = 0; i < contacts.length(); i++) {
                //lay ra mot doi tuong contact
                JSONObject onecontact = contacts.getJSONObject(i);

                //lay du lieu
                userID = onecontact.getString(TAG_USER);
                userPassword = onecontact.getString(TAG_PASS);
                // check tài khoản mật khẩu để đá ra khỏi vòng for với giá trị user pass
                if (userID.equals(tk) & pw.equals(userPassword)) {
                    break;
                }
                //so phone la la json Object
//                JSONObject phone=onecontact.getJSONObject(TAG_PHONE);
//                String mobile=phone.getString(TAG_PHONE_MOBILE);
//                String home=phone.getString(TAG_PHONE_HOME);
//                String office=phone.getString(TAG_PHONE_OFFICE);
                Log.d("dulieu", "user: " + user + " pass:" + pass);
            }

        } catch (Exception e) {
            Log.d("loi", e.toString());
        }

    }
}
