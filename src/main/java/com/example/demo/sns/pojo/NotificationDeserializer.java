package com.example.demo.sns.pojo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationDeserializer extends JsonDeserializer<Producto> {

	@Override
	public Producto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		 String text = p.getText();
		 return new ObjectMapper().readValue(text, Producto.class);
	}

}
