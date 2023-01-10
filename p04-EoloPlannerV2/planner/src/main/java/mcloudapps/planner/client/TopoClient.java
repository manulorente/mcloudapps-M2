package mcloudapps.planner.client;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TopoClient {

    private static final String TOPO_HOST = "localhost";
    private static final int TOPO_PORT = 8081;

    @Async
    public CompletableFuture<String> getTopography(String city) throws JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://"+TOPO_HOST+":"+TOPO_PORT+"/api/v1/topographicdetails/" + city;
        String response = restTemplate.getForObject(url, String.class);
        return CompletableFuture.completedFuture(new ObjectMapper().readValue(response, Map.class).get("landscape").toString());
    }
}
