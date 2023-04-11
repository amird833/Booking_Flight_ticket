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
    public void updateFlight(Flight[] flights)
    {
        String flightId;
        flightId = input.next();
        int index =0;
        int flag = 0;
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId()!=null && flights[i].getFlightId().equals(flightId))
            {
                flag = 1;
                index = i;
                break;
            }
        }
        if (flag ==1)
        {
            switch (printPartOfFlightInformation())
            {
                case 1 :
                    System.out.printf("Old Origin : %s",flights[index].getOrigin());
                    System.out.printf("New Origin : ");
                    flights[index].setOrigin(input.next());
                    System.out.println("Change is successfully");
                    break;
                case 2:
                    System.out.printf("Old Destination : %s",flights[index].getDestination());
                    System.out.printf("New Destination : ");
                    flights[index].setDestination(input.next());
                    System.out.println("Change is successfully");
                    break;
                case 3 :
                    System.out.printf("Old Date : %s",flights[index].getDate());
                    System.out.printf("New Date : ");
                    flights[index].setDate(input.next());
                    System.out.println("Change is successfully");
                    break;
                case 4:
                    System.out.printf("Old Time : %s",flights[index].getTime());
                    System.out.printf("New Time : ");
                    flights[index].setTime(input.next());
                    System.out.println("Change is successfully");
                    break;
                case 5:
                    System.out.printf("Old Price : %d",flights[index].getPrice());
                    System.out.printf("New Price : ");
                    flights[index].setPrice(input.nextInt());
                    System.out.println("Change is successfully");
                    break;
                case 6:
                    System.out.printf("Old Seats : %d",flights[index].getSeats());
                    System.out.printf("New Seats : ");
                    flights[index].setSeats(input.nextInt());
                    System.out.println("Change is successfully");
                    break;
            }

        }
        else
        {
            System.out.println("Cant find this flight Id");
        }
    }
    public int printPartOfFlightInformation()
    {
        int chose  ;
        System.out.println("Select number");
        System.out.println("1- Origin");
        System.out.println("2- Destination");
        System.out.println("3- Date");
        System.out.println("4- Time");
        System.out.println("5- Price");
        System.out.println("6- Seats");
        System.out.printf(">>");
        chose = input.nextInt();
        while (chose >6 || chose < 1 )
        {
            System.out.println("Try again!" );
            System.out.printf(">>");
            chose=input.nextInt();
        }
        return chose;
    }
    public void remove(Flight[] flights)
    {
        String flightId = "";
        int flag = 0;
        int index = 0;
        System.out.println("Enter flightId you want delete");
        System.out.printf(">>");
        flightId = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId()!=null && flights[i].getFlightId().equals(flightId))
            {
                flag = 1;
                index = i;
                break;
            }
        }
        if (flag ==1)
        {
            flights[index].setFlightId(null);
            System.out.println("Delete is successfully");
        }
        else
        {
            System.out.println("Cant find this flightId!");
        }

    }
    public void printFlight(Flight[] flights)
    {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].getFlightId() != null)
            {
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());
            }
        }
    }
    public int printOtherOption()
    {
        int chose;
        System.out.println("Select number");
        System.out.println("1- Change password");
        System.out.println("2- Search flight tickets");
        System.out.println("3- Booking ticket");
        System.out.println("4- Ticket cancellation");
        System.out.println("5- Booked tickets");
        System.out.println("6- Add charge");
        System.out.println("0- Sign out");
        System.out.printf(">>");
        chose = input.nextInt();
        while (chose >6 || chose < 0 )
        {
            System.out.println("Try again!" );
            System.out.printf(">>");
            chose=input.nextInt();
        }
        return chose;
    }
    public int searchFlight()
    {
        int chose ;
        System.out.println("1- FlightId");
        System.out.println("2- Origin");
        System.out.println("3- Destination");
        System.out.println("4- Date");
        System.out.println("5- Time");
        System.out.println("6- Price");
        System.out.println("7- Seats");
        System.out.printf(">>");
        chose = input.nextInt();
        while (chose >7 || chose < 1 )
        {
            System.out.println("Try again!" );
            System.out.printf(">>");
            chose=input.nextInt();
        }
        return chose;
    }
    public void flightIdSort(Flight[] flights)
    {
        String str;
        System.out.print("Enter FlightId :");
        str = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getFlightId().equals(str))
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void originSort(Flight[] flights)
    {
        String str;
        System.out.print("Enter Origin :");
        str = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getOrigin().equals(str))
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void destinationSort(Flight[] flights)
    {
        String str;
        System.out.print("Enter Destination :");
        str = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getDestination().equals(str))
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void dateSort(Flight[] flights)
    {
        String str;
        System.out.print("Enter Date :");
        str = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getDate().equals(str))
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void timeSort(Flight[] flights)
    {
        String str;
        System.out.print("Enter Time :");
        str = input.next();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getTime().equals(str))
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void priceSort(Flight[] flights)
    {
        int price;
        System.out.print("Enter Price :");
        price = input.nextInt();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getPrice()==price)
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }

    public void seatsSort(Flight[] flights)
    {
        int seats;
        System.out.print("Enter Seats :");
        seats = input.nextInt();
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightId() != null && flights[i].getSeats()==seats)
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n",flights[i].getFlightId(),flights[i].getOrigin(),flights[i].getDestination(),flights[i].getDate(),flights[i].getTime(),flights[i].getPrice(),flights[i].getSeats());

        }
    }
    public void booking(Flight[] flights,User user) {
        String flight;
        int indexFlight = 0;
        int indexUser=0;
        int flag = 0;
        System.out.printf("Enter flightId : ");
        flight = input.next();
        while (true) {
            for (int i = 0; i < flights.length; i++) {
                if (flights[i].getFlightId() != null && flights[i].getFlightId().equals(flight)) {
                    flag = 1;
                    indexFlight = i;
                    break;
                }

            }
            if (flag == 1) {
                System.out.println("find this flight");
                System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n", flights[indexFlight].getFlightId(), flights[indexFlight].getOrigin(), flights[indexFlight].getDestination(), flights[indexFlight].getDate(), flights[indexFlight].getTime(), flights[indexFlight].getPrice(), flights[indexFlight].getSeats());

                break;
            } else {
                System.out.println("Try again");
                System.out.printf(">>");
                flight = input.next();
            }

        }
        for (int i = 0; i < user.ticketFlightId.length; i++) {
            if (user.ticketFlightId[i] == null) {
                indexUser = i;
            }

        }
        if (user.getVault() < flights[indexFlight].getPrice())
        {
            System.out.println("You dont have enugh many :(");

        }
        else if (flights[indexFlight].getSeats() > 0)
        {
            System.out.println("This flight dont have any seats");
        }
        else
        {
            user.setVault(user.getVault() - flights[indexFlight].getPrice());
            user.ticketFlightId[indexUser]=flight;
            flights[indexFlight].setSeats(flights[indexFlight].getSeats()-1);
        }
    }
    public void cancellBook(Flight[] flights , User user)
    {
        int flag = 0;
        String flightid;
        System.out.println("You have these tickets ");
        for (int i = 0; i < user.ticketFlightId.length; i++) {
            if (user.ticketFlightId[i] != null)
            {
                for (int j = 0; j < flights.length; j++) {
                    {
                        if (flights[j].getFlightId() != null && flights[j].getFlightId().equals(user.ticketFlightId[i]))
                        {
                            System.out.printf("%6s       %6s        %6s            %6s          %6s        %10d         %3d\n", flights[j].getFlightId(), flights[j].getOrigin(), flights[j].getDestination(), flights[j].getDate(), flights[j].getTime(), flights[j].getPrice(), flights[j].getSeats());
                        }
                    }

                }
            }

        }
        System.out.printf("Which ticket you eant delete , Enter flightId :  ");
        flightid = input.next();

    }
}
