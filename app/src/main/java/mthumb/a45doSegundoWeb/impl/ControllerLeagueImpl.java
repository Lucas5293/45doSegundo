package mthumb.a45doSegundoWeb.impl;

import java.util.List;

import mthumb.a45doSegundoWeb.api.LeagueDataAccess;
import mthumb.a45doSegundoWeb.controllers.ControllerLeague;
import mthumb.a45doSegundoWeb.core.Service;
import mthumb.a45doSegundoWeb.core.ServiceInstance;
import mthumb.a45doSegundoWeb.models.League;

/** Implementação de {@link mthumb.a45doSegundoWeb.controllers.ControllerLeague}
 *  @author lucas
 */
@Service
public class ControllerLeagueImpl implements ControllerLeague {

    @ServiceInstance
    public LeagueDataAccess leagueDataAccess;

    public List<League> getLeagues() throws Exception {
        return leagueDataAccess.getLeagues();
    }

    public List<League> getLeaguesByCountry(String country) throws Exception {
        return leagueDataAccess.getLeaguesByCountry(country);
    }

}
