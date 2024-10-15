import java.util.Scanner;
import java.util.ArrayList;

public class JuegoAhorcado {
    private Palabra palabra;
    private int intentosMaximos;
    private ArrayList<Character> letrasFallidas;

    public JuegoAhorcado(Palabra palabra, int intentos) {
        this.palabra = palabra;
        this.intentosMaximos = intentos;
        this.letrasFallidas = new ArrayList<>();
    }

    public JuegoAhorcado(Palabra palabra) {
        this(palabra, 6);
    }

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
