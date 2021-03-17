package sk.akr.fiit.aass.interceptor;

import jakarta.ejb.Local;

@Local
public interface SmsService {

    void posliSmsNotifikaciu(Operacia operacia);
}
