package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilmarkivTest {
    @Test
    public void testFilmarkivExpand() {
        Filmarkiv arkiv = new Filmarkiv(1);
        Film film1 = new Film();
        Film film2 = new Film();
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        assertEquals(2,arkiv.antall());
    }
    @Test
    public void testFilmarkivFinnFilm() {
        Filmarkiv arkiv = new Filmarkiv(1);
        Film film1 = new Film(1, "Christopher Nolan", "Oppenheimer", 2023, Sjanger.DRAMA, "Syncopy");
        Film film2 = new Film();
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        assertEquals(film1, arkiv.finnFilm(1));
    }
}
