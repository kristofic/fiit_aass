package sk.akr.fiit.aass.cdi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

@RequestScoped
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject // <-- injektaz komponentu, je mozna aj cez setter alebo konstruktor
    private SmsService smsService;

    public void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        smsService.posliSmsNotifikaciu(operacia);
    }
}
