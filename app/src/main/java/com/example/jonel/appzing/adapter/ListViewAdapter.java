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
    public String getItem(int position) {
        return paths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            holder = new Holder();
            convertView = inflater.inflate(R.layout.activity_nghe_nhac, parent, false);
            holder.tv_song = (TextView) convertView.findViewById(R.id.tv_song);
            holder.tv_artist = (TextView) convertView.findViewById(R.id.tv_artist);
            convertView.getTag();
        }else{
            holder = (Holder)convertView.getTag();
        }
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(paths.get(position));
        String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        holder.tv_song.setText(artist);
        holder.tv_artist.setText(title);
        return convertView;
    }

    private class Holder{
        TextView tv_song;
        TextView tv_artist;
    }
}
