package sk.akr.fiit.aass.txscript.dataservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class PoplatokDataService {

    private static final Logger log = LogManager.getLogger();

    public long vytvorPoplatok(long idOperacie, long idSadzby, BigDecimal vyskaPoplatku) {
        log.info("Vkladam poplatok pre operaciu {}, vyska {}, sadzba {} do databazy.", idOperacie, vyskaPoplatku, idSadzby);
        // vlozenie vypocitaneho poplatku do databazy
        return 1L;
    }
}
