import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String name = scanner.nextLine();
        String intro = """
                Bienvenido %s al 'Conversor de Moneda'
                Deberás de ingresar primero la moneda que quieres convertir
                y en segundo lugar la moneda a la que quieres cambiar.
                Nota: El nombre a ingresar debe ser la abreviación""".formatted(name);
        String option = """
                Contamos con estas monedas:
                    Nombre            Abreviación 
                Peso mexicano .......... (MXN)
                Dolár estadounidense ... (USD)
                Peso argentino ......... (ARS)
                Peso colombiano ........ (COP) 
                Real brasileño ......... (BRL)
                Euro ................... (EUR)""";
        System.out.println("------------------------------------------------------------------");
        System.out.println(intro);
        System.out.println("***********************************");
        System.out.println(option);
        System.out.println("***********************************");
        System.out.println("Para cerrar el conversor solo escribe 'salir'");
        System.out.println("------------------------------------------------------------------");
        while (true) {
            String busqueda = ExchangeRateApi.obtenerMoneda();
            if (busqueda.equals("salir")) {
                break;
            }
            try {
                HttpResponse<String> response = LlamadaHttp.conexion(busqueda);

                Conversion miConversion = Json.jsonToGson(response);
                float moneda = ConvertirMoneda.convertirMoneda(miConversion.getConversion());
                System.out.println("El monto de $" + ConvertirMoneda.nValor + " [" + ExchangeRateApi.moneda1 +
                        "]" + " equivale a => $" + moneda + " [" + ExchangeRateApi.moneda2 + "]");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección"); }
        }
        System.out.println("Salió del Conversor de Moneda, ¡muchas gracias por utilizar nuestros servicios!");
    }
}
