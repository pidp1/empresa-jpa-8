package org.soulcodeacademy.empresa.domain.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listar() {
        return this.empregadoService.listar();
    }

    @GetMapping("/empregados/salario")
    public List<Empregado> listarPorFaixaSalarial(@RequestParam Double valor1, @RequestParam Double valor2) {
        return this.empregadoService.listarPorFaixaSalarial(valor1, valor2);
    }

    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado) {
        return this.empregadoService.getEmpregado(idEmpregado);
    }

    @PostMapping("/empregados")
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto) {
        Empregado empregado = this.empregadoService.salvar(dto);
        return empregado;
    }

    @PutMapping("/empregados/{idempregado}")
    public Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idEmpregado, dto);
        return atualizado;
    }
}
