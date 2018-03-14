package sk.akr.fiit.aass.security;

import javax.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
