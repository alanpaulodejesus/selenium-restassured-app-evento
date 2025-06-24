package core;
import io.restassured.RestAssured;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RestAssuredConfig {

    public static void carregarConfiguracao() {
        Properties props = new Properties();

        try (InputStream input = RestAssuredConfig.class.getClassLoader()
                .getResourceAsStream("env.properties")) {

            if (input == null) {
                throw new RuntimeException("Arquivo env.properties não encontrado.");
            }

            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar env.properties", e);
        }

        String ambiente = System.getProperty("env", props.getProperty("env", "dev")).trim();
        RestAssured.baseURI = props.getProperty(ambiente + ".baseURI");
        RestAssured.port = Integer.parseInt(props.getProperty(ambiente + ".port"));

        System.out.printf("✅ Ambiente carregado: %s (%s:%s)%n", ambiente,
                RestAssured.baseURI, RestAssured.port);
    }
}
