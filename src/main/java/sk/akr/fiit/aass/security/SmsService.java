package sk.akr.fiit.aass.security;

import jakarta.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
