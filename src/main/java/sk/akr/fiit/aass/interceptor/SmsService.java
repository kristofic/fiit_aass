package sk.akr.fiit.aass.interceptor;

import javax.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
