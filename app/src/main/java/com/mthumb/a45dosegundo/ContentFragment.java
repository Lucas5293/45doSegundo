package com.mthumb.a45dosegundo;

/**
 * Created by silva on 29/03/2018.
 */

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.TextView;

import com.mthumb.a45doSegundoWeb.controllers.ControllerEvent;
import com.mthumb.a45doSegundoWeb.controllers.ControllerLeague;
import com.mthumb.a45doSegundoWeb.controllers.ControllerTeam;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.impl.ControllerEventImpl;
import com.mthumb.a45doSegundoWeb.impl.ControllerLeagueImpl;
import com.mthumb.a45doSegundoWeb.impl.ControllerTeamImpl;
import com.mthumb.a45doSegundoWeb.models.Event;

public class ContentFragment extends Fragment {

    View myView;

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
            //new Thread() {
              //  public void run() {
                    try {
                        TextView time1 = (TextView) myView.findViewById (R.id.Time1);
                        TextView time2 = (TextView)myView.findViewById(R.id.Time2);

                        TextView gols1 = (TextView)myView.findViewById(R.id.Gols1);
                        TextView gols2 = (TextView)myView.findViewById(R.id.Gols2);

                        System.out.println("Iniciou conexão");
                        int id = controllerTeam.getTeamByName("palmeiras").get(0).getId();
                        System.out.println("\nJogos\n");

                        /*for (Event event: controllerEvent.getLastFiveEventsByTeamId(id)){
                            System.out.println(event.getEventName());
                        }*/

                        Event event = controllerEvent.getLastFiveEventsByTeamId(id).get(2);

                        time1.setText(event.getHomeTeam());
                        time2.setText(event.getAwayTeam());
                        gols2.setText(String.valueOf(event.getHomeGols()));
                        gols1.setText(String.valueOf(event.getAwayGols()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                //}
            //};


        } catch (Exception e) {
            e.printStackTrace();
        }




        return myView;
    }
}

