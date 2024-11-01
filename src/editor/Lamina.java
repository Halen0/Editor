package editor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;

public class Lamina extends JPanel {

	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenu ediccion;
	private JMenu formato;
	private JSeparator separador1;
	private JSeparator separador2;
	private JSeparator separador3;
	private UndoManager undo;
	private JTextPane area;
	private JScrollPane scroll;
	private Funciones funciones;

	public Lamina() {
		setLayout(new BorderLayout());
		barra = new JMenuBar();
		archivo = new JMenu("Archivo");
		ediccion = new JMenu("Ediccion");
		formato = new JMenu("Formato");
		separador1 = new JSeparator();
		separador2 = new JSeparator();
		separador3 = new JSeparator();
		undo = new UndoManager();
		area = new JTextPane();
		scroll = new JScrollPane(area);
		funciones = new Funciones(area, undo);
		menuBar(this);
		textArea(this);
	}

	private void menuBar(final JPanel panel) {
		archivo.add(menuItem("Nuevo"));
		archivo.add(menuItem("Abrir"));
		archivo.add(menuItem("Guardar"));
		archivo.add(menuItem("Guardar Como"));
		archivo.add(separador1);
		archivo.add(menuItem("Salir"));
		ediccion.add(menuItem("Deshacer"));
		ediccion.add(menuItem("Rehacer"));
		ediccion.add(separador2);
		ediccion.add(menuItem("Cortar"));
		ediccion.add(menuItem("Copiar"));
		ediccion.add(menuItem("Pegar"));
		ediccion.add(menuItem("Eliminar"));
		ediccion.add(separador3);
		ediccion.add(menuItem("Seleccionar Todo"));
		formato.add(menuItem("Fuente"));
		barra.add(archivo);
		barra.add(ediccion);
		barra.add(formato);
		panel.add(barra, BorderLayout.NORTH);
	}

	private JMenuItem menuItem(String nombre) {
		JMenuItem menuItem = new JMenuItem(nombre);
		atajosTeclado(menuItem);
		eventos(menuItem);
		return menuItem;
	}

	private void atajosTeclado(JMenuItem item) {
		switch(item.getText()) {
		case "Nuevo":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Abrir":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Guardar":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Guardar Como":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
			break;
		case "Deshacer":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Rehacer":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Cortar":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Copiar":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Pegar":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_DOWN_MASK));
			break;
		case "Seleccionar Todo":
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_DOWN_MASK));
			break;
		}
	}
	
	private void eventos(JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (item.getText()) {
				case "Nuevo":
					funciones.nuevo();
					break;
				case "Abrir":
					funciones.abrir();
					break;
				case "Guardar":
					funciones.guardar();
					break;
				case "Guardar Como":
					funciones.guardarComo();
					break;
				case "Salir":
					funciones.salir();
					break;
				case "Deshacer":
					funciones.deshacer();
					break;
				case "Rehacer":
					funciones.rehacer();
					break;
				case "Cortar":
					funciones.cortar();
					break;
				case "Copiar":
					funciones.copiar();
					break;
				case "Pegar":
					funciones.pegar();
					break;
				case "Eliminar":
					funciones.eliminar();
					break;
				case "Seleccionar Todo":
					funciones.seleccionarTodo();
					break;
				case "Fuente":
					funciones.fuente();
					break;
				}
			}
		});
	}

	private void textArea(final JPanel panel) {
		area.setFont(new Font("Arial", Font.PLAIN, 14));
		area.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		area.getDocument().addUndoableEditListener(undo);
		panel.add(scroll, BorderLayout.CENTER);
	}
}
