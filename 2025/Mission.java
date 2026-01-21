import java.time.LocalDate;

public abstract class Mission implements Comparable<Mission> {
    protected String intitule;
    protected LocalDate dateDebut;
    protected LocalDate dateFinEstimee;
    protected Statut statut;
    protected Client client;

    public Mission(String intitule, LocalDate dateDebut, LocalDate dateFinEstimee,
                   Statut statut, Client client) throws DateInvalideException {
        if (dateDebut.isAfter(dateFinEstimee)) {
            throw new DateInvalideException("Start date cannot be after estimated end date.");
        }
        this.intitule = intitule;
        this.dateDebut = dateDebut;
        this.dateFinEstimee = dateFinEstimee;
        this.statut = statut;
        this.client = client;
    }

    public abstract double calculerMontant();

    public LocalDate getDateDebut() { return dateDebut; }
    public Client getClient() { return client; }

    @Override
    public int compareTo(Mission autre) {
        return this.dateDebut.compareTo(autre.getDateDebut());
    }

    @Override
    public String toString() {
        return intitule + " (" + statut + ") - Client: " + client;
    }
}
