package sk.akr.fiit.aass.security;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.ejb.Local;

@Local
public interface OperacieService {

    void vytvorOperaciu(OperaciaTO operaciaTO) throws Exception;
}
