import cz.uhk.zlomky.model.Zlomek;

public class zlomkyApp {
    public static void main(String[] args) {
        System.out.println("ZlomkoAplikace");

        //vytvoření instance(=objektu) tridy Zlomek
        Zlomek a = new Zlomek(3,4);
        System.out.printf("Zlomek a =%s\n", a.toString());

        Zlomek b = new Zlomek(2,5);
        Zlomek c = a.krat(b);
        System.out.printf("Zlomek a*b = %s\n", c.zkratit());
        System.out.printf("Zlomek a/b = %s\n", a.deleno(b));
        System.out.printf("Zlomek a+b = %s\n", a.plus(b));
        System.out.printf("Zlomek a-b = %s\n", a.minus(b));
    }
}
