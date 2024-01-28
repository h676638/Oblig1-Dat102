package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;


import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;


public class Meny {
	
		private Tekstgrensesnitt tekstgr;
		private FilmarkivADT filmarkiv;

		public Meny(FilmarkivADT filmarkiv) {
			tekstgr = new Tekstgrensesnitt();
			this.filmarkiv = filmarkiv;
		}
		public void start() {
			filmarkiv.leggTilFilm(new Film(0, "Direktør", "Film", 2024, Sjanger.DRAMA, "Selskap1"));
		 	filmarkiv.leggTilFilm(new Film(1, "Direktør", "Film", 2024, Sjanger.DRAMA, "Selskap1"));
			// legg inn en del forhåndsdefinerte filmer for å teste metodene

			boolean exit = false;
			while (!exit) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("1: Arkiver en ny film");
				System.out.println("2: Slett en eksisterende film");
				System.out.println("3: Søk for en eksisterende film via tittel");
				System.out.println("4: Søk for en eksisterende film via produsent");
				System.out.println("5: Skriv ut statistikk");
				System.out.println("0: Avslutt programmet");
				String valg = scanner.nextLine();

				switch(valg) {
					case "1":
						Film nyFilm = tekstgr.lesFilm(filmarkiv);
						filmarkiv.leggTilFilm(nyFilm);
						break;

					case "2":
						if (tekstgr.slettFilm(filmarkiv)) {
							System.out.println("Film er selettet");
						}
						else {
							System.out.println("Film er ikke funnet");
						}
						break;

					case "3":
						System.out.println("Søk delstrengen du vil søke");
						tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, scanner.nextLine());
						break;

					case "4":
						System.out.println("Skriv produsent du vil søke etter");
						tekstgr.skrivUtFilmProdusent(filmarkiv, scanner.nextLine());
						break;
					case "5":
						tekstgr.skrivUtStatistikk(filmarkiv);
						break;

					case "0":
						exit = true;
						System.out.println("Progaramet avsluttes");
						break;
					default:
						System.out.println("Ugydig forsøl. Prøv igjen!");
			 	}
			}
		}
	}


