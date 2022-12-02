package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EmpregadoService empregadoService;
    @Autowired
    private RecursoNaoEncontradoError recursoNaoEncontradoError;
    public List<Dependente> listarDependentes() {
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependente) {

        return this.dependenteRepository.findById(idDependente)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Dependente não encontrado"));
    }

    public Dependente salvar(DependenteDTO dto) {

        //Empregado empregado = this.empregadoService.getEmpregado(dto.getIdEmpregado());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());
        //dependente.setResponsavel(empregado);

        return this.dependenteRepository.save(dependente);
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto) {
        Dependente dependenteAtual = this.getDependente(idDependente);
        Empregado empregado = this.empregadoService.getResponsavel(dto.getIdEmpregado());
        dependenteAtual.setNome(dto.getNome());
        dependenteAtual.setIdade(dto.getIdade());
        dependenteAtual.setResponsavel(empregado);


        return this.dependenteRepository.save(dependenteAtual);
    }

    public void deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }


}
