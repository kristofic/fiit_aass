package sk.akr.fiit.aass.txscript.dataservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class TypPoplatkuDataService {

    public Set<String> najdiTypyPoplatkov(String typOperacie) {
        log.info("Vyhladavam typy poplatkov pre typ operacie {}", typOperacie);
        // vyhladanie typov poplatkov v databaze
        return new HashSet<>(asList("POPL1", "POPL2"));
    }

    private static final Logger log = LogManager.getLogger();
}
