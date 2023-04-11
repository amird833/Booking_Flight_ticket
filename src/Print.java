import java.util.Scanner;

public class Print {
    Scanner input = new Scanner(System.in);
    public int printSignMenu()
    {
        int chose;
        System.out.println("1-Sign in");
        System.out.println("2- Sign up");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 2 || chose < 1)
        {
            System.out.println("Try again!");
            System.out.printf(">>");
            chose = input.nextInt();
        }
        return chose;
    }
}
