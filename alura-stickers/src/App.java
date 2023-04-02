import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        
        // PASSO 01) CONEXÃO COM A API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        
        // PASSO 02) RECEBE E TRATA DADOS DE RETORNO DA API
        String body = response.body();

        System.out.println(body);

        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // System.out.println("Veja a lista de filmes: >>>> ");
        System.out.println("tamanho da lista: "+listaDeFilmes.size());

        // PASSO 03) MANIPULAR DADOS
        
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            
        }
    }
}
