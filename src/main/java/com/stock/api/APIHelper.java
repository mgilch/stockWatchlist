package com.stock.api;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.Name;
import java.net.MalformedURLException;
import java.net.URL;

public final class APIHelper {
    public static String API_KEY = System.getenv("API_KEY");
    public static URL ALPHA_VANTAGE_URL;
    public String name;

    static {
        try {
            ALPHA_VANTAGE_URL = new URL("https://www.alphavantage.co/query");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to resolve API endpoint");
        }
    }

    private APIHelper(String name) {
        this.name = name;
    }

    /**
     * @param ticker
     * @return the full name of the stock or null if the connection fails
     */
    /*public static <ObjectMapper> String getFullName(Ticker ticker) {
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
    }*/
    public String returnName() {
        return name;
    }
}
