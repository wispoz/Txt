package com.wispoz.txt.views.artists;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.wispoz.txt.R;

/**
 * Created by wispoz on 12.06.16.
 */
public class ArtistsView extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.artists, container, false);
         return view;
    }
}
