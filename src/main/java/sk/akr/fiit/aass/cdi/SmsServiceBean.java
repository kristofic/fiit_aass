package sk.akr.fiit.aass.cdi;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class SmsServiceBean implements SmsService {

    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
