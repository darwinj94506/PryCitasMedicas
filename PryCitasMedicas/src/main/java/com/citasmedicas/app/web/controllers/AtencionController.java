package com.citasmedicas.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.citasmedicas.app.web.models.entity.Medico;
import com.citasmedicas.app.web.models.service.IAtencionService;
import com.citasmedicas.app.web.models.service.IMedicoService;

@Controller
@RequestMapping("/atencion")
@SessionAttributes("atencion")
public class AtencionController {
	@Autowired 
	private IAtencionService service;
	
	@Autowired 
	private IMedicoService srvMedico;
	
	@GetMapping("/setup")
	public String setup(Model model) {
		List<Medico> medicos=srvMedico.findAll();
		model.addAttribute("medico",medicos);
		return "atencion/setup";
	}
	
	
}
