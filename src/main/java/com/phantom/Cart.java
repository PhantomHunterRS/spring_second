package com.phantom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    static Logger logger = LoggerFactory.getLogger(Cart.class);
    @PostConstruct
    public void init(){
        logger.info("New Cart");
    }
    List<Product> cartListProduct = new ArrayList<>();
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addInCartProduct(Long id){
        logger.info("Product add in cart");
        cartListProduct.add(productRepository.findID(id));
    }
    public void deleteCartProduct(Long id){
        logger.info("Product delete in cart");
        cartListProduct.remove(productRepository.findID(id));
        }
        public void showCartListProduct(){
        logger.info("products in cart show");
            for (Product tmp:cartListProduct) {
                System.out.println(tmp.toString());
            }
        }
    }

