import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Create clients
            Client client1 = new Client("Alpha Corp");
            Client client2 = new Client("Beta Solutions");

            // Create missions
            Mission m1 = new MissionFactureeAuLivrable(
                    "Website Redesign",
                    LocalDate.of(2026, 2, 1),
                    LocalDate.of(2026, 2, 10),
                    Statut.EN_COURS,
                    client1,
                    1500
            );

            Mission m2 = new MissionFactureeParJour(
                    "Mobile App Development",
                    LocalDate.of(2026, 1, 15),
                    LocalDate.of(2026, 2, 15),
                    Statut.EN_COURS,
                    client1,
                    200, 20
            );

            Mission m3 = new MissionFactureeAuLivrable(
                    "Database Migration",
                    LocalDate.of(2026, 1, 5),
                    LocalDate.of(2026, 1, 20),
                    Statut.TERMINEE,
                    client2,
                    1200
            );

            // Create freelance
            Freelance freelance = new Freelance("Chaimaa");

            // Add missions
            freelance.ajouterMission(m1);
            freelance.ajouterMission(m2);
            freelance.ajouterMission(m3);

            // Display all missions types
            System.out.println("=== Mission Types ===");
            freelance.afficherTypeDeMission();

            // Show total revenue
            System.out.println("\nTotal revenue: " + freelance.getTotalRevenu());

            // Revenue per client
            System.out.println("Revenue for Alpha Corp: " + freelance.getMontantFactureParClient(client1));
            System.out.println("Revenue for Beta Solutions: " + freelance.getMontantFactureParClient(client2));

            // Missions in progress
            System.out.println("\n=== Missions in Progress ===");
            freelance.getMissionsEnCours().forEach(System.out::println);

            // Missions sorted by amount
            System.out.println("\n=== Missions Sorted by Amount ===");
            freelance.getMissionsTrieesParMontant().forEach(m -> 
                System.out.println(m + " - Amount: " + m.calculerMontant())
            );

            // Remove finished missions
            freelance.supprimerMissionsTerminees();
            System.out.println("\nAfter removing finished missions:");
            freelance.getMissionsEnCours().forEach(System.out::println);

        } catch (DateInvalideException e) {
            System.out.println("Error creating mission: " + e.getMessage());
        }
    }
}
