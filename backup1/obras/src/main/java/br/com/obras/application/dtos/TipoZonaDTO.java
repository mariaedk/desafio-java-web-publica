package br.com.obras.application.dtos;

import lombok.*;

@Getter
public enum TipoZonaDTO {
    RURAL(0),
    URBANA(1);

    private @Getter int tipoZona;

    private TipoZonaDTO(int tipoZona) {
        this.tipoZona = tipoZona;
    }
    public static String getNomeExibicao(TipoZonaDTO status) {

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
