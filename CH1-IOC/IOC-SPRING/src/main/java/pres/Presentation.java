package pres;

import ext.DaoImplVC;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        // v1 ==> DaoImpl dao = new DaoImpl();

        /*
        * injection de dependances par instanciation statique => new
        */
        DaoImplVC dao = new DaoImplVC();

        MetierImpl metier = new MetierImpl(dao);
        metier.setDao(dao);
        System.out.println("Resultat = "+metier.calcul());
    }
}
