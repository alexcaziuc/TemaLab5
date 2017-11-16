import java.util.Scanner;

public class AgendaNume {

    static String[] agendaDeNume = new String[10];
    static int pozitie = 0;

    public static void afisareMeniu() {
        System.out.println("1> Afisare");
        System.out.println("2> Adaugare");
        System.out.println("3> Stergere");
        System.out.println("4> Modificare");
        System.out.println("5> Cautare");
        System.out.println("0> Exit");

    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String numeCitit = scan.nextLine();
        return numeCitit;
    }

    public static void main(String[] args) {

        agendaDeNume[0] = "Alex";
        agendaDeNume[1] = "Ale";
        agendaDeNume[2] = "Gigi";
        agendaDeNume[3] = "Costel";

        int optiune = 9;
        do {
            afisareMeniu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();
            switch (optiune) {
                case 1: {
                    afisareAgenda();
                    break;
                }

                case 2: {
                    adaugareAgenda();
                    break;
                }

                case 3: {
                    stergere();
                    break;
                }

                case 4: {
                    modificare();
                    break;
                }

                case 5: {

                    String nume = citireNume("Numele cautat :");
                    cautareSimpla(nume);
                    break;
                }
            }
        }
        while (optiune != 0);
    }


    public static void afisareAgenda() {
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i] != null) {
                System.out.println(agendaDeNume[i]);
            }

        }
    }

    public static void adaugareAgenda() {
        if (pozitie < agendaDeNume.length) {
            String nume = citireNume("Da-ti numele de adaugat:");
            agendaDeNume[pozitie] = nume;
            pozitie++;
        } else {
            // totusi hai sa cautam in goluri , ugly code !!!!
            for (int i = 0; i < agendaDeNume.length; i++) {
                if (agendaDeNume[i] == null) {
                    String nume = citireNume("Da-ti numele de adaugat:");
                    agendaDeNume[i] = nume;
                    break;
                }
            }

            System.out.println("agenda plina, ia alta mai mare");
        }
        System.out.println();
    }


    public static int cautare(String nume) { //se opreste la primul gasit
        int found = -1;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (nume.equalsIgnoreCase(agendaDeNume[i])) {
                agendaDeNume[i] = null;
                System.out.println("am sters pe :" + nume);
                found = i;
                break;
            }
        }
        return found;
    }

    public static void stergere() {
        String nume = citireNume("Da-ti numele de sters:");
        int indexCautat = -1;
        indexCautat = cautare(nume);
        if (indexCautat != -1)
            agendaDeNume[indexCautat] = null;
    }


    //  ->>>>>>>>>>>>>>>>>>>>>>> metoda cautare + modificare
    public static int cautareSimpla(String nume) {

        int index = -1;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (nume.equalsIgnoreCase(agendaDeNume[i])) {

                System.out.println(nume + " exista in agenda telefonica.");
                index = i;

            }
        }

        if (index == -1)
            System.out.println(nume + " nu exista in agenda telefonica.");

        return index;
    }

    public static void modificare() {

        String nume = citireNume("Numele care trebuie editat:");

        int index = cautareSimpla(nume);

        if(index >= 0) {

            String numeleDeInlocuit = citireNume("Numele nou: ");
            agendaDeNume[index] = numeleDeInlocuit;

            System.out.println("Numele cautat a fost gasit si inlocuit");
        }
    }
}