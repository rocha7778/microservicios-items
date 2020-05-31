package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {

	private static final long serialVersionUID = 1940117426283265687L;
	@Id
	private Long id;
	private String nombre;
	private Double precio;
	private Double descuento;
	
	

}
