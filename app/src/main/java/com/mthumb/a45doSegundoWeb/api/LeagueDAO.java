package com.mthumb.a45doSegundoWeb.api;

import java.util.List;

import com.mthumb.a45doSegundoWeb.core.JsonToModel;
import com.mthumb.a45doSegundoWeb.core.PropertiesFactory;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.League;

import static java.lang.String.format;

/** Data access de League
 * @author lucas
 */
public class LeagueDAO {

    public PropertiesFactory propertiesFactory;

    public APIConnection apiConnection;

    public LeagueDAO(){
        this.propertiesFactory = (PropertiesFactory) ServiceHandler.get(PropertiesFactory.class);
        this.apiConnection = (APIConnection) ServiceHandler.get(APIConnection.class);
    }

    @SuppressWarnings("unchecked")
    public List<League> getLeagues() throws Exception {
        String result = apiConnection.sendGet(propertiesFactory.get("api").getProperty("api.leagues.all"));
        return (List<League>) (Object) JsonToModel.toObjects(League.class,apiConnection.toJSON(result));
    }

    @SuppressWarnings("unchecked")
    public List<League> getLeaguesByCountry(String country) throws Exception {
        String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.leagues.by.country"),country));
        return (List<League>) (Object) JsonToModel.toObjects(League.class,apiConnection.toJSON(result));
    }
}
