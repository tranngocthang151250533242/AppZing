package com.example.jonel.appzing.main;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonel.appzing.R;
import com.example.jonel.appzing.model.SQLite;


public class MainActivity extends AppCompatActivity {
    private Button btnDN, regiter, qmk;
    private EditText user,pass;
    private SQLite db = new SQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _anhxa();
        _Click();
//        _run();
        // tạo bản
//        db.QueryData("CREATE TABLE IF NOT EXISTS " +
//                "ThanhVien(MaTV TEXT PRIMARY KEY, MatKhau TEXT, TenTV TEXT)");
        // insert
//        db.QueryData("INSERT INTO ThanhVien VALUES('NgocThang','123','Trần Ngọc Thắng')");

        Toast.makeText(this, "Chào bạn đến với ứng dụng!!!", Toast.LENGTH_SHORT).show();
        // sự kiện đăng nhập

    }
    public boolean Login(String username, String password) {
        Cursor mCursor = db.GetData("SELECT * FROM ThanhVien WHERE MaTV like "+username+" AND password="+password);
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }
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
                    Intent trangChu = new Intent(MainActivity.this, trangChu.class);
                    startActivity(trangChu);
                }else Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
            }
        });
        // sự kiện register
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DangKy = new Intent(MainActivity.this, register.class);
                startActivity(DangKy);
            }
        });
        // sự kiện quên mật khẩu
    }
    public void _anhxa(){
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);
        btnDN = (Button) findViewById(R.id.btnDN);
        regiter = (Button) findViewById(R.id.regiter);
    }
    // Đọc file từ internet
//    private String docNoiDung_Tu_URL(String theUrl){
//        StringBuilder content = new StringBuilder();
//        try    {
//            // create a url object
//            URL url = new URL(theUrl);
//
//            // create a urlconnection object
//            URLConnection urlConnection = url.openConnection();
//
//            // wrap the urlconnection in a bufferedreader
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            String line;
//
//            // read from the urlconnection via the bufferedreader
//            while ((line = bufferedReader.readLine()) != null){
//                content.append(line + "\n");
//            }
//            bufferedReader.close();
//        }
//        catch(Exception e)    {
//            e.printStackTrace();
//        }
//        return content.toString();
//    }
//    class docJSON extends AsyncTask<String, Integer, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            return docNoiDung_Tu_URL(params[0]);
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//        }
//    }
//    public void _run(){
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                new docJSON().execute("http://117accept.000webhostapp.com/json.php");
//            }
//        });
//    }
}
