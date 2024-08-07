package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BENEFICIARIOS")
public class Beneficiario extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @Column(name = "telefone", nullable = false, unique = true, length = 18)
    private String telefone;

    @Column(name= "data_nascimento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Column(name= "data_inclusao", nullable = false, columnDefinition = "DATE")
    private LocalDate dataInclusao;

    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos;
}
