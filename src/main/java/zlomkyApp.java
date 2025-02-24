import cz.uhk.zlomky.model.Zlomek;

import java.util.Arrays;

public class zlomkyApp {
    public static void main(String[] args) {
        System.out.println("ZlomkoAplikace");

        //vytvoření instance(=objektu) tridy Zlomek
        Zlomek a = new Zlomek(3,4);
        System.out.printf("Zlomek a =%s\n", a.toString());

        Zlomek b = new Zlomek(2,5);
        Zlomek c = a.krat(b);
        System.out.printf("Zlomek a*b = %s\n", c.zkratit());
        System.out.printf("Zlomek a/b = %s\n", a.deleno(b).zkratit());
        System.out.printf("Zlomek a+b = %s\n", a.plus(b));
        System.out.printf("Zlomek a-b = %s\n", a.minus(b));

        Zlomek[] poleZlomku = new Zlomek[4];
        poleZlomku[0] = a;
        poleZlomku[1] = b;
        poleZlomku[2] = c;
        poleZlomku[3] = new Zlomek(3,0);

        try {
            Zlomek all = sumaZlomku(poleZlomku);
            System.out.printf("Soucet je %s\n", all);
        } catch (ArithmeticException e) {
            System.out.println("Chyba při výpočtu sumy zlomků: "+e.getMessage());
        }
        Number[] pole2 = new Number[8];
        for (int i = 0; i < poleZlomku.length; i++) {
            pole2[i] = poleZlomku[i];
        }
        pole2 [4] = 10;
        pole2 [5] = 20;
        pole2 [6] = 30.025;
        pole2 [7] = 40;
        double suma = 0;
        for(Number n : pole2) {
            System.out.printf("%s\n", suma);
            suma += n.doubleValue();
        }
    }

    public static Zlomek sumaZlomku(Zlomek[] pole) {
        Zlomek soucet = new Zlomek(0,1);
        for (Zlomek z : pole) {
            soucet = soucet.plus(z); //soucet += z;
        }
        return soucet;
    }
}
