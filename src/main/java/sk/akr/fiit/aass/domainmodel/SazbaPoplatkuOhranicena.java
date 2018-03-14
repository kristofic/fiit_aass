package sk.akr.fiit.aass.domainmodel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SazbaPoplatkuOhranicena extends SadzbaPoplatku {

    private BigDecimal minSadzba;
    private BigDecimal maxSadzba;

    protected BigDecimal vypocitajVyskuPoplatku(Operacia operacia) {
        BigDecimal vyskaPoplatku = super.vypocitajVyskuPoplatku(operacia);
        if (vyskaPoplatku.compareTo(minSadzba) < 0) {
            return minSadzba;
        } else if (vyskaPoplatku.compareTo(maxSadzba) > 0) {
            return maxSadzba;
        } else {
            return vyskaPoplatku;
        }
    }

    public SazbaPoplatkuOhranicena(BigDecimal sadzba, PoplatkovaFunkcia poplatkovaFunkcia, LocalDate platnostOd, LocalDate platnostDo, BigDecimal minSadzba, BigDecimal maxSadzba) {
        super(sadzba, poplatkovaFunkcia, platnostOd, platnostDo);
        this.minSadzba = minSadzba;
        this.maxSadzba = maxSadzba;
    }
}
