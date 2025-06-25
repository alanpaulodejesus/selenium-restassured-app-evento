package gui.test;

import core.Property;
import core.RestAssuredConfig;
import org.junit.runners.MethodSorters;
import gui.page.EventoPage;
import api.endpoints.EventoService;
import utils.Generator;
import org.junit.*;
import static core.DriverFactory.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventoTest {

    EventoPage evento;
    static EventoService eventoService = new EventoService();

    public EventoTest() throws Exception {
    }

    @BeforeClass
    public static void request(){
        RestAssuredConfig.carregarConfiguracao();
        eventoService.criarEvento("Evento excluir", "Evento excluir", "2055-06-26");
    }

    @Before
    public void setUp() throws Exception {
        getDriver().get( Property.URL);
        evento = new EventoPage();
        //startRelatorio();
    }

    @Test
    public void cenario1_excluirEventoComSucesso() throws Exception {
        evento.clicarExcluirEvento();
        Assert.assertEquals("Evento excluído com sucesso!",  evento.recuperarMensagem());
    }

    @Test
    public void cenario2_criarEventoComDataMenorQueAtual() throws Exception {
        evento.preencherNomeEvento("Evento " + Generator.firstName);
        evento.preencherDescricaoEvento( "Descricao evento para " + Generator.firstName);
        evento.preencherDataEvento( Generator.datesPast);
        evento.clicarCriarEvento();
        Assert.assertEquals("Erro: A data do evento não deve ser menor que a data atual.",  evento.recuperarMensagem());
    }

    @Test
    public void cenario3_criarEventoComSucesso() throws Exception {
        evento.preencherNomeEvento("Evento " + Generator.firstName);
        evento.preencherDescricaoEvento( "Descricao evento para " + Generator.firstName);
        evento.preencherDataEvento( Generator.dates);
        evento.clicarCriarEvento();
        Assert.assertEquals("Evento criado com sucesso!",  evento.recuperarMensagem());
    }

    @AfterClass
    public static void finishTearDown()throws Exception {
        eventoService.excluirEvento();
        //getDriver().close();
        //closeRelatorio();
    }

}


