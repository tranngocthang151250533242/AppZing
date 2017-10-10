package com.example.jonel.appzing.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonel.appzing.DangNhap;
import com.example.jonel.appzing.R;

import static com.example.jonel.appzing.R.id.btnChuyen;


public class MainActivity extends AppCompatActivity {
    private Button next;
    private TextView imgBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    public void _Click(){
        // sự kiện register
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DangKy = new Intent(MainActivity.this, DangNhap.class);
                startActivity(DangKy);
            }
        });
        imgBaiHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DangKy = new Intent(MainActivity.this, DangNhap.class);
                startActivity(DangKy);
            }
        // sự kiện quên mật khẩu
    });
    }
    public void _anhxa(){
        next = (Button) findViewById(btnChuyen);
        imgBaiHat = (TextView) findViewById(R.id.tvBaiHat);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
