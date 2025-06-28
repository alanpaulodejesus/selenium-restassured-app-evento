package core;

import java.io.File;

public class Property {

    //public static final String URL = "http://localhost:8080/index.html";
    public static final String URL = "https://micro-servico-evento.onrender.com/";


    public static final String htmlRelatorio = System.getProperty( "user.dir" ) + File.separator +
            "src" + File.separator + "test" + File.separator + "resources" + File.separator + "relatorio.html";

    public static final Browsers browser = Browsers.CHROME;


    public  static enum Browsers {
        CHROME,
        FIREFOX

    }


}
