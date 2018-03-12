package sk.akr.fiit.aass.txscript;

import sk.akr.fiit.aass.txscript.datamodel.OperaciaTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Klient {

    public static void main(String [] args) {
        // volanie transakcneho scenaru z prezentacnej vrstvy / frontendu
        OperaciaTO operacia = new OperaciaTO();
        operacia.setTyp("PREVOD");
        operacia.setSuma(new BigDecimal("100"));
        operacia.setDatum(LocalDate.now());
        operacia.setProtiucetIban("SK7402000000001111111111");

        new OperacieService().vytvorOperaciu(operacia);
    }
}
