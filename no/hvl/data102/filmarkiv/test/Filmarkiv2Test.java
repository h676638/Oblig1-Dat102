package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Filmarkiv2Test {

    @Test
    public void testFilmarkiv2AddAndCount() {
        Filmarkiv2 arkiv = new Filmarkiv2();
        Film film1 = new Film(1, "Christopher Nolan", "Oppenheimer", 2023, Sjanger.DRAMA, "Syncopy");
        Film film2 = new Film(2, "Jane Doe", "Another Movie", 2024, Sjanger.ACTION, "FilmCo");
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        assertEquals(2, arkiv.antall());
    }

    @Test
    public void testFilmarkiv2FindFilm() {
        Filmarkiv2 arkiv = new Filmarkiv2();
        Film film1 = new Film(1, "Christopher Nolan", "Oppenheimer", 2023, Sjanger.DRAMA, "Syncopy");
        Film film2 = new Film(2, "Yorgos Lanthimos", "Poor Things", 2023, Sjanger.ACTION, "FilmCo");
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        assertEquals(film1, arkiv.finnFilm(1));
    }
}
