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

    @JSONMapper(field = "strHomeTeam", on="results")
    private String homeTeam;

    @JSONMapper(field = "strAwayTeam", on="results")
    private String awayTeam;

    @JSONMapper(field = "intHomeScore", on="results")
    private int homeGols;

    @JSONMapper(field = "intAwayScore", on="results")
    private int awayGols;

    @JSONMapper(field = "dateEvent", on="results")
    private String data;

    @JSONMapper(field="idHomeTeam", on = "results")
    private int homeTeamId;

    @JSONMapper(field="idAwayTeam", on = "results")
    private int awayTeamId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
}
