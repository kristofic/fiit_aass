package sk.akr.fiit.aass.security;

import jakarta.ejb.Stateless;

@Stateless
public class SmsServiceBean implements SmsService {

    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
