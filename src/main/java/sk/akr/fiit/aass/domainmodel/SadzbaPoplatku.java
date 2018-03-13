package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

// Domenova trieda pre sadzbu poplatku
public class SadzbaPoplatku {

    private BigDecimal sadzba;
    private PoplatkovaFunkcia poplatkovaFunkcia;
    private LocalDate platnostOd;
    private LocalDate platnostDo;

    public static Set<SadzbaPoplatku> najdiSadzby(String typPoplatku) {
        // vyhladanie sadzieb pre typ poplatku v databaze
        log.info("Vyhladanie sadzieb pre typ poplatku {}", typPoplatku);

        if ("POPL1".equals(typPoplatku)) {
            return Collections.singleton(new SadzbaPoplatku(
                    new BigDecimal("5.0"),
                    PoplatkovaFunkcia.POPLATOK_FIXNY,
                    LocalDate.now().minusDays(1),
                    LocalDate.now().plusDays(1)
            ));
        } else {
            return Collections.singleton(new SazbaPoplatkuOhranicena (
                    new BigDecimal("15.0"),
                    PoplatkovaFunkcia.POPLATOK_PERCENTUALNY,
                    LocalDate.now().minusDays(1),
                    LocalDate.now().plusDays(1),
                    new BigDecimal("1.0"),
                    new BigDecimal("3.0")
            ));
        }
    }

    public void vypocitajPoplatok(Operacia operacia) {
        log.info("Vypocet poplatku pre operaciu {}", operacia);
        BigDecimal vyskaPoplatku = vypocitajVyskuPoplatku(operacia);
        operacia.addPoplatok(new Poplatok(vyskaPoplatku, this, operacia));
    }

    protected BigDecimal vypocitajVyskuPoplatku(Operacia operacia) {
        return getPoplatkovaFunkcia().vypocitajPoplatok(this, operacia.getSuma());
    }

    public boolean jeAplikovatelna(Operacia operacia) {
        return operacia.getDatum().isAfter(getPlatnostOd()) && operacia.getDatum().isBefore(getPlatnostDo());
    }

    public SadzbaPoplatku(BigDecimal sadzba, PoplatkovaFunkcia poplatkovaFunkcia, LocalDate platnostOd, LocalDate platnostDo) {
        this.sadzba = sadzba;
        this.poplatkovaFunkcia = poplatkovaFunkcia;
        this.platnostOd = platnostOd;
        this.platnostDo = platnostDo;
    }

    public LocalDate getPlatnostOd() {
        return platnostOd;
    }

    public LocalDate getPlatnostDo() {
        return platnostDo;
    }

    public BigDecimal getSadzba() {
        return sadzba;
    }

    public PoplatkovaFunkcia getPoplatkovaFunkcia() {
        return poplatkovaFunkcia;
    }

    @Override
    public String toString() {
        return "SadzbaPoplatku{" +
                "sadzba=" + sadzba +
                ", poplatkovaFunkcia=" + poplatkovaFunkcia +
                ", platnostOd=" + platnostOd +
                ", platnostDo=" + platnostDo +
                '}';
    }

    private static final Logger log = LogManager.getLogger();
}
