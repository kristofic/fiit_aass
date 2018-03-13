package sk.akr.fiit.aass.domainmodel.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OperaciaTO {

    private String typ;
    private LocalDate datum;
    private BigDecimal suma;
    private String protiucetIban;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }

    public String getProtiucetIban() {
        return protiucetIban;
    }

    public void setProtiucetIban(String protiucetIban) {
        this.protiucetIban = protiucetIban;
    }

    @Override
    public String toString() {
        return "OperaciaTO{" +
                "typ='" + typ + '\'' +
                ", datum=" + datum +
                ", suma=" + suma +
                ", protiucetIban='" + protiucetIban + '\'' +
                '}';
    }
}
