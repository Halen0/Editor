package editor;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private int ancho;
	private int alto;
	private Lamina lamina;

	public Ventana(final String titulo, final int ancho, final int alto) {
		this.lamina = new Lamina();
		this.titulo = titulo;
		this.ancho = ancho;
		this.alto = alto;
		this.configurar();
	}

	private void configurar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(titulo);
		setPreferredSize(new Dimension(ancho, alto));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		add(lamina);
	}
}
