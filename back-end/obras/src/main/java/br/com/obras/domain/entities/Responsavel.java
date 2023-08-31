package br.com.obras.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private String cpf;

    private String nome;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel")
    private List<Servico> servicos;

    protected Responsavel() {}

    public Responsavel(String cpf, String nome, List<Servico> servicos) {
        this.cpf = cpf;
        this.nome = nome;
        this.servicos = servicos;
    }
}
