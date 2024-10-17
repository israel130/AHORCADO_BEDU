import java.util.Scanner;
import java.util.ArrayList;

public class JuegoAhorcado {
    private Palabra palabra;
    private int intentosMaximos;
    private ArrayList<Character> letrasFallidas;

    /**
     * inicializa el juego con una palabra y un número de intentos.
     * @param palabra
     * @param intentos
     */
    public JuegoAhorcado(Palabra palabra, int intentos) {
        this.palabra = palabra;
        this.intentosMaximos = intentos;
        this.letrasFallidas = new ArrayList<>();
    }

    public JuegoAhorcado(Palabra palabra) {
        this(palabra, 6);
    }

    /**
     * El método que inicia y controla el ciclo del juego
     * Muestra cuántos intentos le quedan al jugador.
     * Pide al jugador que ingrese una letra y revisa si esa letra está en la palabra.
     * Si el jugador adivina correctamente, la letra se muestra en su posición.
     * Si el jugador se equivoca, se le resta un intento.
     * Si adivina toda la palabra, el juego termina con un mensaje de victoria. Si se le acaban los intentos, el jugador pierde.
     */
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int intentosRestantes = intentosMaximos;

        while (intentosRestantes > 0 && !palabra.palabraCompleta()) {
            System.out.println("\nIntentos restantes: " + intentosRestantes);
            mostrarAhorcado(intentosMaximos - intentosRestantes);
            palabra.mostrarPalabra();
            System.out.println("Letras fallidas: " + letrasFallidas);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            if (!palabra.adivinarLetra(letra)) {
                letrasFallidas.add(letra);
                intentosRestantes--;
            }

            if (palabra.palabraCompleta()) {
                System.out.println("¡Felicidades! Adivinaste la palabra.");
                palabra.mostrarPalabra();
            }
        }

        if (intentosRestantes == 0) {
            System.out.println("¡Has perdido! La palabra era: " + palabra.palabraOculta);
            mostrarAhorcado(intentosMaximos);
        }
    }

    /**
     * Muestra una figura del "ahorcado" según la cantidad de errores. Entre más errores, más completo estará el dibujo del ahorcado.
     * @param errores
     *
     */
    private void mostrarAhorcado(int errores) {
        switch (errores) {
            case 0:
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                break;
            case 1:
                System.out.println("     ");
                System.out.println("  O  ");
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                System.out.println("     ");
                break;
            case 2:
                System.out.println("     ");
                System.out.println("  O  ");
                System.out.println("  |  ");
                System.out.println("  |  ");
                System.out.println("     ");
                System.out.println("     ");
                break;
            case 3:
                System.out.println("     ");
                System.out.println("  O  ");
                System.out.println("  |  ");
                System.out.println("  |  ");
                System.out.println(" /   ");
                System.out.println("     ");
                break;
            case 4:
                System.out.println("     ");
                System.out.println("  O  ");
                System.out.println("  |  ");
                System.out.println("  |  ");
                System.out.println(" / \\ ");
                System.out.println("     ");
                break;
            case 5:
                System.out.println("     ");
                System.out.println("  O  ");
                System.out.println("--|  ");
                System.out.println("  |  ");
                System.out.println(" / \\ ");
                System.out.println("     ");
                break;
            case 6:
            default:
                System.out.println("  X  ");
                System.out.println("  O  ");
                System.out.println("--|--");
                System.out.println("  |  ");
                System.out.println(" / \\ ");
                System.out.println("     ");
                break;
        }
    }
}
