public class Main {
    public static void main(String[] args) {
        Université univ = new Université("Hassan II");

        Laboratoire lab1 = new Laboratoire("LTIM");
        Laboratoire lab2 = new Laboratoire("LAMS");

        univ.ajouterLaboratoire(lab1);
        univ.ajouterLaboratoire(lab2);

        Chercheur ch1 = new Chercheur("1", "Alaoui", "Ali", 5);
        Chercheur ch2 = new Chercheur("2", "Omari", "Omar", 3);
        Chercheur ch3 = new Chercheur("3", "Tahiri", "Taha", 9);
        Chercheur ch4 = new Chercheur("4", "Yousfi", "Hassan", 16);
        Chercheur ch5 = new Chercheur("5", "Kadiri", "Hossam", 80);

        univ.ajouterChercheur(lab1, ch1);
        univ.ajouterChercheur(lab1, ch2);
        univ.ajouterChercheur(lab1, ch3);

        univ.ajouterChercheur(lab2, ch4);
        univ.ajouterChercheur(lab2, ch5);

        // Affichage détaillé des laboratoires
        for (Laboratoire lab : univ.getLaboratoires()) {
            System.out.println(lab);
            lab.afficherChercheurs();
        }

        System.out.println("\nAffichage laboratoires triés par H-index :");
        univ.afficherLaboratoires();
    }
}
