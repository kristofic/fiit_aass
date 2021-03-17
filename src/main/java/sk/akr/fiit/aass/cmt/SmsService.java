package sk.akr.fiit.aass.cmt;

import jakarta.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
