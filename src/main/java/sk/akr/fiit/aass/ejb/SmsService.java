package sk.akr.fiit.aass.ejb;

import jakarta.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
