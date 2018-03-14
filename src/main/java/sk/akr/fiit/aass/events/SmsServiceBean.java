package sk.akr.fiit.aass.events;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;

@RequestScoped
public class SmsServiceBean {

    // metoda bude zavolana, vzdy ked pride prislusny event
    public void novaOperacia(@Observes OperaciaVytvorenaEvent event, EventMetadata eventMetadata) {
        posliSmsNotifikaciu(event.getOperacia());
    }

    public void posliSmsNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
