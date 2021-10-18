package es.florida.AE02_Streams;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo,vista);

	}

}
