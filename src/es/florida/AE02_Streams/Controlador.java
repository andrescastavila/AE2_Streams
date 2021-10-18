package es.florida.AE02_Streams;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String ficheroOriginal, ficheroModificado;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo=modelo;
		this.vista = vista;
		control();
	}
	
	public void control() {
		ficheroOriginal = modelo.getFichero_Original();
		ficheroModificado = modelo.getFichero_Modificado();
		
		mostrarFichero(ficheroOriginal,1);
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String buscarTexto = vista.getTextFieldBuscar().getText();
				modelo.buscarPalabras(buscarTexto);
			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		actionListenerReemplazar =new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String nuevaPalabra = vista.getTextFieldReemplazar().getText();
				String palabraBorrada = vista.getTextFieldBuscar().getText();
				modelo.reemplazarPalabras(nuevaPalabra, palabraBorrada);
				mostrarFichero(ficheroModificado,2);
			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	}
	
	
	
	
	private void mostrarFichero(String fichero, int numeroTextArea) {
		ArrayList<String> arrayLineas = modelo.leerFichero(fichero);
		for(String linea : arrayLineas) {
			if(numeroTextArea ==1) {
				vista.getTextAreaOriginal().append(linea+"\n");
			}else {
				vista.getTextAreaModificado().append(linea+"\n");
			}
		}
	}
}
