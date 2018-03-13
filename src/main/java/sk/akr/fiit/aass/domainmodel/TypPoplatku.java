package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;

public class TypPoplatku {

    private String kod;
    private Set<SadzbaPoplatku> sadzbyPoplatkov;

    public static Set<TypPoplatku> najdiTypyPoplatkov(String typOperacie) {
        // vyhladanie typov poplatkov v databaze
        log.info("Vyhladanie typov poplatkov pre operaciu {}", typOperacie);
        return new HashSet<>(asList(
            new TypPoplatku("POPL1", SadzbaPoplatku.najdiSadzby("POPL1")),
            new TypPoplatku("POPL2", SadzbaPoplatku.najdiSadzby("POPL2"))
        ));
    }

    public TypPoplatku(String kod, Set<SadzbaPoplatku> sadzbyPoplatkov) {
        this.kod = kod;
        this.sadzbyPoplatkov = sadzbyPoplatkov;
    }

    public void vypocitajPoplatok(Operacia operacia) {
        log.info("Vypocet poplatku pre operaciu {}", operacia);
        Optional<SadzbaPoplatku> sadzbaPoplatku = sadzbyPoplatkov
            .stream()
            .filter(sadzba -> sadzba.jeAplikovatelna(operacia))
            .findFirst();
        log.info("Nasla sa sadzba poplatku {} pre operaciu {}" , sadzbaPoplatku.get(), operacia);
        sadzbaPoplatku.get().vypocitajPoplatok(operacia);
    }

    private static final Logger log = LogManager.getLogger();
}
