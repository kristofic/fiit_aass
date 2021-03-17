package sk.akr.fiit.aass.bmt;

import jakarta.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
