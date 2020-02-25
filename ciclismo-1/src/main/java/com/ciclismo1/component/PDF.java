package com.ciclismo1.component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ciclismo1.model.EquipoModel;
import com.ciclismo1.model.CiclistaModel;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PDF {
	public void PDFEquipo(List<EquipoModel> lista) {
		Document doc = null;
		
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\equipo.pdf"));
			Table table = new Table(1);
			table.setWidth(150);
			Cell celda = new Cell("Equipos");
			table.addCell(celda);
			
			table.addCell(new Phrase("Nombre equipo"));
			table.addCell(new Phrase("Director equipo"));
			table.endHeaders();
			
			for(EquipoModel em: lista) {
				table.addCell(em.getNomeq());
				table.addCell(em.getDirector());
			}
			doc.open();
			doc.add(table);
			doc.close();
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void PDFCiclista(List<CiclistaModel> lista) {
		Document doc = null;
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\ciclista.pdf"));
			Table table = new Table(1);
			table.setWidth(150);
			Cell celda = new Cell("Ciclistas");
			celda.setHeader(true);
			table.addCell(celda);
			
			 table.addCell(new Phrase("Nombre del ciclista"));
	         table.addCell(new Phrase("Edad del ciclista")); 
	         table.addCell(new Phrase("Dorsal del ciclista"));
	         table.addCell(new Phrase("Nombre del equipo"));
	         table.endHeaders();
	         for(CiclistaModel ciclistaModel : lista) {
	                table.addCell(ciclistaModel.getNombre());
	                table.addCell(Integer. toString(ciclistaModel.getEdad()));
	                table.addCell(Integer. toString(ciclistaModel.getDorsal()));
	                table.addCell(ciclistaModel.getEquipo().getNomeq());
	            }
	            doc.open();
	            doc.add(table);
	            doc.close();
	        } catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
}
