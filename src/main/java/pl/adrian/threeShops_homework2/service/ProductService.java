package pl.adrian.threeShops_homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.adrian.threeShops_homework2.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private Product product;

    @Value("${page.info.vat}")
    private int vat;
    @Value("${page.info.discount}")
    private int discount;

    public int getVat() {
        return vat;
    }

    public int getDiscount() {
        return discount;
    }

    public ProductService(Product product) {
        this.product = product;
    }

    List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        List<String> producstNames = Arrays.asList("Obuwie", "Telefon", "Witaminy", "Tablet", "Encyklopedia");

        for(int i = 0; i < producstNames.size(); i++)  {
            int lotteryPrice = rand();
            Product product = new Product(producstNames.get(i), lotteryPrice);
            products.add(product);
        }


    }

    public List<Product> getProductList(){
        return products;
    }

    public int rand(){
        Random randomPrice = new Random();
        int price = randomPrice.nextInt(301)+50;

        if(price > 300) {
            return 300;
        } else {
            return price;
        }
    }


}
