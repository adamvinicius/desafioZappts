package tests;

import io.restassured.RestAssured;
import maps.ReqresMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class ReqresTest {
    public ReqresMap reqresMap;

    @BeforeEach
    public void inicializaTeste(){
        reqresMap = new ReqresMap();
        reqresMap.inicializaJson();
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
    }

    @Test
    public void validaCreateSucesso(){
        RestUtils.post(reqresMap.getJson());
        assertEquals(201, RestUtils.getResponse().statusCode());
        assertEquals("morpheus", RestUtils.getResponse().jsonPath().get("nome"));
        assertEquals("leader", RestUtils.getResponse().jsonPath().get("job"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("id"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("createdAt"));
    }

    @Test
    public void validaCreateSemEnviarCampoNome(){
        reqresMap.getJson().remove("nome");
        RestUtils.post(reqresMap.getJson());

        assertEquals(201, RestUtils.getResponse().statusCode());
        assertNull(RestUtils.getResponse().jsonPath().get("nome"));
        assertEquals("leader", RestUtils.getResponse().jsonPath().get("job"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("id"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("createdAt"));
    }

    @Test
    public void validaCreateSemEnviarCampoJob(){
        reqresMap.getJson().remove("job");
        RestUtils.post(reqresMap.getJson());

        assertEquals(201, RestUtils.getResponse().statusCode());
        assertEquals("morpheus", RestUtils.getResponse().jsonPath().get("nome"));
        assertNull(RestUtils.getResponse().jsonPath().get("job"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("id"));
        assertNotEquals("", RestUtils.getResponse().jsonPath().get("createdAt"));
    }

}
