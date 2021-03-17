package sk.akr.fiit.aass.bmt;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;

@Stateless
public class SmsServiceBean implements SmsService {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
