package br.org.generation.meuGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.meuGame.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
		
		public List <CategoriaModel> findAllByProdutoContainingIgnoreCase(String produto);
	}


