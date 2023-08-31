package br.com.obras.domain.enums;

import lombok.Getter;

public enum TipoZona {
    RURAL(0),
    URBANA(1);

    private @Getter int tipoZona;

    private TipoZona(int tipoZona) {
        this.tipoZona = tipoZona;
    }
    public static String getNomeExibicao(TipoZona status) {

        switch (status) {

            case RURAL:
                return "Rural";

            case URBANA:
                return "Urbana";

            default:
                return "";
        }
    }
}
