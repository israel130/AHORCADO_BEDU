import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class PalabraArchivo extends Palabra {

    public PalabraArchivo(String palabra) {
        super(palabra);
    }

    public PalabraArchivo() throws IOException {
        super(cargarPalabraDeArchivo());
    }

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
