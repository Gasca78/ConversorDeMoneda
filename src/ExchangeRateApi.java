import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// Clase para realizar generar la URI y buscar las monedas de cambio
public class ExchangeRateApi {
    static String moneda1;
    static String moneda2;
    // Método para obtener la URI de búsqueda
    public static String obtenerMoneda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la primer moneda: ");
        moneda1 =scanner.nextLine().toUpperCase();
        if (moneda1.equalsIgnoreCase("salir")) { // Si se pone salir desde el inicio, retornará "salir" de una vez
            return "salir";
        }
        System.out.println("Ingresa la segunda moneda: ");
        moneda2 =scanner.nextLine().toUpperCase();
        while (true) {
            if (valido(moneda1, moneda2)) { // Si se sigue retornando true, el bucle seguirá
                System.out.println("No coincidio tu moneda con la lista.");
                System.out.println("Ingresa otra primer moneda: ");
                moneda1 =scanner.nextLine().toUpperCase();
                System.out.println("Ingresa otra segunda moneda: ");
                moneda2 =scanner.nextLine().toUpperCase();
            } else {
                break;
            }
        }
        return "https://v6.exchangerate-api.com/v6/645636408e506a2f24b06383/pair/"+
                moneda1+"/"+moneda2;
    }

    // Función para validar que los valores ingresados sean correctos
    public static boolean valido(String s1, String s2) {
        String[] monedas = {"MXN", "USD", "ARS", "COP", "BRL", "EUR"};
        List<String> monedasLista = Arrays.asList(monedas);

        return !monedasLista.contains(s1) || !monedasLista.contains(s2);
    }
}
