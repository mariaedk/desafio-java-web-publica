package br.com.obras.obras.domain.entities;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(schema = "public", name = "responsavel", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cpf"})
})
@Getter
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsavel")
    private Long id;

    @Column(length = 11) // Somente caracteres numéricos
    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel")
    private List<Servico> servicos;

    protected Responsavel() {}

    public Responsavel(Long id, String cpf, String nome, List<Servico> servicos) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.servicos = servicos;
    }
}