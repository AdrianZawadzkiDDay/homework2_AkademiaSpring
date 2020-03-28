package pl.adrian.threeShops_homework2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("PRO")
public class ShopPro {

    private ProductService productService;

    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        double totalPrice = 0;
        for(int i = 0; i < productService.getProductList().size(); i++){
            int price = productService.rand();

            System.out.println(productService.getProductList().get(i).getName());
            System.out.println("Cena netto:   " + price + " zł");
            System.out.println("Stawka vat:   " + productService.getVat() + "%");
            float cenaBrutto = price* productService.getVat()/100 + price;
            System.out.println("Cena cenaBrutto:  " + cenaBrutto + "zł");
            System.out.println();
            totalPrice += cenaBrutto;
        }
        System.out.println("Rabat na zakupy:   " + productService.getDiscount() + " zł");
        System.out.println("Cena bez rabatu:   " + totalPrice + " zł");
        System.out.println("Cena po rabacie:   " + (totalPrice - productService.getDiscount() + " zł"));

        System.out.print("Cena za zakupy wynosi: ");
        System.out.printf("%6.2f", totalPrice);
        System.out.print(" zł ");
    }

}
