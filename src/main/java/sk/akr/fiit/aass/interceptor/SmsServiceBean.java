package sk.akr.fiit.aass.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors({AuditInterceptor.class})
public class SmsServiceBean implements SmsService {

    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
