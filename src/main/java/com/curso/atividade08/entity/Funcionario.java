package com.curso.atividade08.entity;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
@NamedQueries({
        @NamedQuery(name = "Funcionario.findByQtdDependentes",
                query = "Select f from Funcionario f where f.qtdDependentes =?1 ")
})
@NamedNativeQuery(
        name = "Funcionario.findByParteDoNome",
        query = "select * from Funcionario where nome_funcionario LIKE CONCAT('%', ?1, '%')",
        resultClass = Funcionario.class)
public class Funcionario {

    @Id
    @Column(name = "cod_funcionario")
    private int codFuncionario;

    @ManyToOne
    @JoinColumn(name = "cod_departamento")
    private Departamento departamento;

    @Column(name = "qtd_dependentes")
    private int qtdDependentes;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "nome_funcionario")
    private String nomeFuncionario;


    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }

    public void setQtdDependentes(int qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }
}
