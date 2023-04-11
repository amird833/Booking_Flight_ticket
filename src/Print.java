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
            System.out.print(">>");
            chose = input.nextInt();
        }
        return chose;
    }
    public int printAdminOption()
    {
        int chose;
        System.out.println("1- Add");
        System.out.println("2- Update");
        System.out.println("3- Remove");
        System.out.println("4 - Flight schedules");
        System.out.println("0 - Sign out");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 4 || chose<0)
        {
            System.out.println("Try again!");
            System.out.print(">>");
            chose = input.nextInt();
        }
        return chose;
    }

    public void addAdmin(Flight[] flights)
    {
        String str;
        int flag =0;
        System.out.print("FlightId : ");
        int index=0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].getFlightId()==null)
                index = i;

        }
        while (true) {
            str = input.next();
            for (Flight flight : flights) {
                if (flight.getFlightId() != null && flight.getFlightId().equals(str)) {
                    flag = 1;
                    break;
                }
            }
            if (flag ==1 )
            {
                System.out.println("Incorrect!");
                System.out.println("Try again");
                flag = 0;
            }
            else
            {
                flights[index].setFlightId(str);
                break;
            }

        }
        System.out.print("Origin : ");
        flights[index].setOrigin(input.next());
        System.out.print("Destination : ");
        flights[index].setDestination(input.next());
        System.out.print("Date : ");
        flights[index].setDate(input.next());
        System.out.print("Time : ");
        flights[index].setTime(input.next());
        System.out.print("Price : ");
        flights[index].setPrice(input.nextInt());
        System.out.print("Seats : ");
        flights[index].setSeats(input.nextInt());
    }
}
