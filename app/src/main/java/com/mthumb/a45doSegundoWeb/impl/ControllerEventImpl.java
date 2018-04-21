package com.mthumb.a45doSegundoWeb.impl;

import com.mthumb.a45doSegundoWeb.api.EventDAO;
import com.mthumb.a45doSegundoWeb.controllers.ControllerEvent;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;
import com.mthumb.a45doSegundoWeb.models.Event;

import java.util.List;

/** Implementação de {@link com.mthumb.a45doSegundoWeb.controllers.ControllerEvent}
 *  @author lucas
 */
public class ControllerEventImpl implements ControllerEvent {

    private EventDAO eventDAO;

    public ControllerEventImpl(){
        this.eventDAO = (EventDAO) ServiceHandler.get(EventDAO.class);
    }

    @Override
    public List<Event> getLastFiveEventsByTeamId(int id) throws Exception {
        return eventDAO.getLastFiveEventByTeamId(id);
    }
}
