package com.mthumb.a45doSegundoWeb.models;

import com.mthumb.a45doSegundoWeb.core.EmptyOn;
import com.mthumb.a45doSegundoWeb.core.JSONMapper;
import com.mthumb.a45doSegundoWeb.core.JSONModel;

/**
 * Created by lucas on 12/04/2018.
 */
@JSONModel
@EmptyOn(field="teams", value="null")
public class Team {

    @JSONMapper(field="idTeam", on = "teams")
    private int id;
    @JSONMapper(field="strTeam", on = "teams")
    private String nome;
    @JSONMapper(field="strStadium", on = "teams")
    private String estadio;
    @JSONMapper(field="idLeague", on = "teams")
    private int leagueId;
    @JSONMapper(field="strTeamBadge", on = "teams")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
