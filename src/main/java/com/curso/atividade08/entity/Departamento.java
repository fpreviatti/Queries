package com.curso.atividade08.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "departamento")
public class Departamento{

    @Id
    @Column(name = "cod_departamento")
    private int codDepartamento;

    @Column(name = "nome_departamento")
    private String nomeDepartamento;

    @OneToMany(mappedBy="departamento")
    private List<Funcionario> funcionarios;

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
