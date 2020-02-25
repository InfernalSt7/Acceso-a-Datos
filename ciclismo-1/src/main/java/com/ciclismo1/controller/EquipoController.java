package com.ciclismo1.controller;

import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

import com.ciclismo1.entity.Equipo;
import com.ciclismo1.model.CiclistaModel;
import com.ciclismo1.model.EquipoModel;
import com.ciclismo1.repository.EquipoJpaRepository;
import com.ciclismo1.service.EquipoService;
import com.ciclismo1.component.PDF;
import com.ciclismo1.controller.EquipoController;

@Controller
@RequestMapping("/equipos")
public class EquipoController {
	private static final String EQUIPO_VIEW="equipos";
	private static final String CREATE_VIEW="create_equipo";
	
	private static final Log LOG=LogFactory.getLog(EquipoController.class);
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("equipoJpaRepository")
	private EquipoJpaRepository equipoJpaRepository;
	
	private PDF pdfequipo = new PDF();
	
	@GetMapping("/listEquipos")
	public ModelAndView listAllEquipos() {
		ModelAndView mav = new ModelAndView(EQUIPO_VIEW);
		mav.addObject("equipo",new Equipo());
		mav.addObject("equipos", equipoService.listAllEquipos());
		return mav;
	}
	
	@PostMapping("/addEquipo")
	public String addEquipo(@RequestParam("imagen") MultipartFile foto, @Valid @ModelAttribute("equipo") EquipoModel equipoModel, BindingResult result,
			RedirectAttributes flash, Model model) {
		
		if (result.hasErrors()) {
			return "redirect:/equipos/listEquipos";
		}else {
			if(!foto.isEmpty()) {
				Path directory=Paths.get(".//src//main//resources//static//img");
				String ruta=directory.toFile().getAbsolutePath();
				LOG.info("ruta"+ruta);
				try {
					byte[] bytes=foto.getBytes();
					Path rutaCompleta=Paths.get(ruta+"\\"+equipoModel.getNomeq()+".png");
					LOG.info("test"+rutaCompleta);
					Files.write(rutaCompleta,bytes);
					equipoModel.setLogo("/img/"+equipoModel.getNomeq()+".png");
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				
				equipoModel.setLogo("/img/Banesto.png");
				LOG.info("/img/Banesto.png");
			}
			equipoService.addEquipo(equipoModel);
		}
		return "redirect:/equipos/listEquipos";
		
		
		
		
	}
	
	@GetMapping("/create")
	public ModelAndView createEquipo(){
		ModelAndView mav=new ModelAndView(CREATE_VIEW);
		mav.addObject("equipo",new Equipo());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deleteEquipo(@RequestParam("nomeq") String nomeq) {
		equipoService.removeEquipo(nomeq);
		return "redirect:/equipos/listEquipos";
	}
	
	
	@GetMapping("/generarPDF")
	public String generarPDF(RedirectAttributes flash) {
		List<EquipoModel> list=equipoService.listAllEquipos();
		pdfequipo.PDFEquipo(list);
		flash.addFlashAttribute("success","PDF generado correctamente");
		return "redirect:/equipos/listEquipos";
		
	}
}
