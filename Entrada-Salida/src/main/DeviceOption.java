package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//VENTANA DE OPCIONES DE DISPOSITIVOS 

public class DeviceOption extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					DeviceOption frame = new DeviceOption();
					frame.setVisible(true);
				
	}});}

	/**
	 * Create the frame.
	 */
	
	 DeviceOption() {
		setBounds(100, 100, 317, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//BOTON OPCION USB QUE INTRODUCE EN LA TABLA LOS ELEMENTOS ESTIPULADOS DENTRO DE SU LISTENER
		JButton btnUSB = new JButton("USB");
		btnUSB.setBounds(24, 49, 124, 23);
		btnUSB.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				DeviceManager.AddRowTable(new String[]  {"USB ", "ACTIVE", "512"});
				dispose();
				
			}
		});

		//BOTON OPCION KEYBOARD QUE INTRODUCE EN LA TABLA LOS ELEMENTOS ESTIPULADOS DENTRO DE SU LISTENER
		JButton btnKeyboard = new JButton("New Keyboard");
		btnKeyboard.setBounds(24, 112, 124, 23);
		btnKeyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeviceManager.AddRowTable(new String[]  {"KeyBoard", "ACTIVE", "878"});
				dispose();
				
			}
		});

		//BOTON OPCION HEADPHONES QUE INTRODUCE EN LA TABLA LOS ELEMENTOS ESTIPULADOS DENTRO DE SU LISTENER
		JButton btnHeadphones = new JButton("Headphones");
		btnHeadphones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DeviceManager.AddRowTable(new String[]  {"HeadPhones", "ACTIVE", "712"});
				dispose();
				
			}
		});
		btnHeadphones.setBounds(24, 183, 124, 23);

		JButton btnMosue = new JButton("New Mouse");
		btnMosue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeviceManager.AddRowTable(new String[]  {"Mouse", "ACTIVE", "320"});
				dispose();
				
			}
		});
		btnMosue.setBounds(174, 49, 117, 23);

		//BOTON OPCION MONITOR QUE INTRODUCE EN LA TABLA LOS ELEMENTOS ESTIPULADOS DENTRO DE SU LISTENER
		JButton btnMonitor = new JButton("New Monitor");
		btnMonitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeviceManager.AddRowTable(new String[]  {"Monitor", "ACTIVE", "7978"});
				dispose();
				
			}
		});
		btnMonitor.setBounds(174, 112, 117, 23);

		//BOTON OPCION PRINTER QUE INTRODUCE EN LA TABLA LOS ELEMENTOS ESTIPULADOS DENTRO DE SU LISTENER
		JButton btnPrinter = new JButton("Printer");
		btnPrinter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DeviceManager.AddRowTable(new String[]  {"Printer", "ACTIVE", "3654"});
				dispose();
				
			}
		});
		btnPrinter.setBounds(174, 183, 117, 23);
		contentPane.setLayout(null);
		contentPane.add(btnUSB);
		contentPane.add(btnMosue);
		contentPane.add(btnKeyboard);
		contentPane.add(btnMonitor);
		contentPane.add(btnHeadphones);
		contentPane.add(btnPrinter);
	}

}
