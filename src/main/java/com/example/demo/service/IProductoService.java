package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;


public interface IProductoService {
	public Producto findById(Long id);
	public Producto save(Producto producto);
	public List<Producto>findAll();
}
