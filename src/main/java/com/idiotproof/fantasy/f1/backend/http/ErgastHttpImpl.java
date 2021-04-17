package com.idiotproof.fantasy.f1.backend.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idiotproof.fantasy.f1.backend.models.*;
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

    // adding configs to ignore unknown fields from the json response
    private final static ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @Override
    public List<Driver> getDrivers(boolean asJson) {
        String driverUrl = API_URL + "/2020/drivers";
        if (asJson) driverUrl += ".json";
        buildRequest(driverUrl);
        sendRequest(driverUrl);
        return mapResponseToObject("/MRData/DriverTable/Drivers");
    }

    @Override
    public List<Constructor> getConstructors(boolean asJson) {
        String constructorUrl = API_URL + "/2020/constructors";
        if (asJson) constructorUrl += ".json";
        buildRequest(constructorUrl);
        sendRequest(constructorUrl);
        return mapResponseToObject("/MRData/ConstructorTable/Constructors");
    }

    @Override
    public List<Circuit> getCircuits(boolean asJson) {
        String circuitUrl = API_URL + "/2020/circuits";
        if (asJson) circuitUrl += ".json";
        buildRequest(circuitUrl);
        sendRequest(circuitUrl);
        return mapResponseToObject("/MRData/CircuitTable/Circuits");
    }

    // todo: url and path
    @Override
    public List<FastestLap> getFastestLaps(boolean asJson) {
        String circuitUrl = API_URL + "/2020/circuits";
        if (asJson) circuitUrl += ".json";
        buildRequest(circuitUrl);
        sendRequest(circuitUrl);
        return mapResponseToObject("/MRData/CircuitTable/Circuits");
    }

    // todo: url and path
    @Override
    public List<Race> getRaces(boolean asJson) {
        String circuitUrl = API_URL + "/2020/circuits";
        if (asJson) circuitUrl += ".json";
        buildRequest(circuitUrl);
        sendRequest(circuitUrl);
        return mapResponseToObject("/MRData/CircuitTable/Circuits");
    }

    // todo: url and path
    @Override
    public List<Result> getResults(boolean asJson) {
        String circuitUrl = API_URL + "/2020/current/last/results";
        if (asJson) circuitUrl += ".json";
        buildRequest(circuitUrl);
        sendRequest(circuitUrl);
        return mapResponseToObject("/MRData/RaceTable/Races/Results");
    }

    private void buildRequest(String driverUrl) {
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(driverUrl))
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();

        } catch (URISyntaxException e) {
            LOG.error("Error when creating HttpRequest: " + e);
        }
    }

    private void sendRequest(String driverUrl) {
        try {

            LOG.info("Getting data from url: " + driverUrl);
            response = HttpClient.newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            LOG.error("Error when sending HttpRequest: " + e);
        }
    }

    private <T> List<T> mapResponseToObject(String path) {
        JsonNode jsonNode;
        List<T> listFromResponse = null;
        try {
            jsonNode = mapper.readTree(response.body()).at(path);
            listFromResponse = mapper.convertValue(jsonNode, new TypeReference<>() {});

        } catch (JsonProcessingException e) {
            LOG.error("Error when converting response to Json: " + e);
        }
        return listFromResponse;
    }

}
