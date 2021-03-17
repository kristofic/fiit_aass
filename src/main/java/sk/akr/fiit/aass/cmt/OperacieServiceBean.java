package sk.akr.fiit.aass.cmt;

import static jakarta.ejb.TransactionAttributeType.REQUIRED;
import static jakarta.ejb.TransactionManagementType.CONTAINER;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionManagement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sk.akr.fiit.aass.to.OperaciaTO;

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
