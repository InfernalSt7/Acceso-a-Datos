package com.ciclismo1.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciclismo1.component.PDF;
import com.ciclismo1.entity.Ciclista;
import com.ciclismo1.model.CiclistaModel;
import com.ciclismo1.model.EquipoModel;
import com.ciclismo1.repository.CiclistaJpaRepository;
import com.ciclismo1.service.CiclistaService;


@Controller
@RequestMapping("/ciclistas")
public class CiclistaController {
	private static final String CICLISTA_VIEW="ciclistas";
	private static final String CREATE_VIEW="create_ciclista";
	
	private static final Log LOG=LogFactory.getLog(CiclistaController.class);
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("ciclistaJpaRepository")
	private CiclistaJpaRepository ciclistaJpaRepository;
	
	private PDF pdfciclista = new PDF();
	
	
	@GetMapping("/listCiclistas")
	public ModelAndView listAllCiclistas() {
		ModelAndView mav = new ModelAndView(CICLISTA_VIEW);
		mav.addObject("ciclista",new Ciclista());
		mav.addObject("ciclistas", ciclistaService.listAllCiclistas());
		return mav;
	}
	
	@PostMapping("/addCiclista")
	public String addCiclista(@RequestParam("imagen") MultipartFile img, @Valid @ModelAttribute("ciclista") CiclistaModel ciclistaModel, BindingResult result,
			RedirectAttributes flash, Model model) {
		
		if (result.hasErrors()) {
			return "redirect:/equipos/listCiclistas";
		}else {
			if(!img.isEmpty()) {
				Path directory=Paths.get(".//src//main//resources//static//img");
				String ruta=directory.toFile().getAbsolutePath();
				LOG.info("ruta"+ruta);
				try {
					byte[] bytes=img.getBytes();
					Path rutaCompleta=Paths.get(ruta+"\\"+ciclistaModel.getDorsal()+ciclistaModel.getNombre()+".png");
					LOG.info("test"+rutaCompleta);
					Files.write(rutaCompleta,bytes);
					ciclistaModel.setFoto("/img/"+ciclistaModel.getDorsal() + ciclistaModel.getNombre()+".png");
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				
				ciclistaModel.setFoto("/img/icono.png");
				LOG.info("/img/icono.png");
			}
			ciclistaService.addCiclista(ciclistaModel);
		}
		return "redirect:/ciclistas/listCiclistas";
	}

	 		
	
	@GetMapping("/create")
	public ModelAndView createCiclista(){
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("ciclista",new Ciclista());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deleteCiclista(@RequestParam("dorsal") int dorsal) {
		ciclistaService.removeCiclista(dorsal);
		return "redirect:/ciclistas/listCiclistas";
	}
	
	@GetMapping("/generarPDF")
	public String generarPDF(RedirectAttributes flash) {
		List<CiclistaModel> list=ciclistaService.listAllCiclistas();
		pdfciclista.PDFCiclista(list);
		flash.addFlashAttribute("success","PDF generado correctamente");
		return "redirect:/ciclistas/listCiclistas";
		
	}
}
