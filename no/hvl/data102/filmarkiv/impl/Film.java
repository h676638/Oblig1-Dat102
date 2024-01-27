package no.hvl.data102.filmarkiv.impl;


import java.util.Objects;

public class Filmm {





    @Override
    public int hashCode() {
        return Objects.hash(filmProdusent, filmSelskap, filmTittel, laseringsÅr, serieNummer, sjanger);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Filmm other = (Filmm) obj;
        return Objects.equals(filmProdusent, other.filmProdusent) && Objects.equals(filmSelskap, other.filmSelskap)
                && Objects.equals(filmTittel, other.filmTittel) && laseringsÅr == other.laseringsÅr
                && serieNummer == other.serieNummer && Objects.equals(sjanger, other.sjanger);
    }
    public void setSerieNummer(int serieNummer) {
        this.serieNummer = serieNummer;
    }
    public String getFilmProdusent() {
        return filmProdusent;
    }
    public void setFilmProdusent(String filmProdusent) {
        this.filmProdusent = filmProdusent;
    }
    public String getFilmTittel() {
        return filmTittel;
    }
    public void setFilmTittel(String filmTittel) {
        this.filmTittel = filmTittel;
    }
    public int getLaseringsÅr() {
        return laseringsÅr;
    }
    public void setLaseringsÅr(int laseringsÅr) {
        this.laseringsÅr = laseringsÅr;
    }
    public String getSjanger() {
        return sjanger;
    }
    public void setSjanger(String sjanger) {
        this.sjanger = sjanger;
    }
    public String getFilmSelskap() {
        return filmSelskap;
    }
    public void setFilmSelskap(String filmSelskap) {
        this.filmSelskap = filmSelskap;
    }
    private  int serieNummer;
    private  String filmProdusent;
    private String filmTittel;
    private int laseringsÅr;
    private String sjanger;
    private String filmSelskap;



    public void Film() {

    }
    public void Flim(int serieNummer, String filmProdusent, String filmTittel, int lanseringsÅr, String  sjanger, String filmSelskap) {
        this.serieNummer = serieNummer;
        this.filmProdusent = filmProdusent;
        this.filmTittel = filmTittel;
        this.laseringsÅr = lanseringsÅr;
        this.sjanger = sjanger;
        this.filmSelskap = filmSelskap;
    }


}

