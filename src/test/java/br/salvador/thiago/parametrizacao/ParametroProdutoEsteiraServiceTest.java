package br.salvador.thiago.parametrizacao;

import br.salvador.thiago.parametrizacao.controller.exception.ObjectNotFoundException;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import br.salvador.thiago.parametrizacao.repository.ParametroProdutoEsteiraRepository;
import br.salvador.thiago.parametrizacao.service.ParametroProdutoEsteiraService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ParametroProdutoEsteiraServiceTest {

    @Autowired
    private ParametroProdutoEsteiraRepository parametroProdutoEsteiraRepository;

    @Autowired
    private ParametroProdutoEsteiraService parametroProdutoEsteiraService;

    @Test
    public void whenFindNullId_thenNullPointerException() {
        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.findById(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void whenFindIdThatDoesntExist_thenObjectNotFoundException() {
        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.findById(0))
                .isInstanceOf(ObjectNotFoundException.class);
    }

    @Test
    public void whenSaveValidObject_thenReturnValidResponseObject() {
        ParametroProdutoEsteiraResponseDto response = this.parametroProdutoEsteiraService.save(this.getValidParametroProdutoEsteiraPayloadDto());

        Assertions.assertThat(response.getIdParametroRegraEsteira()).isNotNull();
        Assertions.assertThat(response.getCodigoProdutoOperacional()).isEqualTo(33);
        Assertions.assertThat(response.getCodigoMobilidade()).isEqualTo(3);
        Assertions.assertThat(response.getDataCriacao()).isNotNull();
    }

    @Test
    public void whenSaveObjectWithNullProperties_thenThrowException() {
        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.save(new ParametroProdutoEsteiraPayloadDto()))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void whenSaveInvalidIndicador_thenThrowIllegalArgumentException() {
        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.save(this.getInvalidParametroProdutoEsteiraPayloadDto()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenUpdateIdThatDoesntExist_thenObjectNotFoundException() {
        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.update(0, this.getValidParametroProdutoEsteiraPayloadDto()))
                .isInstanceOf(ObjectNotFoundException.class);
    }

    @Test
    public void whenUpdateObjectWithNullProperties_thenThrowException() {
        ParametroProdutoEsteira savedObject = this.parametroProdutoEsteiraRepository.save(getValidParametroProdutoEsteira());

        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.update(savedObject.getIdParametroRegraEsteira(), new ParametroProdutoEsteiraPayloadDto()))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void whenUpdateValidObject_thenReturnValidResponseObject() {
        ParametroProdutoEsteira savedObject = this.parametroProdutoEsteiraRepository.save(getValidParametroProdutoEsteira());
        ParametroProdutoEsteiraResponseDto response = this.parametroProdutoEsteiraService.update(savedObject.getIdParametroRegraEsteira(), this.getValidParametroProdutoEsteiraPayloadDto());

        Assertions.assertThat(response.getIdParametroRegraEsteira()).isEqualTo(savedObject.getIdParametroRegraEsteira());
        Assertions.assertThat(response.getCodigoProdutoOperacional()).isEqualTo(33);
        Assertions.assertThat(response.getCodigoMobilidade()).isEqualTo(3);
        Assertions.assertThat(response.getDataAtualizacao()).isNotNull();
    }

    @Test
    public void whenUpdateInvalidIndicador_thenThrowIllegalArgumentException() {
        ParametroProdutoEsteira savedObject = this.parametroProdutoEsteiraRepository.save(getValidParametroProdutoEsteira());

        Assertions.assertThatCode(() -> this.parametroProdutoEsteiraService.update(savedObject.getIdParametroRegraEsteira(), this.getInvalidParametroProdutoEsteiraPayloadDto()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private ParametroProdutoEsteira getValidParametroProdutoEsteira() {
        return new ParametroProdutoEsteira(null, 33, 3, 'S', 'S', 'N', 'N', 20, 30, LocalDateTime.parse("2020-09-10T16:22:01.8394834"), LocalDateTime.parse("2020-09-10T16:22:01.8394834"), 2, 3, LocalDateTime.now(), null);
    }

    private ParametroProdutoEsteiraPayloadDto getValidParametroProdutoEsteiraPayloadDto() {
        return new ParametroProdutoEsteiraPayloadDto(33, 3, 'S', 'S', 'N', 'N', 20, 30, LocalDateTime.parse("2020-09-10T16:22:01.8394834"), LocalDateTime.parse("2020-09-10T16:22:01.8394834"), 2, 3);
    }

    private ParametroProdutoEsteiraPayloadDto getInvalidParametroProdutoEsteiraPayloadDto() {
        return new ParametroProdutoEsteiraPayloadDto(33, 3, 'D', 'S', 'N', 'N', 20, 30, LocalDateTime.parse("2020-09-10T16:22:01.8394834"), LocalDateTime.parse("2020-09-10T16:22:01.8394834"), 2, 3);
    }
}
