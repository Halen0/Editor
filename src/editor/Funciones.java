package editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.undo.UndoManager;

public class Funciones {

	private JFileChooser fileChooser;
	private JTextPane area;
	private UndoManager undo;
	private File file;

	public Funciones(JTextPane area, final UndoManager undo) {
		this.fileChooser = new JFileChooser();
		this.area = area;
		this.undo = undo;
		this.file = null;
	}

	public void nuevo() {
		area.setText("");
		file = null;
	}

	public void abrir() {
		if (fileChooser.showOpenDialog(area) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				area.read(reader, null);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void guardar() {
		file = fileChooser.getSelectedFile();
		if (file != null) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				area.write(writer);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} else {
			guardarComo();
		}
	}

	public void guardarComo() {
		if (fileChooser.showSaveDialog(area) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				area.write(writer);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void salir() {
		System.exit(0);
	}

	public void deshacer() {
		if (undo.canUndo()) {
			undo.undo();
		}
	}

	public void rehacer() {
		if (undo.canRedo()) {
			undo.redo();
		}
	}

	public void cortar() {
		area.cut();
	}

	public void copiar() {
		area.copy();
	}

	public void pegar() {
		area.paste();
	}

	public void eliminar() {
		area.replaceSelection("");
	}

	public void seleccionarTodo() {
		area.selectAll();
	}

	public void fuente() {
		Fuentes fuente = new Fuentes(area);
		fuente.setVisible(true);
	}

}
