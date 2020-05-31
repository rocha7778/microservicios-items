package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Producto;


public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
