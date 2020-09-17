package br.salvador.thiago.parametrizacao.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.salvador.thiago.parametrizacao.model.CheckList;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> {
	
	

}
