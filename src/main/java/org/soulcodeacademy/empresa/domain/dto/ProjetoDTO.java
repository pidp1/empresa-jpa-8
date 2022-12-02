package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjetoDTO {

    @NotBlank(message = "Este campo é obrigatorio")
    private String nome;
    @NotNull(message = "Este campo é obrigatorio")
    @Min(value = 500, message = "Campo orçamento inválido")
    @Max(value = 100000, message = "Campo orçamento inválido")
    private Double orcamento;
    @NotBlank(message = "Este campo é obrigatorio")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}