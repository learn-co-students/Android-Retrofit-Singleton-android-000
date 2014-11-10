package com.flatiron.beats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.flatiron.beats.R;
import com.flatiron.beats.net.responses.components.Album;
import com.flatiron.beats.views.AlbumListElement;

import java.util.List;

public class AlbumsAdapter extends ArrayAdapter<Album> {

    public AlbumsAdapter(Context context, int resource, List<Album> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlbumListElement view = (AlbumListElement) convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = (AlbumListElement) inflater.inflate(R.layout.albums_list_element, parent, false);
        }

        Album album = getItem(position);
        if (album != null) {
            view.setAlbumTitle(album.title);
        }

        return view;
    }

}
