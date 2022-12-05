package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    public List<Empregado> listar(){
        return this.empregadoRepository.findAll();

    }
    public Empregado getEmpregado(Integer idEmpregado){
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);
        if (empregado.isEmpty()){
            throw new RecursoNaoEncontradoError("O empregado não foi encontrado!");
        }else {
            return empregado.get();
        }
    }

    public Empregado salvar(EmpregadoDTO dto) {
        // INSERT INTO cargo
        Empregado empregado = new Empregado();
        Empregado empregadoSalvo = this.empregadoRepository.save(empregado);
        return empregadoSalvo;
    }

    public List<Empregado> listarPorFaixaSalarial(Double valor1, Double valor2) {
        return this.empregadoRepository.findBySalarioEntreFaixas(valor1, valor2);
    }

    public Empregado salvar(EmpregadoDTO dto) {
        Empregado empregado = this.empregadoService.getEmpregado(dto.getIdEmpregado());
        // verifica se o empregado existe mesmo

        Empregado Empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        Empregado salvo = this.empregadoRepository.save(empregado);

        return salvo;
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto) {
        // Buscar empregado
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        // Buscar dados do empregado a ser alterado
        Empregado empregado = this.empregadoService.getEmpregado(dto.getIdEmpregado());

        EmpregadoAtual.setNome(dto.getNome());
        EmpregadoAtual.setEmail(dto.getEmail());
        EmpregadoAtual.setEmail(dto.getSalario());
        EmpregadoAtual.setEmail(dto.getEndereco());


        Empregado atualizado = this.empregadoRepository.save(EmpregadoAtual);
        return atualizado;
    }

    public void deletar(Integer idEmpregado) {
        Empregado empregado = this.getEmpregado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }
}
