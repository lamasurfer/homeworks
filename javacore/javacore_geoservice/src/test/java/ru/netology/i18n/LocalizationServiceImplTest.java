package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @EnumSource(Country.class)
    void testLocale_validArgument(Country arg) {
        final LocalizationService localizationService = new LocalizationServiceImpl();
        String expected;
        if (arg.equals(Country.RUSSIA)) {
            expected = "Добро пожаловать";
        } else {
            expected = "Welcome";
        }
        assertEquals(expected, localizationService.locale(arg));
    }
}