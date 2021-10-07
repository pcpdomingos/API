package br.org.generation.meuGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.meuGame.model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
	
	public List <PedidoModel> findAllByNomeContainingIgnoreCase (String nome);

}
