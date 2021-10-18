package es.florida.AE02_Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modelo {

	private String fichero_original;
	private String fichero_modificado;
	
	public Modelo() {
		fichero_original = "AE02_T1_2_Streams_Groucho.txt";
		fichero_modificado = "AE02_T1_2_Streams_Groucho_2.txt";
	}
	
	public ArrayList<String> leerFichero(String fichero){
		ArrayList<String> leerFichero = new ArrayList<String>();
		File f = new File(fichero);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				leerFichero.add(linea);
				linea=br.readLine();
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return leerFichero;
	}
	
	
	public ArrayList<String> buscarPalabras(String fichero){
		ArrayList<String> buscarPalabras = new ArrayList<String>();
		File f = new File(fichero);
		Map<String, Integer> palabras= new HashMap();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while((linea =br.readLine()) != null) {
				for(String palabra : linea.replace(",", "").replace(".", "").replace(";", "").replace(":", "").split("")) {
					palabras.put(palabra, palabras.containsKey(palabra) ? palabras.get(palabra)+1 :1);
				}
			}
			String [] letra_palabras = new String[palabras.size()];
			int[]numero_palabras = new int[palabras.size()];
			palabras.keySet().toArray(letra_palabras);
			for(int i = 0; i<letra_palabras.length;i++) {
				System.out.println(numero_palabras[i]+""+letra_palabras[i]);
			}
			System.out.println("La palabra "+letra_palabras[0] + "ocurrio "+numero_palabras[0]);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return buscarPalabras;
	}
	
	public void reemplazarPalabras (String palabraNueva, String palabraBorrada) {
		File f1 = new File(fichero_original);
		File f2 = new File(fichero_modificado);
		try {
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine();
			while(linea != null) {
				bw.write(linea);
				bw.newLine();
				linea=br.readLine();
				
			}
			bw.write(palabraBorrada.replaceAll(palabraBorrada, linea));
			bw.write(palabraNueva);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public String getFichero_Modificado() {
		return fichero_modificado;
	}
	
	public String getFichero_Original() {
		return fichero_original;
	}
	
	
}
