package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Item;
import com.example.demo.entity.Producto;

public interface ItemService {
	
	public List<Producto> findAll();
	public Item findById (Long id, Integer cantidad);
	public Producto save(Producto producto);
	public void deleteById(Long id);
	public Producto update(Producto producto,Long id);

}
