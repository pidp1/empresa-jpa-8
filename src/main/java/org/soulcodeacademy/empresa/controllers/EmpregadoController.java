package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;
    //listar todos
    @GetMapping("/empregados")
    public List<Empregado> listar() {
        return this.empregadoService.listar();
    }

    //lista por id
    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado) {
        return this.empregadoService.getEmpregado(idEmpregado);
    }
    //salva
    @PostMapping("/empregados")
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto) {
        Empregado empregado = this.empregadoService.salvar(dto);
        return empregado;
    }
    //atualizar
    @PutMapping("/empregados/{idempregado}")
    public Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idEmpregado, dto);
        return atualizado;
    }
    //deletar
    public void deletar(@PathVariable Integer idEmpregado) {

        this.empregadoService.deletar(idEmpregado);
    }

}