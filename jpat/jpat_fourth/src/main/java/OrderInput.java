import org.example.order.DeliveryType;
import org.example.order.Order;
import org.example.utils.InputChecker;

import java.util.Scanner;

public class OrderInput {

    public static final String ORDER_SCREEN = "\nВыберите действие:" +
            "\n1. Выбрать способ доставки" +
            "\n2. Указать адрес доставки" +
            "\n3. Подтвердить заказ" +
            "\n0. Выход";

    private final Order order;
    private final Scanner scanner;

    public OrderInput(Order order, Scanner scanner) {
        this.order = order;
        this.scanner = scanner;
    }

    public void finishShopping() {
        while (true) {
            System.out.println(ORDER_SCREEN);
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    showDeliveryOptions();
                    setDelivery();
                    break;
                case "2":
                    setAddress();
                    break;
                case "3":
                    submit();
                    return;
                case "0":
                    return;
                default:
                    System.out.println("Повторите выбор...");
                    break;
            }
        }
    }

    private void setDelivery() {
        DeliveryType[] values = DeliveryType.values();
        int range = values.length;
        String input = scanner.nextLine();
        if (InputChecker.checkInput(input, range)) {
            int index = Integer.parseInt(input);
            order.setDelivery(values[index - 1]);
            System.out.println("Выбран тип доставки: " + order.getDeliveryType());
        }
    }

    private void setAddress() {
        if (!order.getDeliveryType().equals(DeliveryType.PICKUP)) {
            System.out.println("Введите адрес доставки: ");
            String input = scanner.nextLine();
            order.setAddress(input);
        } else {
            System.out.println("Выбран самовывоз!");
        }
    }

    private void submit() {
        order.submit();
        System.out.println("Ваш заказ оформлен!");
        System.out.println(order);
    }

    private void showDeliveryOptions() {
        DeliveryType.showDeliveryOptions();
    }
}
