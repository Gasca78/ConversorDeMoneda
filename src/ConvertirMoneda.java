import java.util.Scanner;

public class ConvertirMoneda {
    static float nValor;
    static Scanner scanner = new Scanner(System.in);

    public static float convertirMoneda(float conversor) {
        System.out.println("Introduce el monto a convertir: ");
        String valor = scanner.nextLine();
        if (!esNumero(valor)) {
            do {
                System.out.println("No se ingresó un número, ingresa otro valor: ");
                valor = scanner.nextLine();
            } while (!esNumero(valor));
        }
        nValor = Float.parseFloat(valor);
        if (nValor <= 0) {
            do {
                System.out.println("No se puede ingresar un valor 0 o menor, ingresa otro valor: ");
                valor = scanner.nextLine();
                if (!esNumero(valor)) {
                    do {
                        System.out.println("No se ingresó un número, ingresa otro valor: ");
                        valor = scanner.nextLine();
                    } while (!esNumero(valor));
                }
            } while (!esNumero(valor));
            nValor = Float.parseFloat(valor);
        }
        return nValor * conversor;
    }

    // Función para identificar si el valor introducido es o no un número
    public static boolean esNumero(String text) {
        float v;
        try {
            v=Float.parseFloat(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
