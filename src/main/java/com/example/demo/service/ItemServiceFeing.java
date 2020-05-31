package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoClienteRestFeing;

@Service("itemServiceFeing")
public class ItemServiceFeing implements ItemService {
	
	
	@Autowired
	private ProductoClienteRestFeing clientFeignService;
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	

	@Override
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(productoService.findById(id),cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return productoService.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		clientFeignService.deleteById(id);
	}

	@Override
	public Producto update(Producto producto,Long id) {
		
		Producto productoBd = clientFeignService.getProductoById(id);
		productoBd.setNombre(producto.getNombre());
		productoBd.setPrecio(producto.getPrecio());
		
		return clientFeignService.save(productoBd);
	}

}
