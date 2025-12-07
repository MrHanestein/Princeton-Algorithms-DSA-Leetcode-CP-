import java.util.Scanner;
public class HelloGoodbye {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.print("Enter the both of your names:");
        String firstNameInput = name.nextLine();
        String secondNameInput = name.nextLine();
        System.out.println("Hello " + firstNameInput + " and " + secondNameInput + ".");
        System.out.println("Goodbye " + secondNameInput + " and " + firstNameInput + ".");
    }
}