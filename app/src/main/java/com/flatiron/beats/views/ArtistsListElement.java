package com.flatiron.beats.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flatiron.beats.R;

public class ArtistsListElement extends RelativeLayout {

    private TextView mArtistName;
    private TextView mArtistAlbums;

    public ArtistsListElement(Context context) {
        super(context);
    }

    public ArtistsListElement(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ArtistsListElement(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        getViews();
    }

    private void getViews()
    {
        mArtistName = (TextView) findViewById(R.id.artist_name);
        mArtistAlbums = (TextView) findViewById(R.id.artist_albums);
    }

    public void setArtistName(String name)
    {
        mArtistName.setText(name);
    }

    public void setArtistAlbumCount(int albumCount)
    {
        String albumString = "";
        albumString += albumCount;
        if(albumCount != 1)
        {
            albumString += " Albums >";
        }
        else
        {
            albumString += " Album >";
        }

        mArtistAlbums.setText(albumString);
    }

}
