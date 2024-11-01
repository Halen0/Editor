package editor;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Fuentes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextPane area;
	private JPanel panel = new JPanel();
	private JLabel nombreFuente;
	private JLabel estiloFuente;
	private JLabel tamanoFuente;
	private String[] nombreCombo;
	private String[] estiloCombo;
	private Integer[] tamanoCombo;
	private JComboBox<String> nombre;
	private JComboBox<String> estilo;
	private JComboBox<Integer> tamano;
	private JButton aceptar;

	public Fuentes(JTextPane area) {
		this.area = area;
		this.nombreFuente = new JLabel("Nombre de Fuente:");
		this.estiloFuente = new JLabel("Estilo de Fuente:");
		this.tamanoFuente = new JLabel("Tamaño de Fuente:");
		this.nombreCombo = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		this.estiloCombo = new String[] { "Normal", "Negrita", "Cursiva", "Negrita-Cursiva" };
		this.tamanoCombo = new Integer[] { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		this.nombre = new JComboBox<String>(nombreCombo);
		this.estilo = new JComboBox<String>(estiloCombo);
		this.tamano = new JComboBox<Integer>(tamanoCombo);
		this.aceptar = new JButton("Aceptar");
		this.configurar();
	}

	private void configurar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Fuente");
		setSize(300, 200);
		setLocationRelativeTo(null);
		add(panel);

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(4, 2, 10, 10));
		panel.setVisible(true);

		panel.add(nombreFuente);
		panel.add(nombre);
		panel.add(estiloFuente);
		panel.add(estilo);
		panel.add(tamanoFuente);
		panel.add(tamano);
		panel.add(aceptar);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font(nombre.getSelectedItem().toString(), estilo.getSelectedIndex(),
						Integer.parseInt(tamano.getSelectedItem().toString())));
				dispose();
			}
		});
	}
}
