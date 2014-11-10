package com.flatiron.beats.net;

import android.content.Context;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class Beats {

    // ===== Singleton =====

    private static Beats sInstance = null;

    /**
     * Gets an instance of the Beats
     */
    public static BeatsAPI api(Context context)
    {
        if(sInstance == null)
        {
            sInstance = new Beats(context);
        }
        return sInstance.getAPI();
    }

    // ===== Class =====

    private BeatsAPI mAPI;

    /**
     * Actually creates an instance of the Beats API
     */
    private Beats(Context context)
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BeatsAPI.BASE_API)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addQueryParam("client_id", BeatsAPI.CLIENT_ID);
                    }
                })
                .build();

        mAPI = restAdapter.create(BeatsAPI.class);
    }

    /**
     * Returns an instance of the BeatsAPI
     */
    public BeatsAPI getAPI()
    {
        return mAPI;
    }
}

