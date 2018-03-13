package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.akr.fiit.aass.domainmodel.to.OperaciaTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Domenova trieda pre operaciu
public class Operacia {

    private TypOperacie typOperacie;
    private LocalDate datum;
    private BigDecimal suma;
    private String protiucetIban;
    private Set<Poplatok> poplatky = new HashSet<>();

    public static void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        operacia.save();
    }

    private void vypocitajPoplatky() {
        // Delegovanie zodpovednosti
        log.info("Vypocet poplatkov pre operaciu {}", this);
        getTypOperacie().vypocitajPoplatky(this);
    }

    private void save() {
        // ulozenie dat operacie a asociovanych objektov do databazy
        log.info("Ukladam operaciu {} do databazy.", this);
        for (Poplatok poplatok : poplatky) {
            poplatok.save();
        }
    }

    public void addPoplatok(Poplatok poplatok) {
        log.info("Pridany poplatok {} na operaciu {}", poplatok, this);
        this.poplatky.add(poplatok);
    }

    private Operacia(OperaciaTO operaciaTO) {
        this.typOperacie = TypOperacie.najdiTypOperacie(operaciaTO.getTyp());
        this.datum = operaciaTO.getDatum();
        this.suma = operaciaTO.getSuma();
        this.protiucetIban = operaciaTO.getProtiucetIban();
    }

    public TypOperacie getTypOperacie() {
        return typOperacie;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Operacia{" +
                "typOperacie=" + typOperacie +
                ", datum=" + datum +
                ", suma=" + suma +
                ", protiucetIban='" + protiucetIban + '\'' +
                '}';
    }

    private static final Logger log = LogManager.getLogger();
}
