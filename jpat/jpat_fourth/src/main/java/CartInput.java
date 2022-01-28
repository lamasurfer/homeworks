import org.example.cart.Cart;
import org.example.products.Product;
import org.example.stock.Stock;
import org.example.utils.InputChecker;

import java.util.Scanner;

public class CartInput {

    public static final String BUYING_SCREEN = "\nВыберите действие:" +
            "\n1. Просмотреть доступные товары" +
            "\n2. Добавить товары в корзину" +
            "\n3. Просмотреть корзину" +
            "\n4. Убрать товары из корзины" +
            "\n5. Перейти к оформлению заказа";

    private final Stock stock;
    private final Cart cart;
    private final Scanner scanner;

    public CartInput(Stock stock, Cart cart, Scanner scanner) {
        this.stock = stock;
        this.cart = cart;
        this.scanner = scanner;
    }

    public void startShopping() {
        System.out.println("Добро пожаловать в магазин!");
        String input;

        while (true) {
            System.out.println(BUYING_SCREEN);
            input = scanner.nextLine();

            switch (input) {
                case "1" -> System.out.println(stock);
                case "2" -> addToCart();
                case "3" -> System.out.println(cart);
                case "4" -> removeFromCart();
                case "5" -> {
                    if (cartIsEmpty(cart)) {
                        System.out.println("В корзине нет товаров!");
                        break;
                    }
                    return;
                }
                default -> System.out.println("Повторите выбор...");
            }
        }
    }

    private void addToCart() {
        System.out.println(stock);

        int range = stock.size();
        while (true) {
            System.out.println(stock);
            System.out.println("Введите номер продукта, который хотите добавить или q для выхода:");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                break;
            } else if (InputChecker.checkInput(input, range)) {
                int number = Integer.parseInt(input);
                Product toAdd = stock.getProduct(number - 1);
                cart.addProduct(toAdd);
                System.out.println("В корзину добавлен продукт: " + toAdd);
            }
        }
    }

    private void removeFromCart() {
        if (cartIsEmpty(cart)) {
            System.out.println("В корзине еще нет товаров!");
            return;
        }
        System.out.println(cart);

        while (true) {
            int range = cart.size();
            System.out.println("Введите номер продукта, который хотите удалить или q для выхода:");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                break;
            } else if (InputChecker.checkInput(input, range)) {
                int number = Integer.parseInt(input);
                cart.removeProduct(number - 1);
                System.out.println(cart);
            }
            if (cartIsEmpty(cart)) {
                break;
            }
        }
    }

    private boolean cartIsEmpty(Cart cart) {
        return cart.size() == 0;
    }

}

