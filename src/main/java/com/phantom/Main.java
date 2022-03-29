package com.phantom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.phantom")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Cart cart = context.getBean(Cart.class);
        cart.addInCartProduct(2L);
        cart.addInCartProduct(9L);
        cart.addInCartProduct(8L);
        cart.addInCartProduct(5L);
        cart.addInCartProduct(7L);
        cart.addInCartProduct(1L);
        cart.addInCartProduct(6L);
        cart.showCartListProduct();
        cart.deleteCartProduct(6L);
        cart.deleteCartProduct(9L);
        cart.showCartListProduct();
        System.out.println();
        Cart cart1 = context.getBean(Cart.class);
        cart1.addInCartProduct(2L);
        cart1.addInCartProduct(4L);
        cart1.addInCartProduct(6L);
        cart1.addInCartProduct(8L);
        cart1.addInCartProduct(10L);
        cart1.showCartListProduct();
        context.close();
    }

}
