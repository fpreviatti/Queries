package com.curso.atividade08.repository;

import com.curso.atividade08.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Modifying
    @Transactional
    @Query("delete from Funcionario f where f.departamento.codDepartamento =  ?1")
    void excluirFuncionariosPorCodigoDepartamento(int departamento);

    @Modifying
    @Transactional
    @Query("update Funcionario f set f.departamento.codDepartamento = ?1 where f.departamento.codDepartamento = ?2")
    void updateDepartamentoFuncionarioByld(int idNovoDepartamento,int idDepartamentoAtual);

    @Query("SELECT f FROM Funcionario f inner JOIN f.departamento d WHERE f.departamento.nomeDepartamento like CONCAT('%', :departamento, '%') and f.qtdDependentes=0")
    List<Funcionario> findByDepartamentoSemDependentes(@Param("departamento")String departamento);

    @Procedure(procedureName = "proc_salario")
    void aumentaSalario(int x);

    Funcionario findByNomeFuncionarioAndQtdDependentes(String nome, int qtdDependentes);

    @Query("SELECT f FROM Funcionario f inner JOIN f.departamento d WHERE f.departamento.nomeDepartamento = ?1")
    List<Funcionario> findByDepartamento(String departamento);

    Funcionario findByNomeFuncionarioAndSalario(String nome, Double salario);

    Funcionario findFirstByOrderBySalarioDesc();

    List<Funcionario> findFirst3ByOrderBySalarioDesc();

    @Query("SELECT f FROM Funcionario f where f.qtdDependentes=0 group by f.nomeFuncionario order by f.nomeFuncionario")
    List<Funcionario> findByFuncionariosSemDependentesOrdemCrescente();

    @Query("select f from Funcionario f where f.salario > ?1")
    List<Funcionario> findBySalarioAfter(double salario);

    @Query(value = "select * from funcionario where salario > ?1", nativeQuery = true)
    List<Funcionario> findBySalarioNativeQuery(Double salario);

    @Query(name = "Funcionario.findByQtdDependentes")
    List<Funcionario> findByQtdDependentes(int dependentes);

    @Query(name = "Funcionario.findByParteDoNome")
    List<Funcionario> findByParteDoNome(String nome);

}