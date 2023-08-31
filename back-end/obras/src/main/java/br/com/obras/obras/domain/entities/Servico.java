package br.com.obras.obras.domain.entities;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_obra")
    private Obra obra;

    protected Servico() {}
    public Servico(Responsavel responsavel, Obra obra) {
        this.responsavel = responsavel;
        this.obra = obra;
    }
}