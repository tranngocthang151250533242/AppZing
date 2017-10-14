package com.example.jonel.appzing.main;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.jonel.appzing.R;

import java.util.ArrayList;
import java.util.List;


public class NgheNhac extends AppCompatActivity {

    private static final String TAG = NgheNhac.class.getSimpleName();
    private ListView listSing;
    private ListSingAdapter listSingAdapter;
    private List<AudioPlayer> audioList;
    private View view;
    private Context mContext;

    NgheNhac ngheNhat;

    public List<AudioPlayer> getListAudioPlayer() {
        //dua ra cac bai hat co trong may
        List<AudioPlayer> players = new ArrayList<>();
        Uri uri; // get con tro file(Uri) den bang audio
        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] m_data = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
//                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA};
//lay ra ra contro cursor tro den tung hang
        Cursor c = mContext.getContentResolver().query(uri, m_data, MediaStore.Audio.Media.IS_MUSIC + "=1", null,
                MediaStore.Audio.Media.TITLE + " ASC");
        if (c == null || c.getCount() == 0) {
            return players;
        }
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String title, album, artist, path;
//            int duration;
            title = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
            album = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
            artist = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
//            duration = (int) (c.getInt(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
            path = c.getString(c.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
            AudioPlayer ap = new AudioPlayer(path, title, artist, album);
            players.add(ap);
        }
        return players;
//        if ( c == null || c.getCount() == 0) {
//            return players;
//        }
//        int indexData = c.getColumnIndex(MediaStore.Audio.Media.DATA);
//        int indexName = c.getColumnIndex(MediaStore.Audio.Media.TITLE);
//        int indexDuration = c.getColumnIndex(MediaStore.Audio.Media.DURATION);
//        int indexAlbum = c.getColumnIndex(MediaStore.Audio.Media.ALBUM);
//        int indexArtist = c.getColumnIndex(MediaStore.Audio.Media.ARTIST);
//        c.moveToFirst();
//
//        while ( !c.isAfterLast() ) {
//            String data = c.getString(indexData);
//            String name = c.getString(indexName);
//            int duration = c.getInt(indexDuration);
//            String album = c.getString(indexAlbum);
//            String artist = c.getString(indexArtist);
//
//            //them phan tu AudioPlayer vao list
//            players.add(new AudioPlayer(data, name, artist,album, duration));
//
//            //tro den hang tiep theo
//            c.moveToNext();
//        }
//        return players;
    }

    public void setAudioList(List<AudioPlayer> audioList) {
        this.audioList = audioList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_nhac);
        initsView(view);
        getViews();
    }

    public void initsView(View view) {

        Log.d("NgheNhac", "initsView");

        ngheNhat=new NgheNhac();
        ngheNhat.setAudioList(getListAudioPlayer());

        //set adapter
        listSingAdapter = new ListSingAdapter(getContext(), audioList);
        listSing = view.findViewById(R.id.list_sing); //(ListView)
        listSing.setAdapter(listSingAdapter);

    }

    public Context getContext() {
        return mContext;
    }

    protected int getViews() {
        return R.layout.activity_ds_nhac;
    }

}
