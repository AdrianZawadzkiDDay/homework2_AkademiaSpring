package pl.adrian.threeShops_homework2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("START")
public class ShopStart {

    private ProductService productService;

    public ShopStart(ProductService productService) {
        this.productService = productService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        double totalSum = 0;
        for(int i = 0; i < productService.getProductList().size(); i++){
            System.out.println(productService.getProductList().get(i));
            System.out.println();
            totalSum += productService.getProductList().get(i).getPrice();
        }
        System.out.println("Cena za zakupy wynosi: " + totalSum + " zł");
    }

}
