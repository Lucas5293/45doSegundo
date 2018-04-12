package com.mthumb.a45doSegundoWeb.impl;

import com.mthumb.a45doSegundoWeb.api.TeamDAO;
import com.mthumb.a45doSegundoWeb.controllers.ControllerTeam;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.Team;

import java.util.List;

/**
 * Created by lucas on 12/04/2018.
 */

public class ControllerTeamImpl implements ControllerTeam {

    TeamDAO dao;

    public ControllerTeamImpl(){
        dao = (TeamDAO) ServiceHandler.get(TeamDAO.class);
    }

    @Override
    public List<Team> getTeamByName(String name) throws Exception {
        return this.dao.getTeamByName(name);
    }

    @Override
    public List<Team> getTeamByLeagueId(int leagueId) throws Exception {
        return this.dao.getTeamById(leagueId);
    }
}
