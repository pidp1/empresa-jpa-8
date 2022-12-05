package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping("/endereco")
    public List<Endereco> listar() {
        // Requisição -> Controller -> Service -> Repository -> SELECT * FROM cargo;
        return this.enderecoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }

    @GetMapping("/endereco/{idEndereco}") // indica que o valor após a barra é dinâmico!
    public Endereco getEndereco(@PathVariable Integer idEndereco) {
        // @PathVariable => extrai do endpoint o valor dinâmico
        return this.enderecoService.getEndereco(idEndereco);
    }

    // Podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/endereco") // REQUISIÇÃO TIPO POST para /cargos
    public Endereco salvar(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        // @RequestBody - extrair o JSON do corpo e converte para Cargo (deserialização)
        Endereco salvo = this.enderecoService.salvar(enderecoDTO);
        return salvo; // A resposta será o cargo inserido
    }

    // Mapeia requisições do verbo PUT
    @PutMapping("/endereco/{idEndereco}") // /cargos/5
    public Endereco atualizar(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        Endereco atualizado = this.enderecoService.atualizar(idEndereco, enderecoDTO);
        return atualizado; // Resposta para o cliente (cargo atualizado)
    }

    @DeleteMapping("/endereco/{idEndereco}") // Verbo DELETE no /cargos/1
    public void deletar(@PathVariable Integer idCargo) {
        this.enderecoService.deletar(idCargo);
    }
}




