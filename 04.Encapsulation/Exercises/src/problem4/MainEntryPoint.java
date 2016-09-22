package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            LinkedHashMap<String, Person> personsByName = new LinkedHashMap<>();
            LinkedHashMap<String, Product> productsByName = new LinkedHashMap<>();

           try{
               String[] inputPersons = reader.readLine().split(";");

               for (String current : inputPersons) {

                   String[] data = current.split("=");
                   String name = data[0];
                   double money = Double.parseDouble(data[1]);

                       Person person = new Person(name, money);
                       if (!personsByName.containsKey(name)) {
                           personsByName.put(name, person);
                       }
               }

               String[] inputProducts = reader.readLine().split(";");

               for (String current : inputProducts) {

                   String[] data = current.split("=");
                   String name = data[0];
                   double cost = Double.parseDouble(data[1]);

                       Product product = new Product(name, cost);
                       if (!productsByName.containsKey(name)) {
                           productsByName.put(name, product);
                       }
               }

               while (true) {

                   String input = reader.readLine();
                   if ("END".equals(input)) {
                       break;
                   }

                   String[] params = input.split("\\s+");
                   Person currentPerson = personsByName.get(params[0]);
                   Product currentProduct = productsByName.get(params[1]);

                   if (currentPerson.getMoney() < currentProduct.getCost()) {
                       System.out.printf("%s can't afford %s%n", params[0], params[1]);
                   } else {
                       System.out.printf("%s bought %s%n", params[0], params[1]);
                       currentPerson.setMoney(currentPerson.getMoney() - currentProduct.getCost());
                       currentPerson.getProducts().add(currentProduct);
                   }
               }

               for (Map.Entry<String, Person> person : personsByName.entrySet()) {

                   List<Product> productList = person.getValue().getProducts();
                   if (productList.size() == 0){
                       System.out.printf("%s - Nothing bought%n", person.getKey());
                   }else {
                       String productsAsString = productList.stream().map(p -> p.getName()).collect(Collectors.joining(", "));
                       System.out.printf("%s - %s%n",person.getKey(),productsAsString);
                   }
               }
           }catch (IllegalArgumentException ex){
               System.out.println(ex.getMessage());
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
