package api.test;

import api.endpoints.EventoService;
import core.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.Generator;

public class CriarEventoServiceTest {

    static EventoService eventoService = new EventoService();
    Response response;

    @BeforeClass
    public static void request(){
        RestAssuredConfig.carregarConfiguracao();
    }

    @Test
    public void deveCriarEventoServiceComSucesso() throws Exception {
        response = eventoService.criarEvento( "Evento " +Generator.firstName, "Descricao" +Generator.firstName, "2025-06-30");

        int status = response.getStatusCode();
        String nomeRetornado = response.jsonPath().getString("nomeEvento");
        String descricaoRetornado = response.jsonPath().getString("descricaoEvento");
        String dataRetornado = response.jsonPath().getString("dataEvento");
        Integer id = response.jsonPath().get("id");

        Assert.assertEquals(200, status);
        Assert.assertNotNull("O ID deve ser diferente de null", id);
        Assert.assertTrue("O ID deve ser maior que zero", id > 0);
        Assert.assertEquals("Evento " +Generator.firstName, nomeRetornado);
        Assert.assertEquals("Descricao" +Generator.firstName, descricaoRetornado);
        Assert.assertEquals("2025-06-30", dataRetornado);
    }
}
