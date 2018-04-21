package com.mthumb.a45doSegundoWeb.api;

import com.mthumb.a45doSegundoWeb.core.JsonToModel;
import com.mthumb.a45doSegundoWeb.core.PropertiesFactory;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.Event;
import com.mthumb.a45doSegundoWeb.models.League;

import java.util.List;

import static java.lang.String.format;

/** Event access de League
 * @author lucas
 */
public class EventDAO {

    public PropertiesFactory propertiesFactory;

    public APIConnection apiConnection;

    public EventDAO(){
        this.propertiesFactory = (PropertiesFactory) ServiceHandler.get(PropertiesFactory.class);
        this.apiConnection = (APIConnection) ServiceHandler.get(APIConnection.class);
    }

    @SuppressWarnings("unchecked")
    public List<Event> getLastFiveEventByTeamId(int id) throws Exception {
        String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.event.last5.by.team.id"),id));
        return (List<Event>) (Object) JsonToModel.toObjects(Event.class,apiConnection.toJSON(result));
    }
}
