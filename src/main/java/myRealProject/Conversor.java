package myRealProject;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Conversor {

    private static final String API_KEY = "626221181e922a89b14ecef9";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static double converte(String moedaOrigem, String moedaDestino, double valor) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        String url = API_URL + API_KEY + "/latest/" + moedaOrigem;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String responseBody = response.body();

        Gson gson = new Gson();
        Moeda moeda = gson.fromJson(responseBody, Moeda.class);
        Map<String, Double> taxas = moeda.getConversion_rates();

        double taxa = taxas.get(moedaDestino);

        return taxa * valor;
    }
}
