package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

// vzor Strategia - oddelenie algoritmu vypoctu od dat
public enum PoplatkovaFunkcia {

    POPLATOK_FIXNY {
        public BigDecimal vypocitajPoplatok(SadzbaPoplatku sadzba, BigDecimal sumaOperacie) {
            log.info("Vypocet vysky poplatku pre sumu operacie {} so sadzbou {}", sumaOperacie, sadzba);
            return sadzba.getSadzba();
        }
    },

    POPLATOK_PERCENTUALNY {
        public BigDecimal vypocitajPoplatok(SadzbaPoplatku sadzba, BigDecimal sumaOperacie) {
            log.info("Vypocet vysky poplatku pre sumu operacie {} so sadzbou {}", sumaOperacie, sadzba);
            return sumaOperacie.multiply(sadzba.getSadzba());
        }
    };

    public abstract BigDecimal vypocitajPoplatok(SadzbaPoplatku sadzba, BigDecimal sumaOperacie);

    private static final Logger log = LogManager.getLogger();
}
