import java.util.ArrayList;

public abstract class Palabra {
    protected String palabraOculta;
    protected ArrayList<Character> letrasAdivinadas;

    public Palabra(String palabra) {
        this.palabraOculta = palabra;
        this.letrasAdivinadas = new ArrayList<>();
    }

    public abstract void mostrarPalabra();

    /**
     * Verifica si una letra está en la palabra oculta.
     * Si está, la agrega a la lista de letras adivinadas y devuelve true.
     * Si no está, devuelve false.
     * @param letra
     * @return
     */
    public boolean adivinarLetra(char letra) {
        boolean encontrada = false;
        if (palabraOculta.contains(Character.toString(letra))) {
            letrasAdivinadas.add(letra);
            encontrada = true;
        }
        return encontrada;
    }

    /**
     * Revisa si el jugador ha adivinado todas las letras de la palabra.
     * Si todas las letras han sido adivinadas, devuelve true.
     * Si falta alguna letra, devuelve false.
     * @return
     */
    public boolean palabraCompleta() {
        for (char letra : palabraOculta.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }
}