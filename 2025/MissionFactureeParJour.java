import java.time.LocalDate;

public class MissionFactureeParJour extends Mission {
    private double tauxJournalier;
    private int nbJoursPrevus;

    public MissionFactureeParJour(String intitule, LocalDate debut, LocalDate fin,
                                  Statut statut, Client client, double taux, int nbJours)
                                  throws DateInvalideException {
        super(intitule, debut, fin, statut, client);
        this.tauxJournalier = taux;
        this.nbJoursPrevus = nbJours;
    }

    @Override
    public double calculerMontant() {
        return tauxJournalier * nbJoursPrevus;
    }
}
