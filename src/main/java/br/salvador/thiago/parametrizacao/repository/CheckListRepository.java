package br.salvador.thiago.parametrizacao.repository;

import br.salvador.thiago.parametrizacao.model.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> {

}
