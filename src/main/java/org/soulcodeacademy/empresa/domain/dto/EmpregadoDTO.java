package org.soulcodeacademy.empresa.domain.dto;

import org.soulcodeacademy.empresa.domain.Endereco;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {

    @NotBlank(message = "Este campo é obrigatorio")
    private Integer idEmpregado;

    @NotBlank(message = "Este campo é obrigatorio")
    private String nome;

    @NotBlank(message = "Este campo é obrigatorio")
    private String email;

    @NotNull(message = "Este campo é obrigatorio")
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
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