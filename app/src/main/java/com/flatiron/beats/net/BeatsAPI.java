package com.flatiron.beats.net;

import com.flatiron.beats.net.responses.Base;
import com.flatiron.beats.net.responses.components.Album;
import com.flatiron.beats.net.responses.components.Artist;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface BeatsAPI {

    public static final String BASE_API = "https://partner.api.beatsmusic.com/v1";
    public static final String CLIENT_ID = "";

    @GET("/api/artists")
    public void getArtists(
        @Query("offset") Integer offset,
        @Query("limit") Integer limit,
        Callback<Base<Artist>> callback
    );

    @GET("/api/artists/{artist_id}/albums")
    public void getArtistAlbums(
        @Path("artist_id") String artist_id,
        Callback<Base<Album>> callback
    );

}

