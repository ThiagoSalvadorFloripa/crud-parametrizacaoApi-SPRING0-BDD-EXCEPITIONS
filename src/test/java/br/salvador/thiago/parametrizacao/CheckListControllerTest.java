package br.salvador.thiago.parametrizacao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class CheckListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkListWithReturn200() throws Exception {
        URI uri = new URI("/v1/parametros/checklist-documentos");
        String json = "{\"produto\":\"CPR-RURAL\",\n" +
                "    \"nome_documento\": \"Metricas de Produtividade\",\n" +
                "    \"etapa_jornada_venda\":\"GARANTIAS\",\n" +
                "    \"obrigatoriedade\":true,\n" +
                "    \"data_vigente\":\"2020-10-01T16:11:26:485\",\n" +
                "    \"usuario\":\"123456\",\n" +
                "    \"habilitado\":true}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


}

