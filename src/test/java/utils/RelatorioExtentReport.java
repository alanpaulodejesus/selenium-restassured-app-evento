package utils;

import core.Property;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import static core.DriverFactory.getDriver;

public class RelatorioExtentReport {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    public static void startRelatorio() {

        if(htmlReporter==null){
            htmlReporter = new ExtentHtmlReporter(System.getProperty( "user.dir" )  + File.separator +
                    "src" + File.separator + "test" + File.separator + "resources" + File.separator + "relatorio.html" );


            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setDocumentTitle("Teste de Automação de Software");
            htmlReporter.config().setReportName("Resultado de Automação de Testes");
            htmlReporter.config().setTheme( Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            extent.setSystemInfo("Automation Tester", "Alan Paulo de Jesus");
            extent.setSystemInfo("Organization", "Teste de Software");
        }


    }


    public static void closeRelatorio()throws Exception
    {
        if(htmlReporter==null){
            extent.flush();

        }
        getDriver().get( Property.htmlRelatorio );
    }


}
