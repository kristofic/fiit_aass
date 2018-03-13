package sk.akr.fiit.aass.txscript;

import sk.akr.fiit.aass.to.OperaciaTO;
import sk.akr.fiit.aass.txscript.datamodel.SadzbaPoplatku;

import java.math.BigDecimal;

public class PoplatkyService {
    public BigDecimal vypocitajPoplatok(SadzbaPoplatku sadzba, OperaciaTO operaciaTO) {
        switch (sadzba.getSposobVypoctu()) {

            case FIXNY:
                return sadzba.getSadzba();

            case PERCENTUALNY:
                return operaciaTO.getSuma().multiply(sadzba.getSadzba());

            case PERCENTUALNY_OHRAN:
                BigDecimal vyskaPoplatku =  operaciaTO.getSuma().multiply(sadzba.getSadzba());
                if (vyskaPoplatku.compareTo(sadzba.getMinSadzba()) < 0) {
                    return sadzba.getMinSadzba();
                } else if (vyskaPoplatku.compareTo(sadzba.getMaxSadzba()) > 0) {
                    return sadzba.getMaxSadzba();
                } else {
                    return vyskaPoplatku;
                }

            default:
                throw new IllegalArgumentException("Neznamy sposob vypoctu poplatku");
        }
    }
}
