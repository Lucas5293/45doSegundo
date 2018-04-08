package com.mthumb.a45doSegundoWeb.impl;

import java.util.List;

import com.mthumb.a45doSegundoWeb.api.LeagueDAO;
import com.mthumb.a45doSegundoWeb.controllers.ControllerLeague;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.League;

/** Implementação de {@link com.mthumb.a45doSegundoWeb.controllers.ControllerLeague}
 *  @author lucas
 */
public class ControllerLeagueImpl implements ControllerLeague {

    private LeagueDAO leagueDAO;

    public ControllerLeagueImpl(){
        this.leagueDAO = (LeagueDAO) ServiceHandler.get(LeagueDAO.class);
    }

    public List<League> getLeagues() throws Exception {
        return leagueDAO.getLeagues();
    }

    public List<League> getLeaguesByCountry(String country) throws Exception {
        return leagueDAO.getLeaguesByCountry(country);
    }

}
