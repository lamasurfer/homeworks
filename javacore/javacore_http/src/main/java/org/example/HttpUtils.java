package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HttpUtils {

    private final CloseableHttpClient httpClient;

    public HttpUtils(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getContentString(HttpGet httpGet) {
        String result = "";
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public InputStream getContentStream(HttpGet httpGet) {
        InputStream result = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            result = response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
