package cdpoo.TD2.exo13;

public class FabriqueVehiculeEssence implements FabriqueVehicule{

    @Override
    public void FabriqueAutomobile(Automobile automobile) {
        automobile = new AutomobileEssence(0, 0, null, null);
       
    }

    @Override
    public void FabriqueScooter(Scooter scooter) {
        scooter = new ScooterEssence(0, null, null);
       
    }
    
}
