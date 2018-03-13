package sk.akr.fiit.aass.cdi;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.ejb.Local;

public interface OperacieService {
    void vytvorOperaciu(OperaciaTO operaciaTO);
}
