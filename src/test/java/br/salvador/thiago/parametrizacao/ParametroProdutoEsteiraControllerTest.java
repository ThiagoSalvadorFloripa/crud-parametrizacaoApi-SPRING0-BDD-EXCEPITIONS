package br.salvador.thiago.parametrizacao;

import br.salvador.thiago.parametrizacao.controller.exception.message.StandardError;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import br.salvador.thiago.parametrizacao.repository.ParametroProdutoEsteiraRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParametroProdutoEsteiraControllerTest {

    @MockBean
    private ParametroProdutoEsteiraRepository parametroProdutoEsteiraRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @TestConfiguration
    public static class setup {

        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }
    }

    @Test
    public void whenPostValidData_thenReturnCreatedWithNewObject() {
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

        HttpEntity<ParametroProdutoEsteiraPayloadDto> requestBody =
                new HttpEntity<ParametroProdutoEsteiraPayloadDto>(toSave);
        ResponseEntity<ParametroProdutoEsteiraResponseDto> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira",
                        HttpMethod.POST,
                        requestBody,
                        ParametroProdutoEsteiraResponseDto.class
                );

        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(201L);
        Assertions.assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void whenPostInvalidDataWithNullProperties_thenBadRequest() {
        ParametroProdutoEsteiraPayloadDto toSave = new ParametroProdutoEsteiraPayloadDto();

        HttpEntity<ParametroProdutoEsteiraPayloadDto> requestBody = new HttpEntity<>(toSave);
        ResponseEntity<StandardError> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira",
                        HttpMethod.POST,
                        requestBody,
                        StandardError.class
                );

        Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getException())
                .isEqualTo("MethodArgumentNotValidException");
    }

    @Test
    public void whenPostInvalidDataWithIndicadorOutOfValueRange_thenIllegalArgumentException() {
        ParametroProdutoEsteiraPayloadDto toSave = new ParametroProdutoEsteiraPayloadDto(
                33,
                3,
                'D',
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

        HttpEntity<ParametroProdutoEsteiraPayloadDto> requestBody = new HttpEntity<>(toSave);
        ResponseEntity<StandardError> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira",
                        HttpMethod.POST,
                        requestBody,
                        StandardError.class
                );

        Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getException())
                .isEqualTo("IllegalArgumentException");
    }

    @Test
    public void whenGetAndObjectNotExists_thenObjectNotFoundException() {
        Mockito.when(this.parametroProdutoEsteiraRepository.findById(1))
                .thenReturn(Optional.empty());

        ResponseEntity<StandardError> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira/1",
                        HttpMethod.GET,
                        null,
                        StandardError.class,
                        1
                );

        Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getException())
                .isEqualTo("ObjectNotFoundException");
    }

    @Test
    public void whenPutAndObjectNotExists_thenObjectNotFoundException() {
        Mockito.when(this.parametroProdutoEsteiraRepository.findById(1))
                .thenReturn(Optional.empty());

        ParametroProdutoEsteiraPayloadDto toUpdate = new ParametroProdutoEsteiraPayloadDto(
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

        HttpEntity<ParametroProdutoEsteiraPayloadDto> requestBody = new HttpEntity<>(toUpdate);
        ResponseEntity<StandardError> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira/1",
                        HttpMethod.PUT,
                        requestBody,
                        StandardError.class
                );

        Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getException())
                .isEqualTo("ObjectNotFoundException");
    }

    @Test
    public void whenPutValidData_thenReturnUpdatedObject() {
        Mockito.when(this.parametroProdutoEsteiraRepository.save(any(ParametroProdutoEsteira.class)))
                .thenReturn(new ParametroProdutoEsteira());
        Mockito.when(this.parametroProdutoEsteiraRepository.findById(1))
                .thenReturn(Optional.of(new ParametroProdutoEsteira()));

        ParametroProdutoEsteiraPayloadDto toUpdate = new ParametroProdutoEsteiraPayloadDto(
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

        HttpEntity<ParametroProdutoEsteiraPayloadDto> requestBody = new HttpEntity<>(toUpdate);
        ResponseEntity<StandardError> response = this.restTemplate
                .exchange("http://localhost:" + this.port + "/v1/parametro-regra-esteira/1",
                        HttpMethod.PUT,
                        requestBody,
                        StandardError.class
                );

        Assertions.assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
    }
}
