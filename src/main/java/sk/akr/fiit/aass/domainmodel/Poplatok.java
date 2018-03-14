package sk.akr.fiit.aass.domainmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

// Domenova trieda pre poplatok
public class Poplatok {

    private BigDecimal vyskaPoplatku;
    private SadzbaPoplatku sadzbaPoplatku;
    private Operacia operacia;

    public Poplatok(BigDecimal vyskaPoplatku, SadzbaPoplatku sadzbaPoplatku, Operacia operacia) {
        this.vyskaPoplatku = vyskaPoplatku;
        this.sadzbaPoplatku = sadzbaPoplatku;
        this.operacia = operacia;
    }

    public void save() {
        // ulozenie poplatku do databazy
        log.info("Ukladam poplatok {} do databazy.", this);
    }
    
    public String toString() {
        return "Poplatok{" +
                "vyskaPoplatku=" + vyskaPoplatku +
                ", sadzbaPoplatku=" + sadzbaPoplatku +
                '}';
    }

    private static final Logger log = LogManager.getLogger();
}
