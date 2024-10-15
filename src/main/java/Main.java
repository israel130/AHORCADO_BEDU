import java.io.IOException;

public class Main {
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
