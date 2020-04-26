package com.uca.capas.tarea3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tarea3Controller {

	@RequestMapping("/ingresar")
	public String index() {
		return "commons/index";
	}
	@RequestMapping("/parametros")
	ModelAndView parametros(@RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String fecha, @RequestParam String lugar,
			@RequestParam String instituto, @RequestParam String fijo,
			@RequestParam String movil) {
		int aux=0;
		
		List<String> lista = new ArrayList<>();
		
		ModelAndView mav = new ModelAndView();
		
		if(nombre.length()<1) {
			lista.add("El nombre debe tener 1 caracter minimo.");
			aux=1;
		}
		if(nombre.length()>25) {
			lista.add("El apellido debe tener 25 caracteres maximo.");
			aux=1;
		}
		if(apellido.length()<1) {
			lista.add("El apellido debe tener 1 caracter minimo.");
			aux=1;
		}
		if(apellido.length()>25) {
			lista.add("El apellido debe tener 25 caracteres maximo.");
			aux=1;
		}
		if(lugar.length()<1) {
			lista.add("El lugar de nacimiento debe tener 1 caracter minimo.");
			aux=1;
		}
		if(lugar.length()>25) {
			lista.add("El lugar de nacimiento debe tener 25 caracteres maximo.");
			aux=1;
		}
		if(instituto.length()<1) {
			lista.add("El instituto debe tener 1 caracter minimo.");
			aux=1;
		}
		if(instituto.length()>100) {
			lista.add("El instituto debe tener 100 caracteres maximo.");
			aux=1;
		}
		if(fijo.length() != 8) {
			lista.add("El numero fijo debe tener 8 digitos exactos.");
			aux=1;
		}
		if(movil.length() != 8) {
			lista.add("El numero fijo debe tener 8 digitos exactos.");
			aux=1;
		}
		if(fecha.isEmpty()) {
			lista.add("La fecha no puede quedar vacia");
			aux=1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1= sdf.parse("2003-01-01");
			Date date2= sdf.parse(fecha);
			if(date1.compareTo(date2)>0) {
				lista.add("La fecha no puede ser menor al 1 de enero de 2003.");
				aux=1;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aux != 0) {
			mav.addObject("errores", lista);
			mav.setViewName("commons/errores");
		}
		else {
			mav.setViewName("commons/correcto");
		}
		
		return mav;
	}
}
