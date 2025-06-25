package gui.page;

import gui.dsl.CampoTexto;
import gui.dsl.Comando;
import gui.dsl.Label;
import org.openqa.selenium.*;
import utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class EventoPage {


    @FindBy(id = "nomeEvento") private WebElement inputNomeEvento;
    @FindBy(id = "descricaoEvento") private WebElement inputDescricaoEvento;
    @FindBy(id = "dataEvento") private WebElement inputDataEvento;
    @FindBy(xpath = "//*[contains(text(),'Criar Evento')]") private WebElement comandoCriarEvento;
    @FindBy(xpath = "//*[contains(text(),'Excluir')]") private WebElement comandoExcluirEvento;
    @FindBy(id = "btnConfirmarExclusao") private WebElement comandoConfirmaExcluirEvento;

    @FindBy(id = "mensagem") private WebElement labelMensagem;

    public static  ExtentTest test1=null;

    public EventoPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void preencherNomeEvento(String valor) throws Exception {
        Tempo.aguardar(2, inputNomeEvento );
        CampoTexto.preencher( inputNomeEvento, valor );
    }

    public void preencherDescricaoEvento(String valor) throws Exception {
        Tempo.aguardar(2, inputDescricaoEvento );
        CampoTexto.preencher( inputDescricaoEvento, valor );
    }

    public void preencherDataEvento(String valor) throws Exception {
        Tempo.aguardar(2, inputDataEvento );
        CampoTexto.preencher( inputDataEvento, valor );
    }

    public void clicarCriarEvento() throws Exception {
        Tempo.aguardar(2, comandoCriarEvento );
        Comando.clicar( comandoCriarEvento);
    }

    public void clicarExcluirEvento() throws Exception {
        Tempo.aguardar(2, comandoExcluirEvento);
        Comando.clicar( comandoExcluirEvento );
        Tempo.aguardar(2, comandoConfirmaExcluirEvento);
        Comando.clicar( comandoConfirmaExcluirEvento );


    }

    public String recuperarMensagem() throws Exception {
        Tempo.aguardar(2, labelMensagem );
        return Label.recuperaTexto( labelMensagem);
    }

}
