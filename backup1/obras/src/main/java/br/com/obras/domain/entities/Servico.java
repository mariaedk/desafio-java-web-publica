package br.com.obras.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(schema = "obras", name = "servico", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_responsavel", "nr_obra_privada", "nr_obra_publica"})
})
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    @NotNull
    private @Getter Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsavel")
    private @Getter Responsavel responsavel;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_obra_privada")
    private @Getter ObraPrivada obraPrivada;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_obra_publica")
    private @Getter ObraPublica obraPublica;

    protected Servico() {}
    public Servico(Responsavel responsavel, ObraPrivada obraPrivada, ObraPublica obraPublica) {
        this.responsavel = responsavel;
        this.obraPrivada = obraPrivada;
        this.obraPublica = obraPublica;
    }
}
