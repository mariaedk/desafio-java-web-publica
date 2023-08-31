package br.com.obras.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public abstract class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_obra")
    private @Getter Long numeroObra;

    @Column(name = "dt_cadastro")
    @NotNull
    private @Getter LocalDate dataCadastro;

    @NotNull
    private @Getter String descricao;

    protected Obra() {}

    public Obra(LocalDate dataCadastro, String descricao) {
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
    }
}
