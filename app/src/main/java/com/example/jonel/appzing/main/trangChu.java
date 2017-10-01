package com.example.jonel.appzing.main;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonel.appzing.R;
import com.example.jonel.appzing.adapter.ListViewAdapter;

import java.io.File;
import java.util.ArrayList;

public class trangChu extends AppCompatActivity {
    private ListView lvListMusic;
    private ImageView ivPlay,ivNext,ivPre,ivRepeat,ivPause;
    private TextView tvTimeCurrent,tvTimeTotal;
    private SeekBar sbProTime;
    private ArrayList<String> Paths; // lưu tất cả đường dẫn của bài hát
    private int timeTotal, timeProcess;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        _anhxa();
        _click();
//        initComponents();

    }
    public void _anhxa(){
        lvListMusic = (ListView)findViewById(R.id.lv_ms);
        // ánh xạ ImageView
        ivNext = (ImageView)findViewById(R.id.next);
        ivPause = (ImageView)findViewById(R.id.pause);
        ivPre = (ImageView)findViewById(R.id.back);
        ivRepeat = (ImageView)findViewById(R.id.repeat);
        ivPlay = (ImageView)findViewById(R.id.play);

        // ánh xạ TextView
        tvTimeCurrent = (TextView)findViewById(R.id.time1);
        tvTimeTotal = (TextView)findViewById(R.id.time2);
        sbProTime = (SeekBar)findViewById(R.id.SeekBar);

    }
    // bắt sự kiện
    public void _click(){
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(trangChu.this, "Next", Toast.LENGTH_SHORT).show();
            }
        });
        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(trangChu.this, "Pause", Toast.LENGTH_SHORT).show();
            }
        });
        ivPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(trangChu.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(trangChu.this, "Play", Toast.LENGTH_SHORT).show();
            }
        });
        ivRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(trangChu.this, "Repeat", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // đọc file
    public void initList(){
        Paths = new ArrayList<>();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Zing MP3";
        File file = new File(path);
        File files[] = file.listFiles(); // lấy tất cả các file trong thư mục
        for (int i = 1; i<= files.length; i++){
            // đọc tất cả các file có trong Downloads thêm vào list nhạc
            String s = files[i].getName();
            if (s.endsWith(".mp3")){ // kiểm tra phải đuôi mp3 không
                Paths.add(files[i].getAbsolutePath());
            }
        }
    }
    public void initComponents(){
        initList();
        adapter = new ListViewAdapter(getApplicationContext(), Paths);
        lvListMusic.setAdapter(adapter);
    }
}
