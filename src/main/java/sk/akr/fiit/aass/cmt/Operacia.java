package sk.akr.fiit.aass.cmt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import sk.akr.fiit.aass.to.OperaciaTO;

// Domenova trieda pre operaciu
@Entity
public class Operacia {

    @Id
    private Long operationId;

    public Operacia() {
    }

    public Operacia(OperaciaTO operaciaTO) {
    }


    public void vypocitajPoplatky() {
    }
}
