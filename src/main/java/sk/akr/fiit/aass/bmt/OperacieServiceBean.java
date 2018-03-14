package sk.akr.fiit.aass.bmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.akr.fiit.aass.to.OperaciaTO;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import static javax.ejb.TransactionAttributeType.*;
import static javax.ejb.TransactionManagementType.*;

@Stateless
@TransactionManagement(BEAN) // <-- transakcie budu riadene komponentom
public class OperacieServiceBean implements OperacieService {

    @Resource
    private UserTransaction utx; // <-- injektaz rozhrania na transakcneho manazera

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private SmsService smsService;

    public void vytvorOperaciu(OperaciaTO operaciaTO) throws Exception {
        Operacia operacia = new Operacia(operaciaTO);
        operacia.vypocitajPoplatky();
        try {
            // start transakcie
            utx.begin();
            entityManager.persist(operacia);
            smsService.posliSmsNotifikaciu(operacia);
            // commit transakcie
            utx.commit();
        } catch (Exception e) {
            // rollback transakcie v pripade chyby
            log.error("Chyba pri ulozeni operacie.", e);
            utx.rollback();
        }
    }

    private static final Logger log = LogManager.getLogger();

}
