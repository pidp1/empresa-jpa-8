package org.soulcodeacademy.empresa.domain.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.soulcodeacademy.empresa.domain.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    //Listar todos os projetos
    public List<Projeto> listar(){
        return this.projetoRepository.findAll();
    }
    //Listar pelo ID
    public Projeto getProjeto(Integer idProjeto){
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()){
            throw new RecursoNaoEncontradoError("O cargo não foi encontrado!");
        }else {
            return projeto.get();
        }
    }

    // Salvar
    public Projeto salvar(ProjetoDTO dto) {
        // INSERT INTO cargo
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());
        Projeto projetoSalvo = this.projetoRepository.save(projeto);
        return projetoSalvo;
    }

    // Atualizar
    // Precisa do ID e dos dados atualizados
    public Projeto atualizar(Integer idProjeto, ProjetoDTO dto) {
        // Verificar projeto
        Projeto projetoAtual = this.getProjeto(idProjeto);

        projetoAtual.setNome(dto.getNome());
        projetoAtual.setDescricao(dto.getDescricao());
        projetoAtual.setOrcamento(dto.getOrcamento());

        // Atualiza a entidade pois ela possui um ID diferente de nulo
        Projeto atualizado = this.projetoRepository.save(projetoAtual);
        return atualizado;
    }
    // Deletar
    public void deletar(Integer idProjeto) {
        Projeto projeto = this.getProjeto(idProjeto);
        // DELETE FROM cargo WHERE idCargo = ?
        this.projetoRepository.delete(projeto);
    }

}
