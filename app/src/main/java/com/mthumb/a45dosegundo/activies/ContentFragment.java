package com.mthumb.a45dosegundo.activies;

/**
 * Created by silva on 29/03/2018.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mthumb.a45doSegundo.tools.CachedBitmap;
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
    private LinearLayout linearLayout;
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


        this.linearLayout = (LinearLayout) myView.findViewById(R.id.linearLayout);
        this.linearLayout.setVisibility(View.INVISIBLE);
        new Thread(){
            @Override
            public void run() {
                try {
                    buildEventsOnScreen();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();


        return myView;
    }

    private void buildEventsOnScreen() throws Exception {

        final List<DataToCardView> dados = new ArrayList<>();

        Team time = controllerTeam.getTeamByName("palmeiras").get(0);
        List<Event> events = controllerEvent.getLastFiveEventsByTeamId(time.getId());

        for(int i=0; i<5; i++){
            Event event = events.get(i);

            DataToCardView data = new DataToCardView();

            data.homeTeam = event.getHomeTeam();
            data.homeGols = String.valueOf(event.getHomeGols());

            data.awayTeam = event.getAwayTeam();
            data.awayGols = String.valueOf(event.getAwayGols());

            if (time.getId()==event.getHomeTeamId()){
                data.homeBitmap = CachedBitmap.get(time.getImageUrl());

                List<Team> timeForaLista = controllerTeam.getTeamById(event.getAwayTeamId());
                if (!timeForaLista.isEmpty()) {
                    Team timeFora = timeForaLista.get(0);
                    data.awayBitmap = CachedBitmap.get(timeFora.getImageUrl());
                }
            }
            else {
                data.awayBitmap = CachedBitmap.get(time.getImageUrl());

                List<Team> timeForaLista = controllerTeam.getTeamById(event.getHomeTeamId());
                if (!timeForaLista.isEmpty()) {
                    Team timeFora = timeForaLista.get(0);
                    data.homeBitmap =  CachedBitmap.get(timeFora.getImageUrl());
                }
            }
            dados.add(data);
        }

        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                toScreen(dados);
            }
        });
    }

    private void toScreen(List<DataToCardView> dados){
        List<EventCardView> cardViews = this.populeRowsEventCardViews(myView);
        for(int i=0; i<5; i++){

            EventCardView eventCardView = cardViews.get(i);
            DataToCardView data = dados.get(i);

            // Nome dos times
            eventCardView.getNomeTimesTextView().first.setText(data.homeTeam);
            eventCardView.getNomeTimesTextView().second.setText(data.awayTeam);

            // Gols dos times
            eventCardView.getResultadoTimesTextView().first.setText(data.homeGols);
            eventCardView.getResultadoTimesTextView().second.setText(data.awayGols);

            // Logo dos times
            eventCardView.getLogoTimesImageView().first.setImageBitmap(data.homeBitmap);
            eventCardView.getLogoTimesImageView().second.setImageBitmap(data.awayBitmap);
        }
        this.linearLayout.setVisibility(View.VISIBLE);
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

    public class DataToCardView{
        public String homeTeam;
        public String awayTeam;
        public String homeGols;
        public String awayGols;
        public Bitmap homeBitmap;
        public Bitmap awayBitmap;
    }
}
