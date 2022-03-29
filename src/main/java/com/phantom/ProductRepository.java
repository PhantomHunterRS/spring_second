package com.phantom;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope("singleton")
public class ProductRepository {
    private final Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    Long id = 1L;
    private List<Product> productList = new ArrayList<>();
    @PostConstruct
    public void init(){
        logger.info("Init List Products");
        productList.add(new Product(id++,"Milk",159.00));
        productList.add(new Product(id++,"Butter",249.90));
        productList.add(new Product(id++,"Banana",87.56));
        productList.add(new Product(id++,"Mango",472.90));
        productList.add(new Product(id++,"Bacon",599.90));
        productList.add(new Product(id++,"Sausage",185.99));
        productList.add(new Product(id++,"Sturgeon",762.20));
        productList.add(new Product(id++,"Spinach",187.30));
        productList.add(new Product(id++,"BlackBerry",345.98));
        productList.add(new Product(id++,"Eggs",150.00));
    }

    public List<Product> getProductList() {
        return productList;
    }
    public void addProduct(String title,double cost){
        productList.add(new Product(id++,title,cost));
    }
    public Product findID(Long productId) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product tmp = iterator.next();
            if (tmp.getId() == productId) {
                return tmp;
            }
        }
        return null;
    }
    public void showAll(){
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            iterator.next().toString();
        }
    }

}
