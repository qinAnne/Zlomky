package cz.uhk.zlomky.app;

import cz.uhk.zlomky.model.SeznamZlomku;
import cz.uhk.zlomky.model.Zlomek;

public class SeznamZlomkuApp {
    public static void main(String[] args){
        SeznamZlomku seznam = new SeznamZlomku();

        seznam.pridatZlomek(new Zlomek(1,2));
        seznam.pridatZlomek(new Zlomek(2,3));
        seznam.pridatZlomek(new Zlomek(4,5));
        seznam.pridatZlomek(new Zlomek(7,8));

        seznam.vypisZlomky(System.out);

        //suma
        Zlomek soucet = seznam.spoctiSoucet();
        System.out.println("Soucet zlomku je " + soucet);
        System.out.println("Soucet zlomku realně je " + soucet.doubleValue());
        //aritm. prumer
        Zlomek prumer = seznam.spoctiPrumer();
        System.out.println("Prumer zlomku je " + prumer);
        System.out.println("Prumer zlomku realně je " + prumer.doubleValue());
    }
}
