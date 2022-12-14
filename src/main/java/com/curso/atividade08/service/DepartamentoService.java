package com.curso.atividade08.service;

import com.curso.atividade08.entity.Departamento;
import com.curso.atividade08.entity.Funcionario;
import com.curso.atividade08.repository.DepartamentoRepository;
import com.curso.atividade08.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Departamento findFirstBy() {
        return repository.findFirstBy();
    }


    @Transactional(readOnly = false)
    public void salvarDepartamentoEFuncionario(Departamento departamento, Funcionario funcionario) {
        repository.save(departamento);
        funcionario.setDepartamento(departamento);
        funcionarioRepository.save(funcionario);
    }

    /*public void salvar(Departamento departamento) {
        repository.save(departamento);
    }

    public Optional<Departamento> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public List<Departamento> buscarTodos() {

        return repository.findAll();
    }*/

}

