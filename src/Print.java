import java.util.Scanner;

public class Print {
    Scanner input = new Scanner(System.in);
    public int printSignMenu()
    {
        System.out.println("1-Sign in");
        System.out.println("2- Sign up");
        System.out.printf(">>");
        return input.nextInt();
    }
}
