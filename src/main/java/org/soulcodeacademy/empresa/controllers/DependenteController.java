package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.domain.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class DependenteController {

    @Autowired
    private DependenteService dependenteService;



    @GetMapping("/dependente")
    public List<Dependente> listarDependentes() {
        return this.dependenteService.listarDependentes();
    }

    @GetMapping("/dependente/{idDependente}")
    public Dependente getChamado(@PathVariable Integer idDependente) {
        return this.dependenteService.getDependente(idDependente);
    }

    @PostMapping("/dependente")
    public Dependente salvarDependente(@Valid @RequestBody DependenteDTO dto) {
        Dependente dependente = this.dependenteService.salvar(dto);
        return dependente;
    }

    @PutMapping("/dependente/{idDependente}")
    public Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto) {
        return this.dependenteService.atualizar(idDependente, dto);
    }

    @GetMapping("/dependentes/empregados")
    public List<Dependente> listarPorEmpregado(@RequestParam Empregado empregado) {
        return this.dependenteService.listarPorEmpregado(empregado);
    }


}
