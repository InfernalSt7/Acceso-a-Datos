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

import com.ciclismo1.entity.Maillot;
import com.ciclismo1.model.MaillotModel;
import com.ciclismo1.repository.MaillotJpaRepository;
import com.ciclismo1.service.MaillotService;

@Controller
@RequestMapping("/maillots")
public class MaillotController {
	private static final String MAILLOT_VIEW="maillots";
	private static final String CREATE_VIEW="create_maillot";
	
	
	@Autowired
	@Qualifier("maillotServiceImpl")
	private MaillotService maillotService;
	
	@Autowired
	@Qualifier("maillotJpaRepository")
	private MaillotJpaRepository maillotJpaRepository;
	
	@GetMapping("/listMaillots")
	public ModelAndView listAllMaillots() {
		ModelAndView mav = new ModelAndView(MAILLOT_VIEW);
		mav.addObject("maillot",new Maillot());
		mav.addObject("maillots", maillotService.listAllMaillots());
		return mav;
	}
	
	@PostMapping("/addMaillot")
	public String addMaillot(@ModelAttribute("maillot") MaillotModel maillotModel) {
		maillotService.addMaillot(maillotModel);
		return "redirect:/maillots/listMaillots";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createMaillot(){
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("maillot",new Maillot());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deleteMaillot(@RequestParam("codigo") String codigo) {
		maillotService.removeMaillot(codigo);
		return "redirect:/maillots/listMaillots";
	}
}
