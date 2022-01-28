package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;


class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @Test
    void testByIp_localHost() {
        String argument = "127.0.0.1";
        assertNull(geoService.byIp(argument).getCity());
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.0.0.0", "96.0.0.0"})
    void testByIp_countries(String ip) {
        Country expected;
        Country actual;
        if (ip.startsWith("172.")) {
            expected = Country.RUSSIA;
            actual = geoService.byIp(ip).getCountry();
            assertEquals(expected, actual);
        } else if (ip.startsWith("96.")) {
            expected = Country.USA;
            actual = geoService.byIp(ip).getCountry();
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "96.44.183.149"})
    void testByIp_cities(String ip) {
        String expected;
        String actual;
        if (ip.equals("172.0.32.11")) {
            expected = "Moscow";
            actual = geoService.byIp(ip).getCity();
            assertEquals(expected, actual);
        } else if (ip.equals("96.44.183.149")) {
            expected = "New York";
            actual = geoService.byIp(ip).getCity();
            assertEquals(expected, actual);
        }
    }

    @Test
    void testByCoordinates_throwsException() {
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1, 1));
    }
}