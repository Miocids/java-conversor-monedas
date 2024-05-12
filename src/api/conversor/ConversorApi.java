package api.conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApi {
    public ConversorRecord getConversionBase(String baseCurrency, String targetCurrency){
        try {
            String token = "b3cf7dadf7626f758ca4eb45";
            URI url = URI.create("https://v6.exchangerate-api.com/v6/"+token+"/pair/"+baseCurrency+"/"+targetCurrency);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorRecord.class);

        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
