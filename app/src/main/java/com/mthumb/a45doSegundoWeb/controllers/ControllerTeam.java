package com.mthumb.a45doSegundoWeb.controllers;

import com.mthumb.a45doSegundoWeb.models.Team;

import java.util.List;

/**
 * Created by lucas on 12/04/2018.
 */

public interface ControllerTeam {

    List<Team> getTeamByName(String name) throws Exception;

    List<Team> getTeamByLeagueId(int leagueId) throws Exception;
}
