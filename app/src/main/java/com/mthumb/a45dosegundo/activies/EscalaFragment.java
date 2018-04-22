package com.mthumb.a45dosegundo.activies;

/**
 * Created by silva on 29/03/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import com.mthumb.a45dosegundo.R;

public class EscalaFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.content_escalacao, container, false);
        return myView;
    }
}

