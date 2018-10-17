package com.citasmedicas.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citasmedicas.app.web.models.entity.Medico;
import com.citasmedicas.app.web.models.service.IMedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private IMedicoService service;
	//model es un envoltario para enviar datos a la vista
	//model no es el modelo que se mapeo con la tabla de la bdd, 
	//envia componentes desde el controllador a la vista
	
	@GetMapping("/list")
	public String list(Model model ){ 
		List<Medico> medicos=service.findAll();
		model.addAttribute("title","Listado de medicos");
		model.addAttribute("medicos",medicos);
		return "medico/list";
	}

}
