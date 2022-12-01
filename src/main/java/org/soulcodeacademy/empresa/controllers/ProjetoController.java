package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoservice;
    @GetMapping("/projetos")
    public List<Projeto> listar(){
        return this.projetoservice.listar();
    }
    @GetMapping("/projetos/{idProjeto}")
    public Projeto getProjeto(@PathVariable Integer idProjeto){
        return this.projetoservice.getProjeto(idProjeto);
    }
    @PostMapping("/projetos")
    public Projeto salvar(@Valid @RequestBody ProjetoDTO projeto){
        Projeto salvo= this.projetoservice.salvar(projeto);
        return salvo;
    }
    @PutMapping("/projetos/{idProjeto}")
    public Projeto atualizar(@PathVariable Integer idProjeto,@Valid @RequestBody ProjetoDTO projeto){
        Projeto atualizado = this.projetoservice.atualizar(idProjeto, projeto);
        return atualizado;
    }
    @DeleteMapping("/projetos/{idProjeto}")
    public void deletar(@PathVariable Integer idProjeto){
        this.projetoservice.deletar(idProjeto);
    }
}
