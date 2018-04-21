package com.mthumb.a45doSegundoWeb.controllers;

import com.mthumb.a45doSegundoWeb.models.Event;

import java.util.List;

/** Controlador da event
 *  @author lucas
 */
public interface ControllerEvent {

    List<Event> getLastFiveEventsByTeamId(int id) throws Exception;
}
