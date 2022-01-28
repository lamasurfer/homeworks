package unit_4.homework4_1.task412;

public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException() {
        super("\nТакой сотрудник уже есть в списке!");
    }
}
