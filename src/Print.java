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
    public void addDefultFly(Flight[] flights)
    {
        flights[0].setFlightId("WX-12");
        flights[0].setOrigin("Yazd");
        flights[0].setDestination("Tehran");
        flights[0].setDate("1401-12-10");
        flights[0].setTime("12:30");
        flights[0].setPrice(700000);
        flights[0].setSeats(51);

        flights[1].setFlightId("WZ-15");
        flights[1].setOrigin("Mashhad");
        flights[1].setDestination("Ahvaz");
        flights[1].setDate("1401-12-11");
        flights[1].setTime("08:00");
        flights[1].setPrice(900000);
        flights[1].setSeats(245);

        flights[2].setFlightId("BG-22");
        flights[2].setOrigin("Shiraz");
        flights[2].setDestination("Tabriz");
        flights[2].setDate("1401-12-12");
        flights[2].setTime("22:30");
        flights[2].setPrice(1100000);
        flights[2].setSeats(12);
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
