package com.flatiron.beats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.flatiron.beats.R;
import com.flatiron.beats.net.responses.components.Artist;
import com.flatiron.beats.views.ArtistsListElement;

import java.util.ArrayList;

public class ArtistsAdapter extends ArrayAdapter<Artist> {

    public ArtistsAdapter(Context context, int resource, ArrayList<Artist> items){
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArtistsListElement view = (ArtistsListElement) convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = (ArtistsListElement) inflater.inflate(R.layout.artists_list_element, parent, false);
        }

        final Artist artist = getItem(position);
        if(artist != null)
        {
            view.setArtistAlbumCount(artist.total_albums);
            view.setArtistName(artist.name);
        }

        return view;
    }

}
