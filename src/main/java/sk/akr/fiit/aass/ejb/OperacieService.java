package sk.akr.fiit.aass.ejb;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.ejb.Local;

@Local
public interface OperacieService {

    void vytvorOperaciu(OperaciaTO operaciaTO);
}
