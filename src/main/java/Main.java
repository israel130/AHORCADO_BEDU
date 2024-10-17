import java.io.IOException;

public class Main {
    /**
     * cargar una palabra de un archivo usando la clase PalabraArchivo
     * Crea un objeto de la clase JuegoAhorcado con esa palabra y un número de intentos
     * @param args
     */
    public static void main(String[] args) {
        try {
            Palabra palabra = new PalabraArchivo();
            JuegoAhorcado juego = new JuegoAhorcado(palabra, 6);
            juego.iniciar();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}
