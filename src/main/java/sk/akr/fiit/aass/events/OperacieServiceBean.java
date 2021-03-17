package sk.akr.fiit.aass.events;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

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
