package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmm;
import java.util.Scanner;

public class FilmarkivMain {

    public static void main(String[] args) {
        FilmarkivADT filma = new Filmarkiv(100);
        Meny meny = new Meny(filma);
        meny.start();
    }
}

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start() {
        filmarkiv.leggTilFilm(new Filmm( "Direktør", "Film", 2024, Sjanger.Dreama, "Selskap1"));
        filmarkiv.leggTilFilm(new Filmm( "Direktør", "Film", 2024, Sjanger.Dreama, "Selskap1"));
// legg inn en del forhåndsdefinerte filmer for å teste metodene




        boolean exit = false;
        while (!exit) {
            tekstgr.visHovedMeny();
            int valg = tekstgr.lesInt("Velg en film");



            switch(valg) {
                case 1:
                    Film nyFilm = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(nyFilm);
                    break;

                case 2:
                    int filmnr = tekstgr.lesInt("Velg en filmnummer du vil seltte det.");
                    boolean success = filmarkiv.slettFilm(filmnr);
                    if (success) {
                        System.out.println("Film er selettet");
                    }
                    else {
                        System.out.println("Film er ikke funnet");
                    }
                    break;


                case 3:
                    String delstreng = tekstgr.lesTekst("Søk delstrengen du vil søke");
                    Film[]prodresultater = filmarkiv.soekTittel(delstreng);
                    tekstgr.skrivUtFilmListe (prodresultater);
                    break;

                case 4:

                    String produsent = tekstgr.lesTekst("Skriv produsent du vil søke etter");
                    Film[] prodResultater = filmarkiv.soekProdusent(produsent);
                    tekstgr.skrivUtFilmListe(prodResultater);

                    break;


                case 5:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;



                case 0:

                    exit = true;
                    System.out.println("Progaramet avsluttes");
                    break;

                default:
                    System.out.println("Ugydig forsøl. Prøv igjen!");
            }

        }

    }

}

public class Tekstgrensesnitt {



    public Tekstgrensesnitt() {
        Scanner scanner = new Scanner(System.in);




    }



    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
// TODO
    }

    public int lesInt(String string) {
        // TODO Auto-generated method stub
        return 0;
    }''

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
// TODO
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
// TODO
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
// TODO
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
// TODO
    }
// osv ... andre metoder