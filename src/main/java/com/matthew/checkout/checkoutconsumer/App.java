package com.matthew.checkout.checkoutconsumer;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {
    
    private final String URI = "http://localhost:8001";
    Scanner input = new Scanner(System.in);
    
    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
    }
    
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
            return args -> {
                String itemId;
                String state = "";
                double quantity;
                double totalPrice = 0;
                
                while(!state.equalsIgnoreCase("exit")) {
                    log("Choose item (A, B, C, D): ");
                    itemId = input.next();
                    log("Choose quantity: ");
                    quantity = input.nextDouble();
                    Item item = new Item(itemId.toUpperCase(), quantity);
                    restTemplate.put(URI, item);
                    item = restTemplate.getForObject(URI, Item.class);
                    totalPrice = totalPrice + item.getTotalPrice();
                    log("Current value of items: " + totalPrice + " cents\n\n"
                        + "Type ADD to add more items or EXIT to finish\n");
                    state = input.next();
                }
            };
    }
    
    public void log(String s) {
        System.out.println(s);
    }
    
}
