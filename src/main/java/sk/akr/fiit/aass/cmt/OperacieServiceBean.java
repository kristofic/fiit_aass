package sk.akr.fiit.aass.cmt;

import sk.akr.fiit.aass.to.OperaciaTO;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

@Stateless
@TransactionManagement(CONTAINER) // <-- transakcie budu riadene kontajnerom (default)
public class OperacieServiceBean implements OperacieService {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private SmsService smsService;

    // metoda vyzaduje transakciu, kontajner zabezpeci jej start pred spustenim metody
    @TransactionAttribute(REQUIRED)
    public void vytvorOperaciu(OperaciaTO operaciaTO) {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        entityManager.persist(operacia);
        smsService.posliSmsNotifikaciu(operacia);
    }
}
