package com.flatiron.beats.net.responses.components;

import java.io.Serializable;

public class Artist implements Serializable{
    public String type;
    public String id;
    public String name;
    public int popularity;
    public boolean streamable;
    public int total_albums;
    public int total_singles;
    public int total_eps;
    public int total_lps;
    public int total_freeplays;
    public int total_compilations;
    public int total_tracks;
    public boolean verified;
    public int total_follows;
    public int total_followed_by;
}

