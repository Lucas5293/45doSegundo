package mthumb.a45doSegundoWeb.core;

import org.junit.Test;

import mthumb.a45doSegundoWeb.controllers.ControllerLeague;

/**
 * Created by lucas on 10/03/2018.
 */

public class ServiceHandlerTest extends TestsFactory{

    public ControllerLeague controllerLeague;

    @Test
    public void test() throws Exception {
        controllerLeague = (ControllerLeague) this.getServiceHandler().getInstance(ControllerLeague.class);
        controllerLeague.getLeagues();
    }
}
