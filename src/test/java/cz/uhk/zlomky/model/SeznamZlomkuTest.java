package cz.uhk.zlomky.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SeznamZlomkuTest {
    SeznamZlomku seznam;

    @BeforeEach
    void setUp() {
        seznam = new SeznamZlomku();
    }

    @Test
    @DisplayName("Test pridavani")
    void pridatZlomek() {
        seznam.pridatZlomek(new Zlomek(3,5));
        assertEquals(1,seznam.pocetZlomku(), "Pocet zlomku");
        Zlomek z = seznam.vybratZlomek(0);
        assertEquals(3, z.getCitatel(),"Citatel");
        assertEquals(5, z.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test pridavani null")
    void pridatZlomekNull(){
        assertThrows(NullPointerException.class, () -> seznam.pridatZlomek(null));
    }

    @Test
    @DisplayName("Test odebirani z prazdneho seznamu")
    void odebratZlomekPrazdnySeznam() {
        seznam.odebratZlomek(0);
        assertEquals(0, seznam.pocetZlomku(), "Pocet zlomku");
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vybratZlomek(0));
    }

    @Test
    @DisplayName("Test odebirani - posledni prvek")
    void odebratZlomekPosledni() {
        seznam.pridatZlomek(new Zlomek(3,5));
        seznam.pridatZlomek(new Zlomek(3,4));
        seznam.pridatZlomek(new Zlomek(3,6));
        seznam.odebratZlomek(2);
        assertEquals(2, seznam.pocetZlomku(), "Pocet zlomku");
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vybratZlomek(2));
    }

    @Test
    @DisplayName("Test odebirani - prvni prvek")
    void odebratZlomekPrvni() {
        seznam.pridatZlomek(new Zlomek(3,5));
        seznam.pridatZlomek(new Zlomek(3,4));
        seznam.pridatZlomek(new Zlomek(3,6));
        seznam.odebratZlomek(0);
        assertEquals(2, seznam.pocetZlomku(), "Pocet zlomku");
        Zlomek prvni = seznam.vybratZlomek(0);
        assertEquals(3, prvni.getCitatel(), "Čitatel prvního zlomku");
        assertEquals(4, prvni.getJmenovatel(), "Jmenovatel prvního zlomku");
    }

    @Test
    void vybratZlomek() {
        seznam.pridatZlomek(new Zlomek(3,5));
        Zlomek z = seznam.vybratZlomek(0);

    }

    @Test
    void vybratZlomekZPrazdneho() {
        assertThrows(IndexOutOfBoundsException.class, () -> seznam.vybratZlomek(0));
    }

    @Test
    void vypisZlomky() {
        fail("Not yet implemented");
    }

    @Test
    @DisplayName("Test scitani")
    void spoctiSoucet() {
        seznam.pridatZlomek(new Zlomek(2,5));
        seznam.pridatZlomek(new Zlomek(1,3));
        Zlomek soucet = seznam.spoctiSoucet();
        assertEquals(11, soucet.getCitatel(), "Citatel");
        assertEquals(15, soucet.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test scitani - prazdny seznam")
    void spoctiSoucetPrazdnySeznam() {
        Zlomek soucet = seznam.spoctiSoucet();
        assertEquals(0, soucet.getCitatel(), "Citatel");
        assertEquals(1, soucet.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test scitani - nulový seznam")
    void spoctiSoucetNulovySeznam() {
        seznam.pridatZlomek(new Zlomek(0,5));
        seznam.pridatZlomek(new Zlomek(0,6));
        seznam.pridatZlomek(new Zlomek(0,4));
        Zlomek soucet = seznam.spoctiSoucet();
        assertEquals(0, soucet.getCitatel(), "Citatel");
        assertEquals(1, soucet.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test vypoctu prumeru")
    void spoctiPrumer() {
        seznam.pridatZlomek(new Zlomek(2,5));
        seznam.pridatZlomek(new Zlomek(1,3));
        Zlomek soucet = seznam.spoctiPrumer();
        assertEquals(11, soucet.getCitatel(), "Citatel");
        assertEquals(30, soucet.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test vypoctu prumeru - prazdneho seznamu")
    void spoctiPrumerPrazdnySeznam() {
        Zlomek soucet = seznam.spoctiPrumer();
        assertEquals(0, soucet.getCitatel(), "Citatel");
        assertEquals(1, soucet.getJmenovatel(), "Jmenovatel");
    }

    @Test
    @DisplayName("Test vypoctu prumeru - nuloveho seznamu")
    void spoctiPrumerNulovySeznam() {
        seznam.pridatZlomek(new Zlomek(0,5));
        seznam.pridatZlomek(new Zlomek(0,3));
        Zlomek soucet = seznam.spoctiPrumer();
        assertEquals(0, soucet.getCitatel(), "Citatel");
        assertEquals(1, soucet.getJmenovatel(), "Jmenovatel");
    }
}