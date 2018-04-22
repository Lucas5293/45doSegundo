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

import com.mthumb.a45doSegundo.tools.EventCardView;
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

            List<Event> events = controllerEvent.getLastFiveEventsByTeamId(time.getId());

            int i =0;

            for(EventCardView eventCardView: this.populeRowsEventCardViews(myView)){
                Event event = events.get(i);

                // Nome dos times
                eventCardView.getNomeTimesTextView().first.setText(event.getHomeTeam());
                eventCardView.getNomeTimesTextView().second.setText(event.getAwayTeam());

                // Gols dos times
                eventCardView.getResultadoTimesTextView().first.setText(String.valueOf(event.getHomeGols()));
                eventCardView.getResultadoTimesTextView().second.setText(String.valueOf(event.getAwayGols()));

                // Imagens miniaturas dos times
                InputStream inputTeam1=null;
                InputStream inputTeam2=null;

                if (time.getId()==event.getHomeTeamId()){
                    inputTeam1 = new URL(time.getImageUrl()).openStream();

                    List<Team> timeForaLista = controllerTeam.getTeamById(event.getAwayTeamId());
                    if (!timeForaLista.isEmpty()) {
                        Team timeFora = timeForaLista.get(0);
                        inputTeam2 = new URL(timeFora.getImageUrl()).openStream();
                    }
                }
                else{
                    inputTeam2 = new URL(time.getImageUrl()).openStream();

                    List<Team> timeForaLista = controllerTeam.getTeamById(event.getHomeTeamId());
                    if (!timeForaLista.isEmpty()) {
                        Team timeFora = timeForaLista.get(0);
                        inputTeam1 = new URL(timeFora.getImageUrl()).openStream();
                    }
                }

                if (inputTeam1!=null){
                    Bitmap bitmap1 = BitmapFactory.decodeStream(inputTeam1);
                    eventCardView.getLogoTimesImageView().first.setImageBitmap(bitmap1);
                }
                if (inputTeam2!=null){
                    Bitmap bitmap2 = BitmapFactory.decodeStream(inputTeam2);
                    eventCardView.getLogoTimesImageView().second.setImageBitmap(bitmap2);
                }

                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return myView;
    }

    private List<EventCardView> populeRowsEventCardViews(View view){

        List<EventCardView> cardViews = new ArrayList<>();
        EventCardView cardView1, cardView2, cardView3, cardView4, cardView5;

        cardView1 = new EventCardView(view);
        cardView1.setNomeTimesTextViewById(R.id.Time1card1, R.id.Time2card1);
        cardView1.setResultadoTimesTextViewById(R.id.Gols1card1, R.id.Gols2card1);
        cardView1.setLogoTimesTextViewById(R.id.Logo2card1, R.id.Logo1card1);

        cardView2 = new EventCardView(view);
        cardView2.setNomeTimesTextViewById(R.id.Time1card2, R.id.Time2card2);
        cardView2.setResultadoTimesTextViewById(R.id.Gols1card2, R.id.Gols2card2);
        cardView2.setLogoTimesTextViewById(R.id.Logo2card2, R.id.Logo1card2);

        cardView3 = new EventCardView(view);
        cardView3.setNomeTimesTextViewById(R.id.Time1card3, R.id.Time2card3);
        cardView3.setResultadoTimesTextViewById(R.id.Gols1card3, R.id.Gols2card3);
        cardView3.setLogoTimesTextViewById(R.id.Logo2card3, R.id.Logo1card3);

        cardView4 = new EventCardView(view);
        cardView4.setNomeTimesTextViewById(R.id.Time1card4, R.id.Time2card4);
        cardView4.setResultadoTimesTextViewById(R.id.Gols1card4, R.id.Gols2card4);
        cardView4.setLogoTimesTextViewById(R.id.Logo2card4, R.id.Logo1card4);

        cardView5 = new EventCardView(view);
        cardView5.setNomeTimesTextViewById(R.id.Time1card5, R.id.Time2card5);
        cardView5.setResultadoTimesTextViewById(R.id.Gols1card5, R.id.Gols2card5);
        cardView5.setLogoTimesTextViewById(R.id.Logo2card5, R.id.Logo1card5);

        cardViews.add(cardView1);
        cardViews.add(cardView2);
        cardViews.add(cardView3);
        cardViews.add(cardView4);
        cardViews.add(cardView5);

        return cardViews;
    }
}

