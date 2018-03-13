package sk.akr.fiit.aass.domainmodel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SazbaPoplatkuHladinova extends SadzbaPoplatku {

    private BigDecimal sumaOperacieOd;
    private BigDecimal sumaOperacieDo;

    @Override
    public boolean jeAplikovatelna(Operacia operacia) {
        return super.jeAplikovatelna(operacia) &&
            operacia.getSuma().compareTo(sumaOperacieOd) > 0 &&
            operacia.getSuma().compareTo(sumaOperacieDo) < 0;
    }

    public SazbaPoplatkuHladinova(BigDecimal sadzba, PoplatkovaFunkcia poplatkovaFunkcia, LocalDate platnostOd, LocalDate platnostDo, BigDecimal sumaOperacieOd, BigDecimal sumaOperacieDo) {
        super(sadzba, poplatkovaFunkcia, platnostOd, platnostDo);
        this.sumaOperacieOd = sumaOperacieOd;
        this.sumaOperacieDo = sumaOperacieDo;
    }
}
