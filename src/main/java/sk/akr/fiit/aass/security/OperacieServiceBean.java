package sk.akr.fiit.aass.security;

import jakarta.annotation.Resource;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

@Stateless
// definujeme logicke roly, ktore bude komponent pouzivat
@DeclareRoles({"POBOCKOVY_PRACOVNIK", "RIADITEL_POBOCKY", "ADMINISTRATOR"})
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private EJBContext context;

    @EJB
    private SmsService smsService;

    // definujeme logicke roly, ktore maju pristup k metode
    @RolesAllowed({"POBOCKOVY_PRACOVNIK", "RIADITEL_POBOCKY", "ADMINISTRATOR"})
    public void vytvorOperaciu(OperaciaTO operaciaTO) throws Exception {
        Operacia operacia = new Operacia(operaciaTO);
        // programove overenie roly pouzivatela
        if (operacia.jeNadlimitna() && !context.isCallerInRole("RIADITEL_POBOCKY")) {
            throw new Exception("Nadlimitne operacie moze vykonovat iba riaditel poobocky.");
        }
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        smsService.posliSmsNotifikaciu(operacia);
    }

    @RolesAllowed("ADMINISTRATOR")
    public void zmazOperaciu(long idOperacie) {
        Operacia operaciaNaZmazanie = entityManager.find(Operacia.class, idOperacie);
        entityManager.remove(operaciaNaZmazanie);
    }
}
