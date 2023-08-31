package br.com.obras.domain.entities;

import br.com.obras.domain.enums.TipoZona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "obras", name = "obra_privada")
public class ObraPrivada extends Obra {

    @NotNull
    private @Getter TipoZona zona;

    @NotNull
    private @Getter Double areaTotal;

    @JsonManagedReference // Quando obra for serializado, serviços também serão
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraPrivada") // Lazy Loading: Trazer servicos conforme demanda para evitar sobrecarga
    private @Getter List<Servico> servicos;

    protected ObraPrivada() {}

    public ObraPrivada(LocalDate dataCadastro, String descricao, TipoZona zona, Double areaTotal, List<Servico> servicos) {
        super(dataCadastro, descricao);
        this.zona = zona;
        this.areaTotal = areaTotal;
        this.servicos = servicos;
    }
}
