public class Main {
    public static void main(String[] args) {
        Lycee lycee = new Lycee("Annajah");

        // Parent 1
        Parent p1 = new Parent("X1001", "Alaoui", "Ali", TypeParent.pere);
        lycee.ajouterParent(p1);
        p1.ajouterEnfant("2019/1", "Alaoui", "Adil");

        // Parent 2
        Parent p2 = new Parent("B5003", "Omari", "Salwa", TypeParent.mere);
        lycee.ajouterParent(p2);
        p2.ajouterEnfant("2019/2", "Yousfi", "Hassan");
        p2.ajouterEnfant("2019/3", "Yousfi", "Houssine");

        // Parent 3
        Parent p3 = new Parent("ZR1003", "Zakani", "Yasser", TypeParent.pere);
        lycee.ajouterParent(p3);
        p3.ajouterEnfant("2019/4", "Tahiri", "Samira");

        // Parent 4
        Parent p4 = new Parent("AB1509", "Othmani", "Othman", TypeParent.tuteur);
        lycee.ajouterParent(p4);
        p4.ajouterEnfant("2019/5", "Nassiri", "Youssef");
        p4.ajouterEnfant("2019/6", "Nassiri", "Sara");
        p4.ajouterEnfant("2019/7", "Nassiri", "Ayoub");

        // Add delegates and display
        try {
            lycee.ajouterDélégué(p1);
            lycee.ajouterDélégué(p2);
            lycee.ajouterDélégué(p4);
        } catch (ParentInexistantException e) {
            System.out.println("Erreur : parent inexistant !");
        }

        System.out.println(lycee);
        lycee.afficherPourcentageTypes();
    }
}
