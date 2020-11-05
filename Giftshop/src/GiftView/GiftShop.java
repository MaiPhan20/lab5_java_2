package GiftView;

import GiftController.GiftController;
import GiftModel.GiftJava;

import java.util.Scanner;

public class GiftShop extends GiftController {
    public static void main(String[] args) {
        loading();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println(" what you can do:\n" +
                    "1. Display all the books\n" +
                    "2. Insert new book\n" +
                    "3. Delete book\n" +
                    "4. Exit");
            System.out.println("Enter you choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    select();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Please enter valid choice");
                    break;
            }
        }while(choice!=5);
    }
    public static void addBook(){
        Scanner input = new Scanner(System.in);
        GiftJava objGift = new GiftJava();
        System.out.println("Enter book id: ");
        int id = input.nextInt();
        objGift.setId(id);
        System.out.println("Enter book name: ");
        String title = input.nextLine();
        objGift.setName(input.nextLine());
        System.out.println("Enter author name: ");
        String author = input.nextLine();
        objGift.setAuthor(author);
        System.out.println("Enter price: ");
        double price = input.nextDouble();
        objGift.setPrice(price);
        System.out.println("Enter quantity: ");
        int qty = input.nextInt();
        objGift.setQty(qty);
        insert(objGift);
    }
}
