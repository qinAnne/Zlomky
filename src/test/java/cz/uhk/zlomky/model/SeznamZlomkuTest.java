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
    void odebratZlomek() {
        seznam.pridatZlomek(new Zlomek(3,5));
        seznam.odebratZlomek(0);
        assertEquals(0, seznam.pocetZlomku(), "Pocet zlomku");
        Zlomek z;
        if (seznam.pocetZlomku()>0){
            z = seznam.vybratZlomek(0);
        }
        else{
            z = null;
            assertNull(z, "Zlomek by mel byt null");
        }
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
    void spoctiSoucet() {
        fail("Not yet implemented");
    }

    @Test
    void spoctiPrumer() {
        fail("Not yet implemented");
    }
}