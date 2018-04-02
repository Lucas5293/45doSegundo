package com.mthumb.a45doSegundoWeb.api;

import java.util.List;

import com.mthumb.a45doSegundoWeb.core.ModelHandler;
import com.mthumb.a45doSegundoWeb.core.PropertiesFactory;
import com.mthumb.a45doSegundoWeb.core.Service;
import com.mthumb.a45doSegundoWeb.core.ServiceInstance;
import com.mthumb.a45doSegundoWeb.models.League;

import static java.lang.String.format;

/** Data access de League
 * @author lucas
 */
@Service
public class LeagueDataAccess{

    @ServiceInstance
    public PropertiesFactory propertiesFactory;

    @ServiceInstance
    public APIConnection apiConnection;

    @SuppressWarnings("unchecked")
    public List<League> getLeagues() throws Exception {
        String result = apiConnection.sendGet(propertiesFactory.get("api").getProperty("api.leagues.all"));
        return (List<League>) (Object) ModelHandler.toObjects(League.class,apiConnection.toJSON(result));
    }

    @SuppressWarnings("unchecked")
    public List<League> getLeaguesByCountry(String country) throws Exception {
        String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.leagues.by.country"),country));
        return (List<League>) (Object) ModelHandler.toObjects(League.class,apiConnection.toJSON(result));
    }
}
