import java.util.*;
import java.util.stream.*;

public class Freelance {
    private String nom;
    private Map<Client, List<Mission>> missionsParClient = new HashMap<>();

    public Freelance(String nom) {
        this.nom = nom;
    }

    // Add a mission
    public void ajouterMission(Mission m) {
        missionsParClient
            .computeIfAbsent(m.getClient(), k -> new ArrayList<>())
            .add(m);
    }

    // Remove all finished missions
    public void supprimerMissionsTerminees() {
        for (List<Mission> missions : missionsParClient.values()) {
            missions.removeIf(m -> m.statut == Statut.TERMINEE);
        }
    }

    // Total revenue across all clients
    public double getTotalRevenu() {
        return missionsParClient.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Mission::calculerMontant)
                .sum();
    }

    // Total billed for a specific client
    public double getMontantFactureParClient(Client client) {
        List<Mission> missions = missionsParClient.get(client);
        if (missions == null) return 0.0;
        return missions.stream()
                       .mapToDouble(Mission::calculerMontant)
                       .sum();
    }

    // All missions currently in progress
    public List<Mission> getMissionsEnCours() {
        return missionsParClient.values().stream()
                .flatMap(List::stream)
                .filter(m -> m.statut == Statut.EN_COURS)
                .collect(Collectors.toList());
    }

    // All missions sorted by amount
    public List<Mission> getMissionsTrieesParMontant() {
        return missionsParClient.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingDouble(Mission::calculerMontant))
                .collect(Collectors.toList());
    }

    // Display the type of each mission
    public void afficherTypeDeMission() {
        missionsParClient.values().stream()
            .flatMap(List::stream)
            .forEach(m -> {
                if (m instanceof MissionFactureeAuLivrable) {
                    System.out.println(m.intitule + " → Billed per deliverable");
                } else if (m instanceof MissionFactureeParJour) {
                    System.out.println(m.intitule + " → Billed per day");
                } else {
                    System.out.println(m.intitule + " → Unknown type");
                }
            });
    }
}

