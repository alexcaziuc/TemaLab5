import java.util.Scanner;

// TODO: 16-Nov-17 De tratat cazurile in care se da un nume care nu exista in Agenda !!!!

public class PersonAgenda {

    static Person[] contactsList = new Person[10];

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

        contactsList[0] = new Person();
        contactsList[0].name = "Florin";
        contactsList[0].phone = "0740 123 456";

        contactsList[1] = new Person();
        contactsList[1].name = "Mihai";
        contactsList[1].phone = "0741 234 567";

        contactsList[2] = new Person();
        contactsList[2].name = "Costel";
        contactsList[2].phone = "0742 345 678";

        contactsList[3] = new Person();
        contactsList[3].name = "Mircea";
        contactsList[3].phone = "0743 456 789";

        contactsList[4] = new Person();
        contactsList[4].name = "Sergiu";
        contactsList[4].phone = "0744 567 890";


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

                    add();
                    break;
                }

                case 3: {

                    delete();
                    break;
                }

                case 4: {
                    edit();
                    break;
                }

                case 5: {

                    String nume = readName("Searched name: ");
                    search(nume);
                    break;
                }
            }
        }
        while (optiune != 0);

//        for (Person person: contactsList
//             ) {
//            System.out.println(person);
//        }

    }


    private static void displayAgenda() {

        for (Person contact : contactsList) {
            if (contact != null)
                System.out.println(contact.name + " : " + contact.phone);
        }
        System.out.println();
    }

    private static void add() {

//        if (position < contactsList.length) {
//
//            String nume = readName("Da-ti numele de adaugat: ");
//            String tel = readPhone("Da-ti nr de telefon: ");
//
//            contactsList[position].name = nume;
//            contactsList[position].phone = tel;
//
//            position++;
//
//        } else {

            for (int i = 0; i < contactsList.length; i++) {
                if (contactsList[i] == null) {

                    String nume = readName("Da-ti numele de adaugat: ");
                    String tel = readPhone("Da-ti nr de telefon: ");

                    contactsList[i] = new Person();
                    contactsList[i].name = nume;
                    contactsList[i].phone = tel;
                    System.out.println("Contactul a fost adaugat.");
                    return;
                }

            }
            System.out.println("agenda plina, ia alta mai mare");

    }


    public static void delete() {
        String nume = readName("Da-ti numele de sters:");

        int indexCautat = -1;
        indexCautat = search(nume);

        if (indexCautat != -1) {

            System.out.println(contactsList[indexCautat].name + " a fost sters din agenda.");
            contactsList[indexCautat] = null;
        }
    }

    private static void edit() {

        String nume = readName("Numele care trebuie editat:");

        int index = search(nume);

        if (index >= 0) {

            String numeleDeInlocuit = readName("Numele nou: ");
            String telefonulDeInlocuit = readPhone("Numarul de telefon nou: ");

            contactsList[index].name = numeleDeInlocuit;
            contactsList[index].phone = telefonulDeInlocuit;

            System.out.println("\nNumele si nr de telefon cautat a fost gasit si inlocuit\n");
        }
    }

    private static int search(String name) {

        int index = -1;

        for (int i = 0; i < contactsList.length; i++) {

            if (contactsList[i] != null && name.equalsIgnoreCase(contactsList[i].name)) {

                System.out.println(contactsList[i].name + " : " + contactsList[i].phone + " exista in agenda.");
                index = i;
                return index;
            }
        }

        System.out.println(name + " nu exista in agenda!");
        return -1;
    }
}
