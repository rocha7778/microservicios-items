package com.example.demo.repository;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.Producto;

@FeignClient(value = "servicio-producto" , url="http://localhost:8880")
public interface ProductoClienteRestFeing {
	
	@GetMapping("/productos")
	public List<Producto> findAll();
	
	@GetMapping("/productos/{id}")
	public Producto getProductoById(@PathVariable Long id);
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody Producto producto);
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id);
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto upDateProducto(@PathVariable Long id,@RequestBody Producto producto);

}
