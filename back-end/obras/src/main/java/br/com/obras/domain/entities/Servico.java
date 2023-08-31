package br.com.obras.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "servico", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_responsavel", "nr_obra"})
})
@Getter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_obra")
    private Obra obra;

    protected Servico() {}
    public Servico(Responsavel responsavel, Obra obra) {
        this.responsavel = responsavel;
        this.obra = obra;
    }
}
