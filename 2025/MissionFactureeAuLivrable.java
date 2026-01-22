import java.time.LocalDate;

public class MissionFactureeAuLivrable extends Mission {
    private double montantFixe;

    public MissionFactureeAuLivrable(String intitule, LocalDate debut, LocalDate fin,
                                     Statut statut, Client client, double montantFixe)
                                     throws DateInvalideException {
        super(intitule, debut, fin, statut, client);
        this.montantFixe = montantFixe;
    }

    @Override
    public double calculerMontant() { return montantFixe; }
}
