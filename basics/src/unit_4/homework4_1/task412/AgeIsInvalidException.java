package unit_4.homework4_1.task412;

public class AgeIsInvalidException extends IllegalArgumentException {
    public AgeIsInvalidException() {
        super(String.format("\nОшибка, допустимый возраст: от %s до %s лет!", Employee.MIN_AGE, Employee.MAX_AGE));
    }
}
