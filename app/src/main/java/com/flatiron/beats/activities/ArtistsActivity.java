package com.flatiron.beats.activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.flatiron.beats.R;
import com.flatiron.beats.adapters.ArtistsAdapter;
import com.flatiron.beats.net.Beats;
import com.flatiron.beats.net.responses.Base;
import com.flatiron.beats.net.responses.components.Artist;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ArtistsActivity extends ListActivity {

    public static String TAG = ArtistsActivity.class.getCanonicalName();
    private Context mContext;
    private ArtistsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        mContext = getApplicationContext();

        // Preparing list adapter
        mAdapter = new ArtistsAdapter(getApplicationContext(), R.layout.artists_list_element, new ArrayList<Artist>());
        setListAdapter(mAdapter);

        // Setting onClick
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Artist artist = mAdapter.getItem(position);

                Intent i = new Intent(getApplicationContext(), AlbumsActivity.class);
                i.putExtra(AlbumsActivity.EXTRA_ARTIST_ID, artist.id);
                startActivity(i);
            }
        });

        // Getting artists to populate the adapter
        getArtists();
    }

    private void getArtists()
    {
        Beats.api(mContext).getArtists(0, 10, new Callback<Base<Artist>>() {
            @Override
            public void success(Base<Artist> artists, Response response) {
                mAdapter.addAll(artists.data);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });
    }

}
