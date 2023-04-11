import java.util.Scanner;

public class Utils {
    public int mainIndex;
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
                if (passStr.equals(users[index].getPassword())) {
                    mainIndex = index;
                    return 2;
                }
                System.out.print("Incorrect\nTry again\n");
            }
        }
    }
    public void start()
    {
        newUsers();
        newFlight();
        int exitFlag = 0;
        print.addDefultFly(flights);
        int userCount = 0;
        while (true)
        {
            switch (print.printSignMenu()) {
                case 1 -> {
                    switch (signing()) {
                        case 1 ->//Admin
                        {
                            exitFlag =0;
                            while(exitFlag == 0)
                            {
                                switch (print.printAdminOption()) {
                                    case 0 ->
                                        exitFlag = 1;
                                    case 1 ->// Add

                                            print.addAdmin(flights);

                                    case 2 ->//Update
                                            print.updateFlight(flights);
                                    case 3 ->//Remove
                                            print.remove(flights);
                                    case 4 ->//Flight schedulse
                                            print.printFlight(flights);
                                }
                            }
                        }
                        case 2 ->//other
                        {
                            System.out.printf("Welcome %s",users[mainIndex].getUsername());
                            switch (print.printOtherOption()) {
                                case 1:
                                    System.out.printf("Old password : %s\n",users[mainIndex].getPassword());
                                    System.out.printf("New password : ");
                                    users[mainIndex].setPassword(input.next());
                                    System.out.println("Change successfully");
                                    break;
                                case 2:
                                {
                                    switch (print.searchFlight())
                                    {
                                        case 1:
                                            print.flightIdSort(flights);
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            break;
                                        case 6:
                                            break;
                                        case 7:
                                            break;
                                    }
                                }
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 0:
                                    break;
                            }
                        }
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
