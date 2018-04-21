package com.mthumb.a45doSegundoWeb.models;

import com.mthumb.a45doSegundoWeb.core.EmptyOn;
import com.mthumb.a45doSegundoWeb.core.JSONMapper;
import com.mthumb.a45doSegundoWeb.core.JSONModel;

/** Entidade que representa uma liga
 *  @author lucas
 */
@JSONModel
@EmptyOn(field="results", value="null")
public class Event {

    @JSONMapper(field = "idEvent", on="results")
    private int id;

    @JSONMapper(field = "strEvent", on="results")
    private String eventName;

    @JSONMapper(field = "intHomeScore", on="results")
    private int homeGols;

    @JSONMapper(field = "intAwayScore", on="results")
    private int awayGols;

    @JSONMapper(field = "dateEvent", on="results")
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getHomeGols() {
        return homeGols;
    }

    public void setHomeGols(int homeGols) {
        this.homeGols = homeGols;
    }

    public int getAwayGols() {
        return awayGols;
    }

    public void setAwayGols(int awayGols) {
        this.awayGols = awayGols;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
