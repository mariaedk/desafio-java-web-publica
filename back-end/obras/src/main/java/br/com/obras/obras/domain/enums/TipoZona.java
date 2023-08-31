package br.com.obras.obras.domain.enums;

import lombok.Getter;

public enum TipoZona {
    RURAL(0),
    URBANA(1);

    private @Getter int tipoZona;

    private TipoZona(int tipoZona) {
        this.tipoZona = tipoZona;
    }
    public static String getNomeExibicao(TipoZona tipoZona) {

        switch (tipoZona) {

            case RURAL:
                return "Rural";

            case URBANA:
                return "Urbana";

            default:
                return "";
        }
    }
}
