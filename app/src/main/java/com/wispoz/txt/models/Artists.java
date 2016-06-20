package com.wispoz.txt.models;

/**
 * Created by wispoz on 13.06.16.
 */
public class Artists {
    String id;
    String artistname;
    String last_viewed;
    public Artists(String artistname, String last_viewed) {
        this.artistname = artistname;
        this.last_viewed = last_viewed;
    }
}
