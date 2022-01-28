package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.HttpUtils;
import org.example.JsonUtils;

import java.io.*;
import java.net.URI;

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
        HttpGet jsonGet = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        String json = httpUtils.getContentString(jsonGet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        JsonUtils<NasaApod> jsonUtils = new JsonUtils<>(objectMapper, NasaApod.class);
        NasaApod nasaApod = jsonUtils.readSingleObject(json);

        if (nasaApod.getMediaType().equals(MediaType.VIDEO)) {

            jsonUtils.writeSingleObject("video.json", nasaApod);
            System.out.println(nasaApod.getUrl());

        } else {

            URI image = nasaApod.getUrl();
            HttpGet imageGet = new HttpGet(image);
            InputStream inputStream = httpUtils.getContentStream(imageGet);
            String imageFileName = FilenameUtils.getName(image.getPath());
            writeFile(inputStream, imageFileName);
        }
    }

    public static void writeFile(InputStream inputStream, String fileName) {
        try (BufferedInputStream bis = new BufferedInputStream(inputStream);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)))) {
            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
