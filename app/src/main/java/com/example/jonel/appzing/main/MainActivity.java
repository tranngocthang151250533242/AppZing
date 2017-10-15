package com.example.jonel.appzing.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jonel.appzing.R;


public class MainActivity extends AppCompatActivity {
    private TextView tvBaiHat;
    private LinearLayout thongtin;
    private Button caNhan,trangChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        _anhxa();
        _Click();
//        _run();
        // tạo bản
//        db.QueryData("CREATE TABLE IF NOT EXISTS " +
//                "ThanhVien(MaTV TEXT PRIMARY KEY, MatKhau TEXT, TenTV TEXT)");
        // insert
//        db.QueryData("INSERT INTO ThanhVien VALUES('NgocThang','123','Trần Ngọc Thắng')");

        // sự kiện đăng nhập

    }
    public void _Click(){
        // sự kiện register
        tvBaiHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nghenhac = new Intent(MainActivity.this, NgheNhac.class);
                startActivity(nghenhac);
            }
        // sự kiện quên mật khẩu
    });
        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangNhap = new Intent(MainActivity.this, DangNhap.class);
                startActivity(dangNhap);
            }
            // sự kiện quên mật khẩu
        });

        trangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trangChu = new Intent(MainActivity.this, TrangChu.class);
                startActivity(trangChu);
            }
        });
    }
    public void _anhxa(){
        tvBaiHat = (TextView) findViewById(R.id.tvBH);
        thongtin = (LinearLayout) findViewById(R.id.thongtin);
        caNhan = (Button)findViewById(R.id.CaNhan);
        trangChu = (Button)findViewById(R.id.TrangChu);
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
