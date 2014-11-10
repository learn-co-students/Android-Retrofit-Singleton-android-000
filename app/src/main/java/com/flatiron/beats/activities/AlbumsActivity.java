package com.flatiron.beats.activities;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.flatiron.beats.R;
import com.flatiron.beats.adapters.AlbumsAdapter;
import com.flatiron.beats.net.Beats;
import com.flatiron.beats.net.responses.Base;
import com.flatiron.beats.net.responses.components.Album;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AlbumsActivity extends ListActivity {

    public static String TAG = ArtistsActivity.class.getCanonicalName();
    public static final String EXTRA_ARTIST_ID = "artist-id";
    private Context mContext;
    private AlbumsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        mContext = getApplicationContext();

        // Preparing list adapter
        mAdapter = new AlbumsAdapter(mContext, R.layout.albums_list_element, new ArrayList<Album>());
        setListAdapter(mAdapter);

        // Getting artist ID + getting albums
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String artistID = extras.getString(EXTRA_ARTIST_ID);
            getAlbums(artistID);
        }
    }

    private void getAlbums(String artistID)
    {
        Beats.api(mContext).getArtistAlbums(artistID, new Callback<Base<Album>>() {
            @Override
            public void success(Base<Album> albumBase, Response response) {
                mAdapter.addAll(albumBase.data);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });
    }

}
