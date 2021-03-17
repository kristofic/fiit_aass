package sk.akr.fiit.aass.interceptor;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

@Stateless
@Interceptors({AuditInterceptor.class}) // <-- aplikovanie interceptora (moze ich by aj viac) na konkretny komponent
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private SmsService smsService;

    public void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        smsService.posliSmsNotifikaciu(operacia);
    }
}
