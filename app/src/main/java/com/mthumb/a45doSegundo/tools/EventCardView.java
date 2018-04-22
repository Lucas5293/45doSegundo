package com.mthumb.a45doSegundo.tools;

import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventCardView {

    private Pair<TextView,TextView> nomeTimesTextView;
    private Pair<TextView,TextView> resultadoTimesTextView;
    private Pair<ImageView, ImageView> logoTimesImageView;
    private View view;

    public EventCardView(View view) {
        this.view = view;
    }

    public Pair<TextView, TextView> getNomeTimesTextView() {
        return nomeTimesTextView;
    }

    public void setNomeTimesTextView(Pair<TextView, TextView> nomeTimesTextView) {
        this.nomeTimesTextView = nomeTimesTextView;
    }

    public Pair<TextView, TextView> getResultadoTimesTextView() {
        return resultadoTimesTextView;
    }

    public void setResultadoTimesTextView(Pair<TextView, TextView> resultadoTimesTextView) {
        this.resultadoTimesTextView = resultadoTimesTextView;
    }

    public Pair<ImageView, ImageView> getLogoTimesImageView() {
        return logoTimesImageView;
    }

    public void setLogoTimesImageView(Pair<ImageView, ImageView> logoTimesImageView) {
        this.logoTimesImageView = logoTimesImageView;
    }

    public void setNomeTimesTextViewById(int id, int id2){
        TextView textView1 = (TextView) this.view.findViewById(id);
        TextView textView2 = (TextView) this.view.findViewById(id2);
        this.setNomeTimesTextView(new Pair<>(textView1, textView2));
    }

    public void setResultadoTimesTextViewById(int id, int id2){
        TextView textView1 = (TextView) this.view.findViewById(id);
        TextView textView2 = (TextView) this.view.findViewById(id2);
        this.setResultadoTimesTextView(new Pair<>(textView1, textView2));
    }

    public void setLogoTimesTextViewById(int id, int id2){
        ImageView imageView1 = (ImageView) this.view.findViewById(id);
        ImageView imageView2 = (ImageView) this.view.findViewById(id2);
        this.setLogoTimesImageView(new Pair<>(imageView1, imageView2));
    }

}
