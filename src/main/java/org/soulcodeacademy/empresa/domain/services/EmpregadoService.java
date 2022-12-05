package org.soulcodeacademy.empresa.domain.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.services.errors.RecursoNaoEncontradoError;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;



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
        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        Empregado empregadoSalvo = this.empregadoRepository.save(empregado);
        return empregadoSalvo;
    }




    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto) {
        // Buscar empregado
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);

        Endereco enderecoAtual = this.enderecoService.getEndereco(dto.getEmpregado());

        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        empregadoAtual.setEndereco(enderecoAtual);


        Empregado atualizado = this.empregadoRepository.save(empregadoAtual);
        return atualizado;
    }

    public void deletar(Integer idEmpregado) {
        Empregado empregado = this.getEmpregado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }
}