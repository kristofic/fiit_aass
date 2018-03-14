package sk.akr.fiit.aass.cmt;

import javax.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
