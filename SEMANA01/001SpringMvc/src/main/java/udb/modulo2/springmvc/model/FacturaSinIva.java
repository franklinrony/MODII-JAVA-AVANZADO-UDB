package udb.modulo2.springmvc.model;

public class FacturaSinIva extends Factura {

	public FacturaSinIva() {
		// TODO Auto-generated constructor stub
	}

	public FacturaSinIva(Integer numero, String concepto, Double importe) {
		super(numero, concepto, importe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getImporteTotal() {
		// TODO Auto-generated method stub
		return getImporte();
	}

	@Override
	public String toString() {
		return String.format("********\nNumero: %d\nConcepto: %s\nImporte: %.2f\nTotal: %.2f\n", 
				getNumero(),getConcepto(),getImporte(),getImporteTotal());
	}

}
