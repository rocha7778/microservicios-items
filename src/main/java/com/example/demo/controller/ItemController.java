package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.entity.Producto;
import com.example.demo.service.ItemService;
import com.example.demo.sns.pojo.SNSMessage;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ItemController {
	
	
	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndpoint;
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	@Qualifier("itemServiceFeing")
	private ItemService itemservice;

	@GetMapping("/items")
	public List<Producto> getItems() {
		return itemservice.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "circuitBreakerGetItem")
	@GetMapping("/items/{id}/cantidad/{cantidad}")
	public Item getItem(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemservice.findById(id, cantidad);
	}
	
	@SqsListener("spring-boot-sqs")
	public void getProductoFromSQS(String snsMessageJsonFormat) {
		Gson gson = new Gson();
		System.out.println(snsMessageJsonFormat);
		SNSMessage snsMessage = gson.fromJson(snsMessageJsonFormat, SNSMessage.class);
		Producto producto = gson.fromJson(snsMessage.getMessage(), Producto.class);
		itemservice.save(producto);
	}
	
	

	public Item circuitBreakerGetItem(Long id, Integer cantidad) {

		Item item = new Item();
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre("Patineta electrica - oferta del dia");
		producto.setPrecio(1000.00);
		item.setCantidad(cantidad);
		item.setProducto(producto);
		
		return item;

	}
	
	
	

}
