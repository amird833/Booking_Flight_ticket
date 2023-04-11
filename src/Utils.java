import java.util.Scanner;

public class Utils {
    Scanner input = new Scanner(System.in);
    Print print = new Print();
    User[] users = new User[20];
    Flight[] flights = new Flight[20];


    public void newFlight()
    {
        for (int i = 0; i < flights.length; i++) {
            flights[i]=new Flight();
        }
    }

    public void newUsers()
    {
        for (int i = 0; i < users.length; i++) {
            users[i]=new User();

        }
    }
    public void addUser(int count)
    {
        String userStr="";
        int flag = 1;
        int flagUser ;
        System.out.print("Username : ");
        while (flag == 1)
        {
            flagUser = 0;
            userStr = input.next();

            for (User user : users) {
                if (user.getUsername() != null && user.getUsername().equals(userStr)) {
                    flagUser = 1;
                    break;
                }

            }
            if (flagUser != 1 )
            {
                flag = 0;
            }
            else
            {
                System.out.println("Incorrect!");
                System.out.println("Try again ");
                System.out.print("Username : ");
            }
        }
        users[count].setUsername(userStr);
    }
    public int signing() {
        String userStr;
        String passStr;
        int adminFlag = 0;
        int index = 0;
        int flag = 0;
        while (true) {
            System.out.print("Username : ");
            userStr = input.next();
            if (userStr.equals("admin")) {
                adminFlag = 1;
                break;
            } else {
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getUsername()!= null && users[i].getUsername().equals(userStr)) {
                        flag = 1;
                        index = i;
                        break;
                    }

                }
            }
            if (flag == 1 || adminFlag == 1)
                break;
            else
                System.out.print("Incorrect!\nTry again\n");

        }

        if (adminFlag == 1) {
            while (true) {
                System.out.print("Password : ");
                passStr = input.next();
                if (passStr.equals("admin"))
                    return 1;
                System.out.print("Incorrect\nTry again\n");
            }
        } else {
            while (true) {
                System.out.print("Password : ");
                passStr = input.next();
                if (passStr.equals(users[index].getPassword()))
                    return 2;
                System.out.print("Incorrect\nTry again\n");
            }
        }
    }
    public void start()
    {
        newUsers();
        newFlight();
        int userCount = 0;
        int flightCount = 0;
        while (true)
        {
            switch (print.printSignMenu()) {
                case 1 -> {
                    switch (signing()) {
                        case 1 ->//Admin
                        {
                            switch (print.printAdminOption()) {
                                case 1 ->// Add
                                {
                                    print.addAdmin(flights);
                                    flightCount += 1;
                                }
                                case 2 ->//Update
                                        System.out.println("Update");
                                case 3 ->//Remove
                                        System.out.println("Remove");
                                case 4 ->//Flight schedulse
                                        System.out.println("Flight schedulse");
                            }
                        }
                        case 2 ->//other
                                System.out.println("OTHER");
                    }
                }
                case 2 -> {//sabte num
                    addUser(userCount);
                    System.out.print("Password : ");
                    users[userCount].setPassword(input.next());
                    userCount++;
                }
            }
        }
    }
}
