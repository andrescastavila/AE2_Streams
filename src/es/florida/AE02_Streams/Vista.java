package es.florida.AE02_Streams;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Vista {

	private JFrame frame;
	private JTextField textField_Buscar;
	private JTextField textField_Reemplazar;
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JTextArea textArea_Original;
	private JTextArea textArea_Modificado;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista window = new Vista();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_Buscar = new JTextField();
		textField_Buscar.setBounds(10, 198, 146, 30);
		frame.getContentPane().add(textField_Buscar);
		textField_Buscar.setColumns(10);
		
		textField_Reemplazar = new JTextField();
		textField_Reemplazar.setBounds(294, 198, 146, 30);
		frame.getContentPane().add(textField_Reemplazar);
		textField_Reemplazar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(166, 202, 85, 21);
		frame.getContentPane().add(btnBuscar);
		
		btnReemplazar = new JButton("Remplazar");
		btnReemplazar.setBounds(450, 202, 85, 21);
		frame.getContentPane().add(btnReemplazar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 287, 594, 107);
		frame.getContentPane().add(scrollPane);
		
		textArea_Modificado = new JTextArea();
		scrollPane.setViewportView(textArea_Modificado);
		scrollPane.getViewport().setView(textArea_Modificado);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 594, 152);
		frame.getContentPane().add(scrollPane_1);
		
		textArea_Original = new JTextArea();
		scrollPane_1.setViewportView(textArea_Original);
		
		frame.setVisible(true);
	}
	
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	public JButton getBtnReemplazar() {
		return btnReemplazar;
	}
	
	public JTextField getTextFieldBuscar() {
		return textField_Buscar;
	}
	
	public JTextField getTextFieldReemplazar() {
		return textField_Reemplazar;
	}
	
	public JTextArea getTextAreaOriginal() {
		return textArea_Original;
	}
	
	public JTextArea getTextAreaModificado() {
		return textArea_Modificado;
	}
}
