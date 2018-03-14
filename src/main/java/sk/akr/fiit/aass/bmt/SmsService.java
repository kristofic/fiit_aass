package sk.akr.fiit.aass.bmt;

import javax.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
