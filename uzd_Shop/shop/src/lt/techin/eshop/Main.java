package lt.techin.eshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleProduct s = new SimpleProduct("a", 10);
        System.out.println(s.countBrutoInEuros2());
        Wine wine = new Wine("B", 10, 9, 2);
        System.out.println(wine.countBrutoInEuros2());

        Shop shop = new Shop();
        shop.addProduct(new Wine("A", 10, 10, 1));
        shop.addProduct(new AlcoholicDrink("B", 20, 20, 1));
        shop.addProduct(new Medicine("C", 30));
        shop.addProduct(new SimpleProduct("D", 40));
        shop.toString();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ar norite įvesti prekę? Parašykite taip arba ne");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("ne")) {
                System.out.println("Bye Bye :)");
                shop.toString();
                break;
            }

            System.out.println("Kokio tipo prekę norite įvesti? Parašykite pasirinkimą: paprasta, vaistas, alkoholis arba vynas");
            String productType = scanner.nextLine();
            if(productType.equalsIgnoreCase("paprasta") || productType.equalsIgnoreCase("vaistas")) {
                System.out.println("Įveskite prekės pavadinimą:");
                String title = scanner.nextLine();
                System.out.println("Įveskite prekės kainą:");
                double price = Double.parseDouble(scanner.nextLine());
                if(productType.equalsIgnoreCase("paprasta")) {
                    shop.addProduct(new SimpleProduct(title, price));
                    System.out.println("Prekė sėkmingai pridėta");
                } else {
                    shop.addProduct(new Medicine(title, price));
                    System.out.println("Prekė sėkmingai pridėta");
                }
            } else if(productType.equalsIgnoreCase("alkoholis") || productType.equalsIgnoreCase("vynas")){
                System.out.println("Įveskite prekės pavadinimą:");
                String title = scanner.nextLine();
                System.out.println("Įveskite prekės kainą:");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Įveskite prekės alk. tūrį procentais:");
                double volume = Double.parseDouble(scanner.nextLine());
                System.out.println("Įveskite prekės tūrį litrais:");
                double liters = Double.parseDouble(scanner.nextLine());
                if(productType.equalsIgnoreCase("alkoholis")) {
                    shop.addProduct(new AlcoholicDrink(title, price, volume, liters));
                    System.out.println("Prekė sėkmingai pridėta");
                } else {
                    shop.addProduct(new Wine(title, price, volume, liters));
                    System.out.println("Prekė sėkmingai pridėta");
                }
            } else {
                System.out.println("Tokios kategorijos nėra");
            }
        }
    }
}
