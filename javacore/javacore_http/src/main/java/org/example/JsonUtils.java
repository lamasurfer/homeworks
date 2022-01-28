package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils<T> {

    private final Class<T> classType;
    private final ObjectMapper objectMapper;

    public JsonUtils(ObjectMapper objectMapper, Class<T> classType) {
        this.objectMapper = objectMapper;
        this.classType = classType;
    }

    public T readSingleObject(String json) {
        T object = null;
        try {
            object = objectMapper.readValue(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public List<T> readMultipleObjectsWithRoot(String json, String root) {
        List<T> resultList = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(json).get(root);
            for (JsonNode node : jsonNode) {
                T object = readSingleObject(node.toString());
                resultList.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<T> readMultipleObjects(String json) {
        List<T> resultList = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            for (JsonNode node : jsonNode) {
                T object = readSingleObject(node.toString());
                resultList.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void writeSingleObject(String file, T object) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(file), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjects(String file, List<T> objects) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(file), objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
