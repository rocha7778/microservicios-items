package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	

	@Override
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(new Producto());
	}
	
	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}
	
	
	


}
