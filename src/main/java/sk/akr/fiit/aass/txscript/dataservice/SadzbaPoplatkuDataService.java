package sk.akr.fiit.aass.txscript.dataservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.akr.fiit.aass.txscript.datamodel.SadzbaPoplatku;
import sk.akr.fiit.aass.txscript.datamodel.SadzbaPoplatku.SposobVypoctu;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SadzbaPoplatkuDataService {

    public SadzbaPoplatku najdiSadzbu(String kodPoplatku, LocalDate datum, BigDecimal suma) {
        log.info("Vyhladavam sadzbu pre poplatok {}, datum {}, suma {}", kodPoplatku, datum, suma);
        // vyhladanie sadzby poplatku v databaze podla kriterii
        return new SadzbaPoplatku(
            1L,
            new BigDecimal("5.0"),
            SposobVypoctu.FIXNY,
            null,
            null,
            new BigDecimal("0"),
            new BigDecimal("1000"),
            LocalDate.now().minusDays(1),
            LocalDate.now().plusDays(1)
        );
    }

    private static final Logger log = LogManager.getLogger();
}
