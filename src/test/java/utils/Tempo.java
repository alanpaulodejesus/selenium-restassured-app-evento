package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class Tempo {

    public  static void aguardar(long tempo, WebElement elemento) throws Exception {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until( ExpectedConditions.visibilityOf(elemento));
    }
}
