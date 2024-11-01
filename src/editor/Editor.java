package editor;

public class Editor {

	private static String titulo = "Editor";
	private static int ancho = 800;
	private static int alto = 500;

	Ventana ventana;

	public static void main(String[] args) {
		new Ventana(titulo, ancho, alto);
	}

}
