package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beneficiarios")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @NotNull(message = "O campo dataInclusao não pode estar vazio")
    @Column(name= "data_inclusao", columnDefinition = "DATE")
    private LocalDate dataInclusao;

    @NotNull(message = "O campo dataAtualizacao não pode estar vazio")
    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    private List<Documento> documentos;

    @PreUpdate
    protected void preUpdate() {
        this.dataAtualizacao = LocalDate.now();
    }

    @PrePersist
    protected void prePersist() {
        this.dataInclusao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }
}
