package br.com.obras.domain.entities;

import br.com.obras.domain.enums.TipoZona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "public", name = "obra")
@Getter
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_obra")
    private Long numeroObra;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;

    private String descricao;

    private TipoZona zona;

    private Double areaTotal;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_fim")
    private LocalDate dataFim;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obra")
    private List<Servico> servicos;

    protected Obra() {}

    public Obra(Long numeroObra, LocalDate dataCadastro, String descricao,
                TipoZona zona, Double areaTotal, LocalDate dataInicio, LocalDate dataFim, List<Servico> servicos) {
        this.numeroObra = numeroObra;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
        this.zona = zona;
        this.areaTotal = areaTotal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.servicos = servicos;
    }
}
