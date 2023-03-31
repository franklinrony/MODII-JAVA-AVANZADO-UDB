package udb.modulo2.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import udb.modulo2.springmvc.model.Factura;
import udb.modulo2.springmvc.repository.FacturaRepository;

@Component
public class Servicio {	
	
	@Autowired
	private FacturaRepository facturaRepository;	
			
	public List<Factura> listaFacturas() {
		return facturaRepository.listaFacturas();
	}
	
}
