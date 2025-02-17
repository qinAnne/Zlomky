import cz.uhk.zlomky.model.Zlomek;

public class zlomkyApp {
    public static void main(String[] args) {
        System.out.println("ZlomkoAplikace");

        //vytvoření instance(=objektu) tridy Zlomek
        Zlomek a = new Zlomek(3,4);
        System.out.printf("Zlomek a =%s\n", a.toString());
    }
}
