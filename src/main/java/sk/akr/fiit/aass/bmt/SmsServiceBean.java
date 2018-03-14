package sk.akr.fiit.aass.bmt;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class SmsServiceBean implements SmsService {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
