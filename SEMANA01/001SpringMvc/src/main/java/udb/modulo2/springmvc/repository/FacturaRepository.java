package udb.modulo2.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import udb.modulo2.springmvc.model.Factura;
import udb.modulo2.springmvc.model.FacturaConIva;
import udb.modulo2.springmvc.model.FacturaSinIva;
@Component
public class FacturaRepository {
	public List<Factura> listaFacturas(){
		List<Factura> lstFacturas = new ArrayList<Factura>();
		lstFacturas.add(new FacturaSinIva(1,"Mouse",20.90));
		lstFacturas.add(new FacturaConIva(2,"Computador",2000.10));
		lstFacturas.add(new FacturaSinIva(3,"Mueble",500.10));
		lstFacturas.add(new FacturaConIva(4,"Monitor",100.10));
		lstFacturas.add(new FacturaSinIva(5,"Silla",200.10));
		return lstFacturas;
	}
}
