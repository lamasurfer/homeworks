package unit_4.homework4_1.task412;

public class NameIsInvalidException extends IllegalArgumentException {
    public NameIsInvalidException() {
        super("\nДля ввода имени и фамилии используйте буквы русского языка!");
    }
}
