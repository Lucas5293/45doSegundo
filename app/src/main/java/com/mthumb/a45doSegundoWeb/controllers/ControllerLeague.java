package com.mthumb.a45doSegundoWeb.controllers;

import java.util.List;

import com.mthumb.a45doSegundoWeb.models.League;

/** Controlador da liga
 *  @author lucas
 */
public interface ControllerLeague{

	List<League> getLeagues() throws Exception;

	List<League> getLeaguesByCountry(String country) throws Exception;
}
