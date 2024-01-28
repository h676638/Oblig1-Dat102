package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int count;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.start = null;
        this.count = 0;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> newNode = new LinearNode<>(nyFilm);
        newNode.next = start;
        start = newNode;
        count++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> current = start;
        LinearNode<Film> previous = null;

        while (current != null) {
            if (current.data.getNummer() == filmnr) {
                if (previous == null) {
                    start = current.next;
                } else {
                    previous.next = current.next;
                }
                count--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getNummer() == nr) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] temp = new Film[count];
        int found = 0;

        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getTittel().contains(delstreng)) {
                temp[found++] = current.data;
            }
            current = current.next;
        }

        return trimTab(temp, found);
    }


    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] temp = new Film[count];
        int found = 0;

        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getProdusent().contains(delstreng)) {
                temp[found++] = current.data;
            }
            current = current.next;
        }

        return trimTab(temp, found);
    }


    @Override
    public int antall(Sjanger sjanger) {
        int total = 0;
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getSjanger().equals(sjanger)) {
                total++;
            }
            current = current.next;
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