package sk.akr.fiit.aass.events;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    // injektaz "zbernice" na posielanie eventov
    @Inject
    private Event<OperaciaVytvorenaEvent> operaciaVytvorenaEvent;

    public void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        // zaslanie eventu o vytvoreni operacie
        operaciaVytvorenaEvent.fire(new OperaciaVytvorenaEvent(operacia));
    }
}
