package com.curso.atividade08.repository;

import com.curso.atividade08.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long>  {

    Departamento findFirstBy();

    //Listar todos os funcionários de um determinado departamento por JPQL via @Query.

}
