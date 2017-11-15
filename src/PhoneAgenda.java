import java.util.Scanner;

public class PhoneAgenda {


    public static void showMenu() {
        System.out.println("1> Display Agenda");
        System.out.println("2> Add");
        System.out.println("3> Delete");
        System.out.println("4> Edit");
        System.out.println("5> Search");
        System.out.println("0> Exit");
    }

    public static String readName(String label) {

        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String numeCitit = scan.nextLine();

        return numeCitit;
    }

    public static String readPhone(String label) {

        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String telefonulCitit = scan.nextLine();

        return telefonulCitit;
    }


    public static void main(String[] args) {

        Person[] contactsList = new Person[12];

        contactsList[0] = new Person();
        contactsList[0].name = "Florin";
        contactsList[0].phone = "0740 123 456";

        contactsList[1] = new Person();
        contactsList[1].name = "Mihai";
        contactsList[1].phone = "0741 234 567";

        contactsList[2] = new Person();
        contactsList[2].name = "Costel";
        contactsList[2].phone = "0742 345 678";


        int optiune = 9;
        do {
            showMenu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            switch (optiune) {
                case 1: {
                    displayAgenda();
                    break;
                }

                case 2: {

                    break;
                }

                case 3: {

                    break;
                }

                case 4: {

                    break;
                }

                case 5: {

                    //String nume = citireNume("Numele cautat :");
                    //cautareSimpla(nume);
                    break;
                }
            }
        }
        while (optiune != 0);

    }

    private static void displayAgenda() {


    }
}
