package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidad.Estudiante;
import com.example.demo.entity.Seleccion;
import com.example.demo.repository.SeleccionRepository;
import com.example.demo.service.SeleccionService;

@Controller
public class IndexController {
	
	@Autowired
	SeleccionService seleccionService;
	
	
	@GetMapping("/")
	public String seleccionList(Model modelo) {
		modelo.addAttribute("selecciones" , seleccionService.listarSelecciones());
		return "index";
		
	}
	@PostMapping("/index")
	public String registroSeleccion(@ModelAttribute("seleccion") Seleccion seleccion) {
		seleccionService.saveSeleccion(seleccion);
		return "redirect:/index";
		
	}
	
	@PostMapping("/index/{id}")
	public String actualizarSeleccion(@PathVariable int id, @ModelAttribute("seleccion") Seleccion seleccion,
			Model modelo) {
		Seleccion existe = seleccionService.getSeleccionByID(id);
		existe.setId(id);
		existe.setNombre(seleccion.getNombre());
		existe.setGrupo(seleccion.getGrupo());
		existe.setContinente_id(seleccion.getContinente_id());
		
		

		seleccionService.actualizarSeleccion(existe);
		return "redirect:/index";
	}
	
	
	@GetMapping("/estudiantes/{id}")
	public String eliminarSeleccion(@PathVariable int id) {
		seleccionService.eliminarSeleccion(id);
		return "redirect:/estudiantes";
	}
	
	
	


}
