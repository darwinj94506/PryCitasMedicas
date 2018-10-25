package com.citasmedicas.app.web.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.citasmedicas.app.web.models.entity.Medico;
import com.citasmedicas.app.web.models.entity.Paciente;
import com.citasmedicas.app.web.models.service.IPacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private IPacienteService service;



	@GetMapping("/list")
	public String list(Model model ){ 
		List<Paciente>pacientes=service.findAll();
		model.addAttribute("title","Listado de pacientes");
		model.addAttribute("pacientes",pacientes);
		return "paciente/list";
	}
	
	@GetMapping("/form")
	public String create(Model model) {
		model.addAttribute("title","Nuevo Paciente");
		Paciente paciente=new Paciente();
		model.addAttribute("paciente",paciente);
		return "paciente/form";
	}
	
	@PostMapping("/form")
	public String save(Paciente paciente, RedirectAttributes flash) {
		try {
			service.savePaciente(paciente);
			flash.addAttribute("success","El paciente se ha registrado");
		}catch(Exception ex) {
			flash.addAttribute("error","hubo un error".concat(ex.getMessage()));
		}
		return "redirect:/paciente/list";
	}
	
	@GetMapping("/form/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Actualizando un paciente");
			Paciente paciente=service.findById(id);
			model.addAttribute("paciente",paciente);
			return "paciente/form";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Paciente no encontrado:".concat(ex.getMessage()));
			return "redirect:/paciente/list";
		}	
	}
	
	@GetMapping("/card/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Detalle un paciente");
			Paciente paciente=service.findById(id);
			model.addAttribute("paciente",paciente);
			return "paciente/card";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Paciente no encontrado:".concat(ex.getMessage()));
			return "redirect:/paciente/list";
		}	
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			service.delete(id);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Hubo un error:".concat(ex.getMessage()));
		}	
		return "redirect:/paciente/list";
		
	}
	
	
	
	
	
	
}
