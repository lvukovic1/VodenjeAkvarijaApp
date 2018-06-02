package com.akvarij.ldk.main.financije;

public class BZVZ1 {
    private String naziv;
    private String cijena;

    public BZVZ1(String naziv, String cijena) {
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }
}
