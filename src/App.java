import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * Ao usar var, estamos usando a inferência de tipos locais...
 */

public class App {

    public static void main(String[] args) throws Exception {
        // acessar url
        var url = "https://viacep.com.br/ws/01001000/json/";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).build();

        // pegar texto (JSON)
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        // imprimir o JSON
        System.out.println(json);
    }
}
