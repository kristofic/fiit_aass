package sk.akr.fiit.aass.txscript.datamodel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SadzbaPoplatku {

    private long idSadzby;
    private BigDecimal sadzba;
    private SposobVypoctu sposobVypoctu;
    private BigDecimal minSadzba;
    private BigDecimal maxSadzba;
    private BigDecimal sumaOperacieOd;
    private BigDecimal sumaOperacieDo;
    private LocalDate platnostOd;
    private LocalDate platnostDo;

    public SadzbaPoplatku(long idSadzby, BigDecimal sadzba, SposobVypoctu sposobVypoctu, BigDecimal minSadzba, BigDecimal maxSadzba, BigDecimal sumaOperacieOd, BigDecimal sumaOperacieDo, LocalDate platnostOd, LocalDate platnostDo) {
        this.idSadzby = idSadzby;
        this.sadzba = sadzba;
        this.sposobVypoctu = sposobVypoctu;
        this.minSadzba = minSadzba;
        this.maxSadzba = maxSadzba;
        this.sumaOperacieOd = sumaOperacieOd;
        this.sumaOperacieDo = sumaOperacieDo;
        this.platnostOd = platnostOd;
        this.platnostDo = platnostDo;
    }

    public long getIdSadzby() {
        return idSadzby;
    }

    public void setIdSadzby(long idSadzby) {
        this.idSadzby = idSadzby;
    }

    public BigDecimal getSadzba() {
        return sadzba;
    }

    public void setSadzba(BigDecimal sadzba) {
        this.sadzba = sadzba;
    }

    public SposobVypoctu getSposobVypoctu() {
        return sposobVypoctu;
    }

    public void setSposobVypoctu(SposobVypoctu sposobVypoctu) {
        this.sposobVypoctu = sposobVypoctu;
    }

    public BigDecimal getMinSadzba() {
        return minSadzba;
    }

    public void setMinSadzba(BigDecimal minSadzba) {
        this.minSadzba = minSadzba;
    }

    public BigDecimal getMaxSadzba() {
        return maxSadzba;
    }

    public void setMaxSadzba(BigDecimal maxSadzba) {
        this.maxSadzba = maxSadzba;
    }

    public BigDecimal getSumaOperacieOd() {
        return sumaOperacieOd;
    }

    public void setSumaOperacieOd(BigDecimal sumaOperacieOd) {
        this.sumaOperacieOd = sumaOperacieOd;
    }

    public BigDecimal getSumaOperacieDo() {
        return sumaOperacieDo;
    }

    public void setSumaOperacieDo(BigDecimal sumaOperacieDo) {
        this.sumaOperacieDo = sumaOperacieDo;
    }

    public LocalDate getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(LocalDate platnostOd) {
        this.platnostOd = platnostOd;
    }

    public LocalDate getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(LocalDate platnostDo) {
        this.platnostDo = platnostDo;
    }

    public enum SposobVypoctu {
        FIXNY,
        PERCENTUALNY,
        PERCENTUALNY_OHRAN
    }
}
