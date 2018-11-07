package com.citasmedicas.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/form")
	public String create(Model model ){ 
		model.addAttribute("title","Nuevo Medico");
		Medico medico=new Medico();
		model.addAttribute("medico",medico);

		return "medico/form";
	}
	
	@PostMapping("/form")
	public String save(@Valid Medico medico, BindingResult result,  RedirectAttributes flash, Model model ){ 
		try {
			if(result.hasErrors()) {
				model.addAttribute("title","nuevo medico");
				model.addAttribute("medico",medico);
				return "medico/form";
				
			}
			service.saveMedico(medico);
			flash.addFlashAttribute("success","El medico se creo correctamente");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error","Hubo un error".concat(ex.getMessage()));

		}
		
		
		return "redirect:/medico/list";
	}
	

	@GetMapping("/form/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Actualizando un medico");
			Medico medico=service.findById(id);
			model.addAttribute("medico",medico);
			return "medico/form";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Medico no encontrado:".concat(ex.getMessage()));
			return "redirect:/medico/list";
		}
		
		
		
	}

	@GetMapping("/card/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			model.addAttribute("title","Detalle un medico");
			Medico medico=service.findById(id);
			model.addAttribute("medico",medico);
			return "medico/card";
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Medico no encontrado:".concat(ex.getMessage()));
			return "redirect:/medico/list";
		}	
		
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash ){ 
		try {
			service.delete(id);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error","Hubo un error:".concat(ex.getMessage()));
		}	
		return "redirect:/medico/list";
		
	}
	
	

}
