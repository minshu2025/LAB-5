import java.util.Scanner;

public class RestaurantMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to Our Restaurant!");
            System.out.println("Please choose the type of food:");
            System.out.println("1. Veg (Green)");
            System.out.println("2. Non-Veg (Red)");
            System.out.println("3. Egg (Brown)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayVegDishes();
                    break;
                case 2:
                    displayNonVegDishes();
                    break;
                case 3:
                    displayEggDishes();
                    break;
                case 0:
                    System.out.println("Thank you for visiting our restaurant!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    public static void displayVegDishes() {
        System.out.println("----- Veg Dishes (Green) -----");
        System.out.println("1. Paneer Tikka");
        System.out.println("2. Veg Biryani");
        System.out.println("3. Stuffed Paratha");
        System.out.println("4. Vegetable Soup");
    }

    public static void displayNonVegDishes() {
        System.out.println("----- Non-Veg Dishes (Red) -----");
        System.out.println("1. Chicken Curry");
        System.out.println("2. Mutton Biryani");
        System.out.println("3. Fish Fry");
        System.out.println("4. Grilled Chicken");
    }

    public static void displayEggDishes() {
        System.out.println("----- Egg Dishes (Brown) -----");
        System.out.println("1. Egg Curry");
        System.out.println("2. Scrambled Eggs");
        System.out.println("3. Egg Fried Rice");
        System.out.println("4. Deviled Eggs");
    }
}

