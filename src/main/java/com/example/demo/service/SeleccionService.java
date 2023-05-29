package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Seleccion;
import com.example.demo.repository.SeleccionRepository;

public interface SeleccionService {
	
	public Iterable<Seleccion> listarSelecciones();
	
	public Seleccion saveSeleccion(Seleccion selecion);
	
	public Seleccion getSeleccion(int id);
	
	

}
