package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] films;
    private int count;

    public Filmarkiv(int capacity) {
        films = new Film[capacity];
        count = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < count; i++) {
            if (films[i].getNummer() == nr) {
                return films[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (count == films.length) {
            expand();
        }
        films[count] = nyFilm;
        count++;
    }

    private void expand() {
        Film[] newFilms = new Film[films.length * 2];
        System.arraycopy(films, 0, newFilms, 0, films.length);
        films = newFilms;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < count; i++) {
            if (films[i].getNummer() == filmnr) {
                System.arraycopy(films, i + 1, films, i, count - i - 1);
                films[--count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] temp = new Film[films.length];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getTittel().contains(delstreng)) {
                temp[found++] = films[i];
            }
        }
        return trimTab(temp, found);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] temp = new Film[films.length];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getProdusent().contains(delstreng)) {
                temp[found++] = films[i];
            }
        }
        return trimTab(temp, found);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getSjanger().equals(sjanger)) {
                total++;
            }
        }
        return total;
    }

    @Override
    public int antall() {
        return count;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        for (int i = 0; i < n; i++) {
            nytab[i] = tab[i];
        }
        return nytab;
    }
}
