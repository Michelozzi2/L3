package cdpoo.TD2.exo13;

public class FabriqueVehiculeElectrique implements FabriqueVehicule {

    @Override
    public void FabriqueAutomobile(Automobile automobile) {
        automobile = new AutomobileElectricite(0, 0, null, null);
    }

    @Override
    public void FabriqueScooter(Scooter scooter) {
        scooter = new ScooterElectricite(0, null, null);
       
    }
    

}