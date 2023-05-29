package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.SeleccionRepository;
import com.example.demo.service.SeleccionService;

@Controller
public class IndexController {
	
	@Autowired
	SeleccionService seleccionService;
	
	
	@GetMapping("/")
	public String seleccionList(Model modelo) {
		modelo.addAttribute("seleccion" , seleccionService.listarSelecciones());
		return "index";
		
	}

}
