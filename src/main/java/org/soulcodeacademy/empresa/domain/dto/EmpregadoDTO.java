package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotNull;

public class EmpregadoDTO {
    @NotNull(message = "idEmpregado é obrigatório")
    private Integer idEmpregado;
    private String nome;
    private String email;
    private Double salario;

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
