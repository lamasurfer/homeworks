package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {

    @Mock
    GeoService geoService;

    @Mock
    LocalizationService localizationService;

    @InjectMocks
    MessageSenderImpl messageSender;

    @Test
    void testSend_russian() {
        when(geoService.byIp(startsWith("172"))).thenReturn(new Location(null, Country.RUSSIA, null, 0));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.123.12.19");

        String expected = messageSender.send(headers);
        assertTrue(expected.matches("[^A-Za-z]+"));
    }

    @Test
    void testSend_foreign() {
        when(geoService.byIp(startsWith("96"))).thenReturn(new Location(null, Country.USA, null, 0));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "96.44.183.149");

        String expected = messageSender.send(headers);
        assertTrue(expected.matches("[^А-я]+"));
    }
}