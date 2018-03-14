package sk.akr.fiit.aass.security;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.persistence.Entity;

// Domenova trieda pre operaciu
@Entity
public class Operacia {

    public Operacia(OperaciaTO operaciaTO) {
    }


    public void vypocitajPoplatky() {
    }

    public boolean jeNadlimitna() {
        return false;
    }
}
