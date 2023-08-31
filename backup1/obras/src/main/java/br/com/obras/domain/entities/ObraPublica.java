package br.com.obras.domain.entities;

import br.com.obras.domain.enums.TipoZona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "obras", name = "obra_publica")
public class ObraPublica extends Obra {

    @NotNull
    @Column(name = "dt_inicio")
    private @Getter LocalDate dataInicio;

    @NotNull
    @Column(name = "dt_fim")
    private @Getter LocalDate dataFim;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraPublica")
    private @Getter List<Servico> servicos;

    protected ObraPublica() {}

    public ObraPublica(LocalDate dataCadastro, String descricao, LocalDate dataInicio, LocalDate dataFim, List<Servico> servicos) {
        super(dataCadastro, descricao);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.servicos = servicos;
    }
}
