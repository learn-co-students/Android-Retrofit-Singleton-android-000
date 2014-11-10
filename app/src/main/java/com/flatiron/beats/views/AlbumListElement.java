package com.flatiron.beats.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flatiron.beats.R;

public class AlbumListElement extends RelativeLayout {

    private TextView mAlbumTitle;

    public AlbumListElement(Context context) {
        super(context);
    }

    public AlbumListElement(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AlbumListElement(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        getViews();
    }

    private void getViews()
    {
        mAlbumTitle = (TextView) findViewById(R.id.album_name);
    }

    public void setAlbumTitle(String title)
    {
        mAlbumTitle.setText(title);
    }

}
