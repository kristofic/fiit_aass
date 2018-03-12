package sk.akr.fiit.aass.txscript.dataservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.akr.fiit.aass.txscript.datamodel.OperaciaTO;

public class OperaciaDataService {

    private static final Logger log = LogManager.getLogger();

    public long vytvorOperaciu(OperaciaTO operaciaTO) {
        // vlozi operaciu do databazy, vrati id
        log.info("Vkladam operaciu {} do databazy.", operaciaTO);
        return 1L;
    }
}
