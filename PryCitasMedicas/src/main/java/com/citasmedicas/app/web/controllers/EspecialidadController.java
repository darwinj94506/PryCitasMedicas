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

import com.citasmedicas.app.web.models.entity.Especialidad;
import com.citasmedicas.app.web.models.entity.Medico;
import com.citasmedicas.app.web.models.service.IEspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {
	@Autowired
	private IEspecialidadService service;
	
	@GetMapping("/list")
	public String list(Model model ){ 
		List<Especialidad> especialidad=service.findAll();
		model.addAttribute("title","Listado de especialidades");
		model.addAttribute("especialidades",especialidad);
		return "especialidad/list";
	}
	
	@GetMapping("/form")
	public String create(Model model ){ 
		model.addAttribute("title","Nueva especialidad");
		Especialidad especialidad=new Especialidad();
		model.addAttribute("especialidad",especialidad);

		return "especialidad/form";
	}
	
	@PostMapping("/form")
	public String save(Especialidad especialidad, RedirectAttributes flash ){ 
		try {
			service.saveEspecialidad(especialidad);
			flash.addFlashAttribute("success","la especialidad se creo correctamente");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error","Hubo un error".concat(ex.getMessage()));

		}
		
		return "redirect:/especialidad/list";
	}
	

	@GetMapping("/form/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Actualizando una especialidad");
			Especialidad especialidad=service.findById(id);
			model.addAttribute("especialidad",especialidad);
			return "especialidad/form";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Medico no encontrado:".concat(ex.getMessage()));
			return "redirect:/especialidad/list";
		}
		
		
		
	}

	@GetMapping("/card/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Detalle una especialidad");
			Especialidad especialidad=service.findById(id);
			model.addAttribute("especialidad",especialidad);
			return "especialidad/card";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Especialdidad no encontrado:".concat(ex.getMessage()));
			return "redirect:/especialidad/list";
		}	
		
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			service.delete(id);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Hubo un error:".concat(ex.getMessage()));
		}	
		return "redirect:/especialidad/list";
		
	}
	
	

	

}
