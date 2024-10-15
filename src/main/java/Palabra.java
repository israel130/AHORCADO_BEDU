import java.util.ArrayList;

public abstract class Palabra {
    protected String palabraOculta;
    protected ArrayList<Character> letrasAdivinadas;

    public Palabra(String palabra) {
        this.palabraOculta = palabra;
        this.letrasAdivinadas = new ArrayList<>();
    }

    public abstract void mostrarPalabra();

    public boolean adivinarLetra(char letra) {
        boolean encontrada = false;
        if (palabraOculta.contains(Character.toString(letra))) {
            letrasAdivinadas.add(letra);
            encontrada = true;
        }
        return encontrada;
    }

    public boolean palabraCompleta() {
        for (char letra : palabraOculta.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }
}