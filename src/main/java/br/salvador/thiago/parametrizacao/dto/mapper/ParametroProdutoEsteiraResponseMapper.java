package br.salvador.thiago.parametrizacao.dto.mapper;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParametroProdutoEsteiraResponseMapper {

    ParametroProdutoEsteira toParametroProdutoEsteira(
            ParametroProdutoEsteiraResponseDto parametro
    );

    ParametroProdutoEsteiraResponseDto toParametroProdutoEsteiraResponseDto(
            ParametroProdutoEsteira parametro
    );

    List<ParametroProdutoEsteiraResponseDto> toParametroProdutoEsteiraResponseDtos(
            List<ParametroProdutoEsteira> parametros
    );
}
