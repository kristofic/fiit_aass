package sk.akr.fiit.aass.cmt;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

@Stateless
public class SmsServiceBean implements SmsService {


    // metoda vyzaduje NOVU transakciu, kontajner zabezpeci pozastavenie existujcej
    // a start novej pred spustenim metody
    @TransactionAttribute(REQUIRES_NEW)
    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
