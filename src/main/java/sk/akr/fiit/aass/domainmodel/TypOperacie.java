package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class TypOperacie {

    private String kod;
    private Set<TypPoplatku> typyPoplatkov;

    public static TypOperacie najdiTypOperacie(String kod) {
        // vyhladanie v databaze
        log.info("Vyhladanie typu operacie pre kod {}", kod);
        return new TypOperacie(kod, TypPoplatku.najdiTypyPoplatkov(kod));
    }

    public void vypocitajPoplatky(Operacia operacia) {
        log.info("Vypocet poplatkov pre operaciu {}", operacia);
        for (TypPoplatku typPoplatku : getTypyPoplatkov()) {
            typPoplatku.vypocitajPoplatok(operacia);
        }
    }

    private TypOperacie(String kod, Set<TypPoplatku> typyPoplatkov) {
        this.kod = kod;
        this.typyPoplatkov = typyPoplatkov;
    }

    public Set<TypPoplatku> getTypyPoplatkov() {
        return typyPoplatkov;
    }

    @Override
    public String toString() {
        return "TypOperacie{" +
                "kod='" + kod + '\'' +
                '}';
    }

    private static final Logger log = LogManager.getLogger();
}
