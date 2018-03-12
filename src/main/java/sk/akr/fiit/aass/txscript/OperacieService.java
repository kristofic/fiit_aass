package sk.akr.fiit.aass.txscript;

import sk.akr.fiit.aass.txscript.datamodel.OperaciaTO;
import sk.akr.fiit.aass.txscript.datamodel.SadzbaPoplatku;
import sk.akr.fiit.aass.txscript.dataservice.OperaciaDataService;
import sk.akr.fiit.aass.txscript.dataservice.PoplatokDataService;
import sk.akr.fiit.aass.txscript.dataservice.SadzbaPoplatkuDataService;
import sk.akr.fiit.aass.txscript.dataservice.TypPoplatkuDataService;

import java.math.BigDecimal;
import java.util.Set;

public class OperacieService {

    // Transakcny scenar pre vytvorenie operacie
    public void vytvorOperaciu(OperaciaTO operaciaTO /* <-- transferovy objekt */) {
        // volanie vrstvy datovych sluzieb
        long idOperacie = operaciaDS.vytvorOperaciu(operaciaTO);
        Set<String> kodyPoplatkov = typPoplatkuDS.najdiTypyPoplatkov(operaciaTO.getTyp());

        for (String kodPoplatku : kodyPoplatkov) {
            SadzbaPoplatku sadzba = sadzbaPoplatkuDS.najdiSadzbu(
                kodPoplatku,
                operaciaTO.getDatum(),
                operaciaTO.getSuma()
            );
            BigDecimal vyskaPoplatku = poplatkyService.vypocitajPoplatok(sadzba, operaciaTO);
            poplatokDS.vytvorPoplatok(idOperacie, sadzba.getIdSadzby(), vyskaPoplatku);
        }

    }

    private PoplatkyService poplatkyService = new PoplatkyService();

    private OperaciaDataService operaciaDS = new OperaciaDataService();
    private TypPoplatkuDataService typPoplatkuDS = new TypPoplatkuDataService();
    private SadzbaPoplatkuDataService sadzbaPoplatkuDS = new SadzbaPoplatkuDataService();
    private PoplatokDataService poplatokDS = new PoplatokDataService();

}
