package com.mthumb.a45doSegundoWeb.api;

import com.mthumb.a45doSegundoWeb.core.JsonToModel;
import com.mthumb.a45doSegundoWeb.core.PropertiesFactory;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.League;
import com.mthumb.a45doSegundoWeb.models.Team;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.lang.String.format;

/**
 * Created by lucas on 12/04/2018.
 */

public class TeamDAO {

    public PropertiesFactory propertiesFactory;

    public APIConnection apiConnection;

    public TeamDAO(){
        this.propertiesFactory = (PropertiesFactory) ServiceHandler.get(PropertiesFactory.class);
        this.apiConnection = (APIConnection) ServiceHandler.get(APIConnection.class);
    }

    public List<Team> getTeamByName(String name) throws Exception {
        String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.teams.by.name"),name));
        return (List<Team>) (Object) JsonToModel.toObjects(Team.class,apiConnection.toJSON(result));
    }

    public List<Team> getTeamById(int id) throws Exception{
        String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.teams.by.id"), id));
        return (List<Team>) (Object) JsonToModel.toObjects(Team.class,apiConnection.toJSON(result));
    }
}
