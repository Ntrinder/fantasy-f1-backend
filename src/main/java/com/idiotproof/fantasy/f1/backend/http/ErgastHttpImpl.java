package com.idiotproof.fantasy.f1.backend.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class ErgastHttpImpl implements ErgastHttp {

    public static Logger LOG = LoggerFactory.getLogger(ErgastHttpImpl.class);

    private final static String API_URL = "http://ergast.com/api/f1/";


    public String getDriverData(boolean asJson) {

        HttpRequest request;
        HttpResponse<String> response;

        // todo: i think there is a /latest/drivers endpoint
        String driverUrl = API_URL + "/2020/drivers";
        if (asJson) driverUrl += ".json";

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(driverUrl))
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            LOG.error("Error when creating HttpRequest: " + e);
            return null;
        }

        try {
            LOG.info("Getting driver data from url: " + driverUrl);
            response = HttpClient.newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            LOG.error("Error when sending HttpRequest: " + e);
            return null;
        }

        return response.body();
    }

}
