package br.com.obras.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(schema = "obras", name = "responsavel", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cpf"})
})
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsavel")
    @NotNull
    private @Getter Long id;

    @NotNull
    @NotBlank
    @Column(length = 11) // Somente caracteres numéricos
    private @Getter String cpf;

    @NotNull
    @NotBlank
    private @Getter String nome;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel")
    private @Getter List<Servico> servicos;

    protected Responsavel() {}

    public Responsavel(String cpf, String nome, List<Servico> servicos) {
        this.cpf = cpf;
        this.nome = nome;
        this.servicos = servicos;
    }
}
