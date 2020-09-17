package br.salvador.thiago.parametrizacao;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import br.salvador.thiago.parametrizacao.repository.ParametroProdutoEsteiraRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParametroProdutoEsteiraControllerTest {

    @MockBean
    private ParametroProdutoEsteiraRepository parametroProdutoEsteiraRepository;

    @LocalServerPort
    private int port;

    @Test
    public void whenPostNewParametroPrudutoEsteira_thenReturnCreatedWithNewObject() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        Mockito.when(this.parametroProdutoEsteiraRepository.save(any(ParametroProdutoEsteira.class)))
                .thenReturn(new ParametroProdutoEsteira());

        ParametroProdutoEsteiraPayloadDto toSave = new ParametroProdutoEsteiraPayloadDto(
                33,
                3,
                'S',
                'S',
                'N',
                'N',
                20,
                30,
                LocalDateTime.parse("2020-09-10T16:22:01.8394834"),
                LocalDateTime.parse("2020-09-10T16:22:01.8394834"),
                2,
                3
        );
        HttpEntity<ParametroProdutoEsteiraPayloadDto> request =
                new HttpEntity<ParametroProdutoEsteiraPayloadDto>(toSave);

        ResponseEntity<ParametroProdutoEsteiraResponseDto> response = restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira",
                        HttpMethod.POST,
                        request,
                        ParametroProdutoEsteiraResponseDto.class);

        Assertions.assertThat(response.getStatusCodeValue())
                .isEqualTo(201L);
    }

}
