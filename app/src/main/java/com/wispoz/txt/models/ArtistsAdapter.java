package com.wispoz.txt.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wispoz.txt.R;

import java.util.ArrayList;

/**
 * Created by wispoz on 21.06.16.
 */
public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {
    private ArrayList<Artists> artist;

    public ArtistsAdapter(ArrayList<Artists> artist) {
        this.artist = artist;
    }
    public ArrayList<Artists> getArtist(){
        return artist;
    }
    @Override
    public ArtistsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artists_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistsAdapter.ViewHolder viewHolder, int i) {

        viewHolder.artistname.setText(artist.get(i).getArtistname());
        viewHolder.last_viewed.setText(artist.get(i).getLast_viewed());

       }

    @Override

    public int getItemCount() {
        return artist.size();
     }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView artistname, last_viewed;
        public ViewHolder(View view) {
           super(view);
            artistname = (TextView) view.findViewById(R.id.artistname);
            last_viewed = (TextView) view.findViewById(R.id.last_viewed);
        }

    }

}
