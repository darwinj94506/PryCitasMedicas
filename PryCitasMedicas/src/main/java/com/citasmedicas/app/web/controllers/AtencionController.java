package com.citasmedicas.app.web.controllers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.citasmedicas.app.web.filters.AtencionFilter;
import com.citasmedicas.app.web.models.entity.Atencion;
import com.citasmedicas.app.web.models.entity.Medico;
import com.citasmedicas.app.web.models.service.IAtencionService;
import com.citasmedicas.app.web.models.service.IMedicoService;

@Controller
@RequestMapping("/atencion")
@SessionAttributes("atencion")
public class AtencionController {
	@Autowired 
	private IAtencionService service;
	
	@PostMapping(value="/agenda", produces="application/json")
	public @ResponseBody List<Atencion> agenda(@RequestBody AtencionFilter criteria) {
		
		List<Atencion> citas = new ArrayList<Atencion>();
		
		try {		
			Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(criteria.getInicio());
			Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(criteria.getFin());
			citas = service.findByFecha(fechaInicio, fechaFin, criteria.getIdmedico());			
		}
		catch(Exception ex) {			
		}
		
		return citas;
	}
	
	
	
	
	
	
	@Autowired 
	private IMedicoService srvMedico;
	
	@GetMapping("/setup")
	public String setup(Model model) {
		List<Medico> medicos=srvMedico.findAll();
		model.addAttribute("medicos",medicos);
		return "atencion/setup";
	}
	
	@GetMapping(value="/week/{inicio}/{fin}/{id}", produces="application/json")
	public @ResponseBody List<Atencion> week(
			@PathVariable(value="inicio")String inicio,
			@PathVariable(value="fin")String fin,
			@PathVariable(value="id")Integer id) {
		List<Atencion> citas =new ArrayList<Atencion>();

		try {
			Date fechaInicio=new SimpleDateFormat("yyyy-MM-dd").parse(inicio);
			Date fechaFin=new SimpleDateFormat("yyyy-MM-dd").parse(fin);
			citas =service.findByFecha(fechaInicio, fechaFin, id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return citas;
	}
	
	
}
