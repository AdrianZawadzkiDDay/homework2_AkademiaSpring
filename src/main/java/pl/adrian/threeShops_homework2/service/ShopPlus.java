package pl.adrian.threeShops_homework2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("PLUS")
public class ShopPlus {

    private ProductService productService;

    public ShopPlus(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        double totalSum = 0;
        for(int i = 0; i < productService.getProductList().size(); i++){
            System.out.println("----------");
            System.out.println(productService.getProductList().get(i));
            System.out.println("Stawka vat: " + productService.getVat() + "%");

            double cenaBrutto = productService.getProductList().get(i).getPrice() * productService.getVat()/100 + productService.getProductList().get(i).getPrice();

            System.out.print("Cena cenaBrutto:    ");
            System.out.printf("%6.2f", cenaBrutto);
            System.out.println(" zł ");
            System.out.println("----------");

            totalSum += cenaBrutto;
        }
        System.out.println();
        System.out.print("Cena za zakupy wynosi: ");
        System.out.printf("%6.2f", totalSum);
        System.out.print(" zł ");

    }

}
