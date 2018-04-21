package com.mthumb.a45dosegundo;

/**
 * Created by silva on 29/03/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.content_main, container, false);

        TextView time1 = (TextView) myView.findViewById (R.id.Time1);
        TextView time2 = (TextView)myView.findViewById(R.id.Time2);

        TextView gols1 = (TextView)myView.findViewById(R.id.Gols1);
        TextView gols2 = (TextView)myView.findViewById(R.id.Gols2);

        time1.setText("Palmeiras");
        time2.setText("Corinthians");
        gols1.setText("20");
        gols2.setText("2");

        return myView;
    }
}

