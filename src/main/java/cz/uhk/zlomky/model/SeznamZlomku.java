package cz.uhk.zlomky.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SeznamZlomku {
    private List<Zlomek> zlomky = new ArrayList<>();

    public void pridatZlomek(Zlomek zlomek) {
        if(zlomek != null) {
            zlomky.add(zlomek);
        }
        else {
            throw new NullPointerException("Zlomek null");
        }
    }
    public void odebratZlomek(int index) throws IndexOutOfBoundsException {
        if(zlomky.isEmpty() && index == 0)
        {
            return;
        }
        zlomky.remove(index);
    }
    public Zlomek vybratZlomek(int index) throws IndexOutOfBoundsException {
        return zlomky.get(index);
    }
    public void vypisZlomky(PrintStream out){
        for (int i = 0; i < zlomky.size(); i++) {
            out.printf("[%d]=>%s\n", i+1, zlomky.get(i));
        }
    }
    public Zlomek spoctiSoucet() {
        if (zlomky.isEmpty()) {
            return new Zlomek(0, 1); // Vrátíme 0/1 místo 0/0
        }
        Zlomek suma = new Zlomek(0,1);

        for (Zlomek z : zlomky) {
            suma = suma.plus(z);
        }

        // Ochrana proti 0/0
        if (suma.getCitatel() == 0) {
            return new Zlomek(0, 1);
        }

        return suma.zkratit();
    }
    public Zlomek spoctiPrumer(){
        Zlomek suma = spoctiSoucet();
        Zlomek pocet = new Zlomek(zlomky.size(),1);

        if (suma.getCitatel() == 0) {
            return new Zlomek(0, 1);
        }
        return suma.deleno(pocet).zkratit(); //suma/pocet
    }
    public int pocetZlomku(){
        return zlomky.size();
    }
}
