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

import com.ciclismo1.entity.Etapa;
import com.ciclismo1.model.EtapaModel;
import com.ciclismo1.repository.EtapaJpaRepository;
import com.ciclismo1.service.EtapaService;

@Controller
@RequestMapping("/etapas")
public class EtapaController {
	private static final String ETAPA_VIEW="etapas";
	private static final String CREATE_VIEW="create_etapa";
	
	
	@Autowired
	@Qualifier("etapaServiceImpl")
	private EtapaService etapaService;
	
	@Autowired
	@Qualifier("etapaJpaRepository")
	private EtapaJpaRepository etapaJpaRepository;
	
	@GetMapping("/listEtapas")
	public ModelAndView listAllEtapas() {
		ModelAndView mav = new ModelAndView(ETAPA_VIEW);
		mav.addObject("etapa",new Etapa());
		mav.addObject("etapas", etapaService.listAllEtapas());
		return mav;
	}
	
	@PostMapping("/addEtapa")
	public String addEtapa(@ModelAttribute("etapa") EtapaModel etapaModel) {
		etapaService.addEtapa(etapaModel);
		return "redirect:/etapas/listEtapas";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createEtapa(){
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("etapa",new Etapa());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deleteEtapa(@RequestParam("netapa") String netapa) {
		etapaService.removeEtapa(netapa);
		return "redirect:/etapas/listEtapas";
	}
}
