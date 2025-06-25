package hooks;

import api.test.CriarEventoServiceTest;
import gui.test.EventoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        //Gui
        EventoTest.class,
        //Api
        CriarEventoServiceTest.class

})
public class TestHooks {

}
