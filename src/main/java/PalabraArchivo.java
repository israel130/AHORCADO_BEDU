import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class PalabraArchivo extends Palabra {

    public PalabraArchivo(String palabra) {
        super(palabra);
    }

    /**
     * Esta clase extiende la clase Palabra y está diseñada para cargar palabras de un archivo de texto.
     * @throws IOException
     */
    public PalabraArchivo() throws IOException {
        super(cargarPalabraDeArchivo());
    }

    /**
     * Muestra la palabra oculta con guiones bajos _ para las letras que aún no han sido adivinadas y muestra las letras que ya se han acertado.
     */
    @Override
    public void mostrarPalabra() {
        for (char letra : palabraOculta.toCharArray()) {
            if (letrasAdivinadas.contains(letra)) {
                System.out.print(letra + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    /**
     * Este método lee un archivo llamado "Palabras.txt" que contiene una lista de palabras.
     * @return
     * @throws IOException
     */
    public static String cargarPalabraDeArchivo() throws IOException {
        ArrayList<String> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/JAVA/PROYECTO/src/main/resources/Palabras.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Archivo no encontrado");
        }
        if (palabras.isEmpty()) {
            throw new IOException("El archivo está vacío");
        }
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }
}
