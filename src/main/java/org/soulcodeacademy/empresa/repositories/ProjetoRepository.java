package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    List<Projeto> findByNome(String valor); // WHERE nome = valor
    List<Projeto> findByOrcamento(Double valor);
    List<Projeto> findByOrcamentoGreaterThan(Double valor);
    List<Projeto> findByOrcamentoGreaterThanEqual(Double valor);
    List<Projeto> findByOrcamentoLessThan(Double valor);
    List<Projeto> findByOrcamentoLessThanEqual(Double valor);
    List<Projeto> findByOrcamentoBetween(Double valor1, Double valor2);
}
