package mthumb.a45doSegundoWeb.controllers;

import java.util.List;

import mthumb.a45doSegundoWeb.core.Service;
import mthumb.a45doSegundoWeb.models.League;

/** Controlador da liga
 *  @author lucas
 */
@Service
public interface ControllerLeague{

	public List<League> getLeagues() throws Exception;

	public List<League> getLeaguesByCountry(String country) throws Exception;
}
