/*
 1. Магические числа
 примеры в классе OrderImpl, в enum DeliveryType

 2. Don’t Repeat Yourself
 например в InputChecker

 3. SOLID
 a. Single-Responsibility principle
 классы логически разделены по своим задачам

 b. Open-Closed principle
 это упрощенная версия магазина, склад не отображает количество товаров, в корзину добавляется один продукт за раз
 и все они отображаются отдельно, даже сейчас можно без особых усилий переделать и склад и корзину под учет количества
 товаров, но лучшим решением было бы предоставлять фабрики, допустим фабрика CartFactory - которая может вернуть
 имплементацию например SimpleCart (как сейчас), ComplexCart (с методом void addProduct(Product product, int amount);),
 в данном случае это не сделано ввиду простоты задачи, но в уме надо держать именно такой подход, во всяком случае я
 этот принцип так понял)

 c. Liskov substitution principle
 в package products

 d. Interface segregation principle
 соблюдается, даже в классах CartInput, OrderInput, хоть они и громоздкие получились, но каждый отвечает за свою часть

 8. Dependency inversion principle
 соблюдается, т.к. составные классы зависят от интерфейсов Cart, Stock, Loader, Order, а не от их конкретных реализаций
*/

import org.example.cart.Cart;
import org.example.cart.CartImpl;
import org.example.data.Loader;
import org.example.data.LoaderImpl;
import org.example.order.Order;
import org.example.order.OrderImpl;
import org.example.stock.Stock;
import org.example.stock.StockImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Loader loader = LoaderImpl.getNewLoader();
        Stock stock = StockImpl.getNewStock(loader);


        Scanner scanner = new Scanner(System.in);

        Cart cart = CartImpl.getNewCart();
        CartInput cartInput = new CartInput(stock, cart, scanner);
        cartInput.startShopping();

        Order order = OrderImpl.getNewOrder(cart);
        OrderInput orderInput = new OrderInput(order, scanner);
        orderInput.finishShopping();

    }
}

