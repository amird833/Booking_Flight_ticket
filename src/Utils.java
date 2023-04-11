import java.util.Scanner;

public class Utils {
    Scanner input = new Scanner(System.in);
    Print print = new Print();
    User[] users = new User[20];
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
    public void start()
    {
        newUsers();
        int userCount = 0;
        while (true)
        {
            switch (print.printSignMenu())
            {
                case 1 :
                    break;
                case 2 ://sabte num
                    addUser(userCount);
                    System.out.print("Password : ");
                    users[userCount].setPassword(input.next());
                    userCount++;
                    break;
            }
        }
    }
}
