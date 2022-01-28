package org.example.task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.HttpUtils;
import org.example.JsonUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();


        HttpUtils httpUtils = new HttpUtils(httpClient);

        HttpGet request = new HttpGet("https://cat-fact.herokuapp.com/facts");
        String json = httpUtils.getContentString(request);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonUtils<Fact> jsonUtils = new JsonUtils<>(objectMapper, Fact.class);

        String root = "all";
        List<Fact> facts = jsonUtils.readMultipleObjectsWithRoot(json, root);

        List<Fact> filteredFacts = facts.stream()
                .filter(x -> x.getUpvotes() > 0)
                .collect(Collectors.toList());

        System.out.println(filteredFacts);
        jsonUtils.writeObjects("facts.json", filteredFacts);

    }
}
