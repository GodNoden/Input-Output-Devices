package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.RepaintManager;
import javax.swing.Timer;
import javax.swing.JLabel;

//VENTANA PRINCIPAL

public class DeviceManager extends JFrame {

	private JPanel contentPane;
	private JButton AddDevice;
	public static JTable table;

	public static void AddRowTable(String[] objects) {
		DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

		tblModel.addRow(objects);

	}

	// FUNCION PARA EVAULAR SI LA TABLA ESTÁ VACIA
	public static boolean isEmpty(JTable jTable) {
		if (jTable != null && jTable.getModel() != null) {
			return jTable.getModel().getRowCount() <= 0 ? true : false;
		}
		return false;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeviceManager frame = new DeviceManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	// CREACION DEL FRAME
	public DeviceManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnDisable = new JButton("Disable");
		JButton btnEnable = new JButton("Enable");
		JButton btnDesconectar = new JButton("Disconnect");
		btnDesconectar.setEnabled(false);
		btnDisable.setEnabled(false);
		btnEnable.setEnabled(false);

		// BOTON AÑADIR DISPOSITVO
		// INVOCA A LA VENTANA OPCION DE DISPOSITIVO PARA ELEGIR
		AddDevice = new JButton("Add device");
		AddDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DeviceOption dopt = new DeviceOption();
				dopt.setVisible(true);
				dopt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				btnDesconectar.setEnabled(true);
				btnDisable.setEnabled(true);
				btnEnable.setEnabled(true);
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		// BOTON DE DESCONECTAR DISPOSITIVO
		// SELECCION DEL DISPOSITIVO CON EL RATÓN, Y POSTERIORMENTE SU ELIMINACIÓN DE LA
		// TABLA
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

				int selectedRowIndex = table.getSelectedRow();
				try {
					tblModel.setValueAt("DISCONECTING...", selectedRowIndex, 1);
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tblModel.removeRow(selectedRowIndex);

			}
		});

		// BOTON DE DISHABILITAR DISPOSITIVO SELECCIONADO, CAMBIANDO SU ESTADO ESCRITO A
		// "DISABLED"
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

				int selectedRowIndex = table.getSelectedRow();

				tblModel.setValueAt("DISABLED", selectedRowIndex, 1);

			}
		});

		// BOTON DE HABILITAR DISPOSITIVO SELECCIONADO, CAMBIANDO SU ESTADO ESCRITO A
		// "ACTIVE"
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

				int selectedRowIndex = table.getSelectedRow();

				tblModel.setValueAt("ACTIVE", selectedRowIndex, 1);

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING, false)
						.addComponent(AddDevice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDesconectar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(btnDisable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnEnable))
				.addGap(8)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(AddDevice).addGap(18).addComponent(btnDisable).addGap(18)
										.addComponent(btnDesconectar).addGap(18).addComponent(btnEnable))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(23, Short.MAX_VALUE)));

		// CREACION DE LA TABLA Y DE LAS ETIQUETAS ESCRITAS EN SU PARTE SUPERIOR ADEMÁS
		// DE ASIGNAR A SUS CELDAS LA CUALIDAD DE NO-EDITABLES
		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Dispositivo", "Estado", "kBs Usados" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
