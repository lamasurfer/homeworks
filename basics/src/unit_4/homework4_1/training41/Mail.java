package unit_4.homework4_1.training41;

public class Mail {

    private String email;
    private String message;

    public Mail(String email, String message) {
        this.email = email;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("mail to: %s\n%s", email, message);
    }
}
