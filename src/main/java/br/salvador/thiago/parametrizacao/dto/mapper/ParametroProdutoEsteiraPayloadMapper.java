package br.salvador.thiago.parametrizacao.dto.mapper;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParametroProdutoEsteiraPayloadMapper {

    ParametroProdutoEsteira toParametroProdutoEsteira(
            ParametroProdutoEsteiraPayloadDto parametro
    );
}
