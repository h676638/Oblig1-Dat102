package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilmarkivTest {
    @Test
    public void testFilmarkiv() {
        Filmarkiv arkiv = new Filmarkiv(10);
        Film film1 = new Film(1, "Christopher Nolan", "Oppenheimer", 2023, Sjanger.DRAMA, "Syncopy");
        arkiv.leggTilFilm(film1);
        assertEquals(film1, arkiv.finnFilm(1));
    }
}
