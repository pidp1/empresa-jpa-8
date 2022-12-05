package org.soulcodeacademy.empresa.domain.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.services.errors.RecursoNaoEncontradoError;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    //listar todos
    // Listar todos
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }


    public Endereco getEndereco(Integer idEndereco) {

        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);

        if(endereco.isEmpty()) {

            throw new RecursoNaoEncontradoError("O cargo não foi encontrado!");
        } else {
            return endereco.get();
        }
    }
    // Salvar
    public Endereco salvar(EnderecoDTO dto) {

        Endereco endereco = new Endereco(null, dto.getCidade(), dto.getUf());
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);
        return enderecoSalvo;
    }

    public Endereco atualizar(Integer idEndereco, EnderecoDTO dto) {

        Endereco enderecoAtual = this.getEndereco(idEndereco);

        enderecoAtual.setCidade(dto.getCidade());
        enderecoAtual.setUf(dto.getUf());


        // Atualiza a entidade pois ela possui um ID diferente de nulo
        Endereco atualizado = this.enderecoRepository.save(enderecoAtual);
        return atualizado;
    }
    // Deletar
    public void deletar(Integer idCargo) {
        Endereco cargo = this.getEndereco(idCargo);
        // DELETE FROM cargo WHERE idCargo = ?
        this.enderecoRepository.delete(cargo);
    }
}
