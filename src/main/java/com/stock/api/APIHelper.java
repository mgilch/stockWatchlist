package com.stock.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.util.datatypes.Ticker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public final class APIHelper {
    public static String API_KEY = System.getenv("API_KEY");
    public static URL ALPHA_VANTAGE_URL;

    static {
        try {
            ALPHA_VANTAGE_URL = new URL("https://www.alphavantage.co/query");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to resolve API endpoint");
        }
    }

    private APIHelper() {
    }

    /**
     * @param ticker
     * @return the full name of the stock or null if the connection fails
     */
    public static String getFullName(Ticker ticker) {
        String name;
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + ticker + "&apikey=" + API_KEY))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new ObjectMapper();
        TickerSearchResponse data = null;
        try {
            data = mapper.readValue(response.body(), TickerSearchResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        name = data.bestMatches.get(0).name;

        System.out.println(name);

        return name;
    }
}
