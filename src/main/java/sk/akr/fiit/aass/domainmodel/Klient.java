package sk.akr.fiit.aass.domainmodel;

import sk.akr.fiit.aass.domainmodel.to.OperaciaTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Klient {

    public static void main(String [] args) {
        // volanie domenoveho objektu prezentacnej vrstvy / frontendu
        OperaciaTO operacia = new OperaciaTO();
        operacia.setTyp("PREVOD");
        operacia.setSuma(new BigDecimal("100"));
        operacia.setDatum(LocalDate.now());
        operacia.setProtiucetIban("SK7402000000001111111111");

        Operacia.vytvorOperaciu(operacia);
    }
}
