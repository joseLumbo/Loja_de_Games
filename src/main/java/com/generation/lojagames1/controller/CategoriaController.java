package com.generation.lojagames1.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.generation.lojagames1.model.Categoria;
import com.generation.lojagames1.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria") 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	
	@Autowired 
	private CategoriaRepository CategoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll (){
		return ResponseEntity.ok(CategoriaRepository.findAll());
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		return CategoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());			
		}
		
	@PostMapping
	public ResponseEntity<Categoria> postCategoria (@Valid @RequestBody Categoria Categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepository.save(Categoria));
			
		}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria Categoria){
		return ResponseEntity.status(HttpStatus.OK).body(CategoriaRepository.save(Categoria));
	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		CategoriaRepository.deleteById(id);
	}	
}



