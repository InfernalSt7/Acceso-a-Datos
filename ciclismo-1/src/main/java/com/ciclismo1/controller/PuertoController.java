package com.ciclismo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ciclismo1.entity.Puerto;
import com.ciclismo1.model.PuertoModel;
import com.ciclismo1.repository.PuertoJpaRepository;
import com.ciclismo1.service.PuertoService;

@Controller
@RequestMapping("/puertos")
public class PuertoController {
	private static final String PUERTO_VIEW="puertos";
	private static final String CREATE_VIEW="create_puerto";
	
	
	@Autowired
	@Qualifier("puertoServiceImpl")
	private PuertoService puertoService;
	
	@Autowired
	@Qualifier("puertoJpaRepository")
	private PuertoJpaRepository puertoJpaRepository;
	
	@GetMapping("/listPuertos")
	public ModelAndView listAllPuertos() {
		ModelAndView mav = new ModelAndView(PUERTO_VIEW);
		mav.addObject("puerto",new Puerto());
		mav.addObject("puertos", puertoService.listAllPuertos());
		return mav;
	}
	
	@PostMapping("/addPuerto")
	public String addPuerto(@ModelAttribute("puerto") PuertoModel puertoModel) {
		puertoService.addPuerto(puertoModel);
		return "redirect:/puertos/listPuertos";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createPuerto(){
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("puerto",new Puerto());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deletePuerto(@RequestParam("nompuerto") String nompuerto) {
		puertoService.removePuerto(nompuerto);
		return "redirect:/puertos/listPuertos";
	}
}
