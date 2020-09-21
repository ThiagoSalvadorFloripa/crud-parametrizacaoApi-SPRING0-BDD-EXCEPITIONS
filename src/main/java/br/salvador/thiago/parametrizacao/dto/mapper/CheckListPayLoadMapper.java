package br.salvador.thiago.parametrizacao.dto.mapper;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckListPayLoadMapper {
    CheckList toCheckList(CheckListPayLoadDTO list);
}
