package no.hvl.data102.filmarkiv.impl;

public class Filmarkiv implements FilmarkivADT {
    private Film[] films;
    private int count;

    public Filmarkiv(int capacity) {
        films = new Film[capacity];
        count = 0;
            }
    public Film finnFilm(int nr) {
        for (int i = 0; i < count; i++) {
            if (films[i].getNummer() == nr) { // Assuming Film has getNummer() method
                return films[i];
            }
        }
        return null;
    }
    public void leggTilFilm(Film nyFilm) {
        if (count == films.length) {
            expand();
        }
        films[count] = nyFilm;
        count++;
    }
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
    public Film[] soekTittel(String delstreng) {
        Film[] result = new Film[count];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getTittel().contains(delstreng)) {
                result[found++] = films[i];
            }
        }
        return trimArray(result);
    }
    public Film[] soekProdusent(String delstreng) {
        Film[] result = new Film[count];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getProdusent().contains(delstreng)) {
                result[found++] = films[i];
            }
        }
        return trimArray(result);
    }
    public int antall(Sjanger sjanger) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (films[i].getSjanger().equals(sjanger)) {
                total++;
            }
        }
        return total;
    }
    public int antall() {
        return count;
    }



