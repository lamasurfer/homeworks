package unit_3.homework3_4.training34;

public class UrlUtils {
    public static void validate(String value) throws NotValidUrlException {
        boolean isValidSchema = value.startsWith("http://") || value.startsWith("https://");
        if (!isValidSchema) {
            throw new UnsupportedSchemaException(value);
        }
        if (value.contains(" ")) {
            throw new NotValidUrlException("Url содержит пробелы: " + value);
        }
    }
}
