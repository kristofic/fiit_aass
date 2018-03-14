package sk.akr.fiit.aass.security;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
