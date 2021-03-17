package sk.akr.fiit.aass.events;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.EventMetadata;

@RequestScoped
public class EmailServiceBean {

    // metoda bude zavolana, vzdy ked pride prislusny event
    public void novaOperacia(@Observes OperaciaVytvorenaEvent event, EventMetadata eventMetadata) {
        posliMailNotifikaciu(event.getOperacia());
    }

    public void posliMailNotifikaciu(Operacia operacia) {
        // volanie externej sluzby
    }
}
