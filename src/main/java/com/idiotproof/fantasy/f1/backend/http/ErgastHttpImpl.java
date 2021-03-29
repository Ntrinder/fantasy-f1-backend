package com.idiotproof.fantasy.f1.backend.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.models.Constructor;
import com.idiotproof.fantasy.f1.backend.models.Driver;
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
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class ErgastHttpImpl implements ErgastHttp {

    public static Logger LOG = LoggerFactory.getLogger(ErgastHttpImpl.class);

    private final static String API_URL = "http://ergast.com/api/f1";

    private static HttpRequest request;

    private static HttpResponse<String> response;


    public List<Driver> getDriversFromApi(boolean asJson) {

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

        JsonNode jsonNode;
        List<Driver> drivers = null;
        ObjectMapper mapper = new ObjectMapper();

        try {

            jsonNode = mapper.readTree(response.body()).at("/MRData/DriverTable/Drivers");
            drivers = mapper.convertValue(jsonNode, new TypeReference<List<Driver>>() {});

        } catch (JsonProcessingException e) {
            LOG.error("Error when converting response to Json: " + e);
        }

        return drivers;
    }

    @Override
    public List<Constructor> getConstructorsFromApi(boolean asJson) {

        String constructorUrl = API_URL + "/2020/constructors";
        if (asJson) constructorUrl += ".json";

        try {

            request = HttpRequest.newBuilder()
                    .uri(new URI(constructorUrl))
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();

        } catch (URISyntaxException e) {
            LOG.error("Error when creating HttpRequest: " + e);
            return null;
        }

        try {

            LOG.info("Getting constructor data from url: " + constructorUrl);
            response = HttpClient.newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            LOG.error("Error when sending HttpRequest: " + e);
            return null;
        }

        JsonNode jsonNode;
        List<Constructor> constructors = null;
        ObjectMapper mapper = new ObjectMapper();

        try {

            jsonNode = mapper.readTree(response.body()).at("/MRData/ConstructorTable/Constructors");
            constructors = mapper.convertValue(jsonNode, new TypeReference<List<Constructor>>() {});

        } catch (JsonProcessingException e) {
            LOG.error("Error when converting response to Json: " + e);
        }

        return constructors;
    }

    @Override
    public List<Circuit> getCircuitsFromApi(boolean asJson) {

        String circuitUrl = API_URL + "/2020/circuits";
        if (asJson) circuitUrl += ".json";

        try {

            request = HttpRequest.newBuilder()
                    .uri(new URI(circuitUrl))
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();

        } catch (URISyntaxException e) {
            LOG.error("Error when creating HttpRequest: " + e);
            return null;
        }

        try {

            LOG.info("Getting circuit data from url: " + circuitUrl);
            response = HttpClient.newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            LOG.error("Error when sending HttpRequest: " + e);
            return null;
        }

        JsonNode jsonNode;
        List<Circuit> circuits = null;
        ObjectMapper mapper = new ObjectMapper();

        try {

            jsonNode = mapper.readTree(response.body()).at("/MRData/CircuitTable/Circuits");
            circuits = mapper.convertValue(jsonNode, new TypeReference<List<Circuit>>() {});

        } catch (JsonProcessingException e) {
            LOG.error("Error when converting response to Json: " + e);
        }

        return circuits;
    }

}
