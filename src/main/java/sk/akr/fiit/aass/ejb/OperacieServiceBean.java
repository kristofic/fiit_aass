package sk.akr.fiit.aass.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

@Stateless
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB // <-- injektaz komponentu, je mozna aj cez setter
    private SmsService smsService;

    public void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        smsService.posliSmsNotifikaciu(operacia);
    }
}
