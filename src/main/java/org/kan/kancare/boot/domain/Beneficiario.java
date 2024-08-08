package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BENEFICIARIOS")
public class Beneficiario extends AbstractEntity<Long> {

    @NotBlank(message = "Informe um nome")
    @Size(min = 3, max = 60, message = "O nome do beneficiario deve ter entre {min} e {max} caracteres.")
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "O telefone do beneficiário não pode estar vazio.")
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @NotNull(message = "A data de nascimento do beneficiário não pode estar vazia.")
    @Column(name= "data_nascimento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Column(name= "data_inclusao", columnDefinition = "DATE")
    private LocalDate dataInclusao = LocalDate.now();;

    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao = LocalDate.now();

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos;
}
