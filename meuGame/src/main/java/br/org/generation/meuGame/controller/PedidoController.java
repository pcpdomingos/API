package br.org.generation.meuGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.meuGame.model.PedidoModel;
import br.org.generation.meuGame.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> GetAll (){
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<PedidoModel> getById(@PathVariable long id){
		return pedidoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<PedidoModel>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(pedidoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<PedidoModel> postPedido (@RequestBody PedidoModel pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<PedidoModel> putPedido (@RequestBody PedidoModel pedido){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.save(pedido));
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable long id) {
		pedidoRepository.deleteById(id);
	}

	public PedidoRepository getPedidoRepository() {
		return pedidoRepository;
	}

	public void setPedidoRepository(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	

}
