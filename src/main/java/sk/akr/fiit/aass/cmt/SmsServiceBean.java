package sk.akr.fiit.aass.cmt;

import static jakarta.ejb.TransactionAttributeType.REQUIRES_NEW;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;

@Stateless
public class SmsServiceBean implements SmsService {


    // metoda vyzaduje NOVU transakciu, kontajner zabezpeci pozastavenie existujcej
    // a start novej pred spustenim metody
    @TransactionAttribute(REQUIRES_NEW)
    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
