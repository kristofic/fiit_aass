package sk.akr.fiit.aass.ejb;

import javax.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
