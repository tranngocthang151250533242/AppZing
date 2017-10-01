package com.example.jonel.appzing.adapter;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jonel.appzing.R;

import java.util.ArrayList;

/**
 * Created by jonel on 10/1/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<String> paths;
    private Context context;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context,ArrayList<String> paths ) {
        this.context = context;
        this.paths = paths;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public String getItem(int i) {
        return paths.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null){
            holder = new Holder();
            view = inflater.inflate(R.layout.activity_nghe_nhac, viewGroup, false);
            holder.tv_song = (TextView) view.findViewById(R.id.tv_song);
            holder.tv_artist = (TextView) view.findViewById(R.id.tv_artist);
            view.getTag(i); // để Holder không được đang để i tạm thời
        }else{
            holder = (Holder)view.getTag();
        }
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(paths.get(i));
        String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        holder.tv_song.setText(artist);
        holder.tv_artist.setText(title);
        return null;
    }
    private class Holder{
        TextView tv_song;
        TextView tv_artist;
    }
}
