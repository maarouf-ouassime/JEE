package pres;
import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Pres1 {
    public static void main(String[] args) {
        /*
         * Injection des dependances par
         * instantiation statique
         */
        /*
            DaoImpl dao = new DaoImpl();
            MetierImpl metier = new MetierImpl();
            metier.setDao(dao);
            System.out.println(metier.calcule());
        */
        try{
            Scanner scanner = new Scanner(new File("config.txt"));

            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.newInstance();

            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier =(IMetier) cMetier.newInstance();

            Method method = cMetier.getMethod("setDao",IDao.class);
            method.invoke(metier,dao);
            System.out.println(metier.calcul());


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //System.out.println(metier.calcule());
    //System.out.println(dao.getData());
    //System.out.printf(daoClassName);


}
