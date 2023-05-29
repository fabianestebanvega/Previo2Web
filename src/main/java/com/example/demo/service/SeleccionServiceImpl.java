package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Seleccion;
import com.example.demo.repository.SeleccionRepository;

public class SeleccionServiceImpl implements SeleccionService {
	
	@Autowired
	private SeleccionRepository repo;

	@Override
	public Iterable<Seleccion> listarSelecciones() {
		return repo.findAll();
	}

	@Override
	public Seleccion saveSeleccion(Seleccion selecion) {
		// TODO Auto-generated method stub
		return repo.save(selecion);
	}

	@Override
	public Seleccion getSeleccionByID(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Seleccion actualizarSeleccion(Seleccion seleccion) {
		// TODO Auto-generated method stub
		return repo.save(seleccion);
	}
	@Override
	public void eliminarSeleccion(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}
	
	




}
