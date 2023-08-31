package br.com.obras.obras.domain.enums;

import lombok.Getter;

public enum TipoObra {
    PRIVADA(0),
    PUBLICA(1);

    private @Getter int tipoObra;

    private TipoObra(int tipoObra) {
        this.tipoObra = tipoObra;
    }
    public static String getNomeExibicao(TipoObra tipoObra) {

        switch (tipoObra) {

            case PRIVADA:
                return "Privada";

            case PUBLICA:
                return "Publica";

            default:
                return "";
        }
    }
}
