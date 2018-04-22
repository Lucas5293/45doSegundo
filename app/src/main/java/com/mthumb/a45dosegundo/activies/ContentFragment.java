package com.mthumb.a45dosegundo.activies;

/**
 * Created by silva on 29/03/2018.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.mthumb.a45doSegundoWeb.controllers.ControllerEvent;
import com.mthumb.a45doSegundoWeb.controllers.ControllerTeam;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.impl.ControllerEventImpl;
import com.mthumb.a45doSegundoWeb.impl.ControllerTeamImpl;
import com.mthumb.a45doSegundoWeb.models.Event;
import com.mthumb.a45doSegundoWeb.models.Team;
import com.mthumb.a45dosegundo.R;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {

    private View myView;
    private List<Pair<TextView, TextView>> rowEvent;

    public ControllerTeam controllerTeam;
    public ControllerEvent controllerEvent;

    public ContentFragment() {

        controllerTeam = (ControllerTeam) ServiceHandler.get(ControllerTeamImpl.class);
        controllerEvent = (ControllerEvent) ServiceHandler.get(ControllerEventImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        myView = inflater.inflate(R.layout.content_main, container, false);

        try {
            Team time = controllerTeam.getTeamByName("palmeiras").get(0);

            Bitmap time2logo = null;
            Bitmap time1logo = null;

            Event event = controllerEvent.getLastFiveEventsByTeamId(time.getId()).get(2);

            Team timeFora = controllerTeam.getTeamById(event.getHomeTeamId(


            )).get(0);

            InputStream is2 = new URL(timeFora.getImageUrl()).openStream();
            InputStream is1 = new URL(time.getImageUrl()).openStream();

            System.out.println(timeFora.getImageUrl());
            System.out.println(time.getImageUrl());


            time2logo = BitmapFactory.decodeStream(is1);
            time1logo = BitmapFactory.decodeStream(is2);

            for(Pair<TextView, TextView> elementos: this.populeRowsEvents()){
                Object elemento1 = elementos.first;
                Object elemento2 = elementos.second;

                switch (elemento1.getClass().getSimpleName()){
                    case "TextView":
                        System.out.println("é um textview");
                        break;
                    case "TextView":
                        System.out.println("é um textview");
                        break;
                }
            }







        } catch (Exception e) {
            e.printStackTrace();
        }

        return myView;
    }

    private List<Pair<TextView, TextView>> populeRowsEvents(){
        List<Pair<TextView, TextView>> rowEvent = new ArrayList<>();
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Time1card1, R.id.Time2card1));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Time1card2, R.id.Time2card2));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Time1card3, R.id.Time2card3));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Time1card4, R.id.Time2card4));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Time1card5, R.id.Time2card5));

        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Gols1card1, R.id.Gols2card1));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Gols1card2, R.id.Gols2card2));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Gols1card3, R.id.Gols2card3));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Gols1card4, R.id.Gols2card4));
        rowEvent.add((Pair<TextView, TextView>) this.addRow(R.id.Gols1card5, R.id.Gols2card5));

        rowEvent.add((Pair<ImageView, ImageView>) this.addRow(R.id.Logo1card1, R.id.Logo2card1));
        rowEvent.add((Pair<ImageView, ImageView>) this.addRow(R.id.Logo1card2, R.id.Logo2card2));
        rowEvent.add((Pair<ImageView, ImageView>) this.addRow(R.id.Logo1card3, R.id.Logo2card3));
        rowEvent.add((Pair<ImageView, ImageView>) this.addRow(R.id.Logo1card4, R.id.Logo2card4));
        rowEvent.add((Pair<ImageView, ImageView>) this.addRow(R.id.Logo1card5, R.id.Logo2card5));

        return rowEvent;
    }


    private Pair<?,?> addRow(int element1, int element2){
       return new Pair<Object,Object> (myView.findViewById(element1), myView.findViewById(element2));
    }

}

