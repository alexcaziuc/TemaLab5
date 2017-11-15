import java.io.IOException;
import java.util.Scanner;

public class LoginApp {

    public static void main(String[] args) {

        int tentativeDeLogin = 1;
        LoginUsers[] users = new LoginUsers[4];

        users[0] = new LoginUsers();
        users[0].user = "ionel";
        users[0].password = "a";


        users[1] = new LoginUsers();
        users[1].user = "maria";
        users[1].password = "b";

        users[2] = new LoginUsers();
        users[2].user = "ioana";
        users[2].password = "c";

        // citire user si parola de la tast

        String u = citireNume("da userul:");
        String p = citireNume("da parola:");


        while (login(users, u, p) != true && tentativeDeLogin < 3) {

            u = citireNume("da userul:");
            p = citireNume("da parola:");
            tentativeDeLogin++;
        }

        // verificare tentatice login
        if (tentativeDeLogin <= 3) {
            System.out.println("bravoooo ");

            // dechide notepad
            Runtime rt = Runtime.getRuntime();

            try {
                rt.exec("notepad");
            } catch (IOException ex) {

                System.out.println(ex);

            }
        }else {
            System.out.println("\nAu fost introduse mai mult de 3 incercari");
        }
    }

    // Metoda Login

    public static boolean login(LoginUsers[] a, String u, String p) {
        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null)
                if (u.equalsIgnoreCase(a[i].user) && p.equalsIgnoreCase(a[i].password)) {
                    System.out.println("Userul a fost logat cu succes");
                    found = true;
                    break;
                }
        }
        return found;
    }

    // Metoda citireNume

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String nume = scan.nextLine();
        return nume;
    }
}
