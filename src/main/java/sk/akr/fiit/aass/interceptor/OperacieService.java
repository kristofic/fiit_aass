package sk.akr.fiit.aass.interceptor;

import jakarta.ejb.Local;
import sk.akr.fiit.aass.to.OperaciaTO;

@Local
public interface OperacieService {

    void vytvorOperaciu(OperaciaTO operaciaTO);
}
