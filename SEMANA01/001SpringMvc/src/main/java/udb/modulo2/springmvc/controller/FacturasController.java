package udb.modulo2.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import udb.modulo2.springmvc.model.Factura;
import udb.modulo2.springmvc.service.Servicio;

@Controller
public class FacturasController {
	
	private Servicio servicioFactura;
	
	@Autowired
	public FacturasController(Servicio servicioFactura) {
		this.servicioFactura=servicioFactura;
	}
	
	@RequestMapping("/facturas")
	public String listaFacturas(Model model) {
		List<Factura> lstFacturas=servicioFactura.listaFacturas();
		model.addAttribute("facturas",lstFacturas);
 		return "listaFacturas";
	}
}
