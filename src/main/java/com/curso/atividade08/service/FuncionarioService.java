package com.curso.atividade08.service;

import com.curso.atividade08.entity.Funcionario;
import com.curso.atividade08.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public Optional<Funcionario> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public List<Funcionario> buscarTodos() {

        return repository.findAll();
    }

    public Funcionario buscarPorNomeSalario() {
      return repository.findByNomeFuncionarioAndSalario("Pamela Larissa", 4000.00d);
    }


    public Funcionario findByNomeFuncionarioAndQtdDependentes(String nome, int qtdDependentes) {
        return repository.findByNomeFuncionarioAndQtdDependentes(nome,qtdDependentes);
    }

    public Funcionario findFirstByOrderBySalarioDesc() {
        return repository.findFirstByOrderBySalarioDesc();
    }

    public List<Funcionario> findFirst3ByOrderBySalarioDesc(){
        List<Funcionario> listFuncionarios = repository.findFirst3ByOrderBySalarioDesc();
        return listFuncionarios;
    }

    public List<Funcionario> findByDepartamento(String departamento) {
        return repository.findByDepartamento(departamento);
    }

    public List<Funcionario> findByFuncionariosSemDependentesOrdemCrescente() {
        return repository.findByFuncionariosSemDependentesOrdemCrescente();
    }

    public List<Funcionario> findBySalarioAfter(Double salario){
        return repository.findBySalarioAfter(salario);
    }

    public List<Funcionario> findBySalarioNativeQuery(Double salario){
        return repository.findBySalarioNativeQuery(salario);
    }

    public List<Funcionario> findByQtdDependentes(int dependentes){
        return repository.findByQtdDependentes(dependentes);
    }

    public List<Funcionario> findByParteDoNome(String nome){
        return repository.findByParteDoNome(nome);
    }

    public void aumentarSalario(int x){
       repository.aumentaSalario(x);
    }

    public List<Funcionario> findByDepartamentoSemDependentes(String departamento) {
        return repository.findByDepartamentoSemDependentes(departamento);
    }

    public void updateDepartamentoFuncionarioByld(int idNovoDepartamento,int idDepartamentoAtual) {
        repository.updateDepartamentoFuncionarioByld(idNovoDepartamento, idDepartamentoAtual);
    }

    public void excluirFuncionariosPorCodigoDepartamento(int codDepartamento) {
        repository.excluirFuncionariosPorCodigoDepartamento(codDepartamento);
    }

}