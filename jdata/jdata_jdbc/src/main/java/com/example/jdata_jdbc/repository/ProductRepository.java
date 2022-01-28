package com.example.jdata_jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private static final String SCRIPT_FILENAME = "search.sql";
    private static final String SEARCH_SCRIPT = read(SCRIPT_FILENAME);

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProduct(String name) {
        return entityManager.createQuery(SEARCH_SCRIPT, String.class)
                .setParameter("name", name)
                .getResultList();
    }

    static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
