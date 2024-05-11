import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// Método para llamar a la API ExchangeRateApi
public class LlamadaHttp {
    public static HttpResponse<String> conexion(String busqueda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busqueda))
                .build();
        return client
                .send(request, HttpResponse.BodyHandlers.ofString());
    }
}
