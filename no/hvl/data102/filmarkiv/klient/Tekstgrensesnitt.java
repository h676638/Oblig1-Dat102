package no.hvl.data102.filmarkiv.klient;


import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(FilmarkivADT arkiv) {
		Scanner scanner = new Scanner(System.in);
		int id = arkiv.antall();
		System.out.println("Film produsent: ");
		String prod = scanner.nextLine();
		System.out.println("Film tittel: ");
		String tittel = scanner.nextLine();
		System.out.println("Lanserings år");
		int lans = Integer.parseInt(scanner.nextLine());
		System.out.println("Film sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());
		System.out.println("Film selskap");
		String sels = scanner.nextLine();
		return new Film(id, prod, tittel, lans, sjanger, sels);
	}

public boolean slettFilm(FilmarkivADT arkiv) {
	Film[] filmer = arkiv.soekTittel("");
	for (Film each: filmer) {
		skrivUtFilm(each);
	}
	System.out.println("Velg en filmnummer du vil seltte det.");
	Scanner scanner = new Scanner(System.in);
	return arkiv.slettFilm(Integer.parseInt(scanner.nextLine()));
}

// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		int id = film.getSerieNummer();
		String tittel = film.getFilmTittel();
		int year = film.getLaseringsÅr();
		String prod = film.getFilmProdusent();
		String sels = film.getFilmSelskap();
		String sjanger = film.getSjanger().toString();
		System.out.println(id + " " + tittel + " " + year + " " + prod + " " + sels + " " + sjanger);
	}

// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		for (Film film: arkiv.soekTittel(delstreng)) {
			System.out.println(film.getFilmTittel());
		}
	}

// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		for (Film film : arkiv.soekProdusent(delstreng)) {
			System.out.println(film.getFilmTittel());
		}
	}
// Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Det er " + arkiv.antall() + " filmer totalt.");
		int drama = arkiv.antall(Sjanger.DRAMA);
		int action = arkiv.antall(Sjanger.ACTION);
		int history = arkiv.antall(Sjanger.HISTORY);
		int scifi = arkiv.antall(Sjanger.SCIFI);
		System.out.println("Drama: " + drama + "\nAction: " + action + "\nHistory: " + history + "\nScifi: " + scifi);
	}
}
// osv ... andre metoder
