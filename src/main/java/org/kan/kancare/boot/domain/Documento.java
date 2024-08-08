package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOCUMENTOS")
public class Documento extends AbstractEntity<Long> {

    @NotBlank(message = "O tipo do documento não pode estar vazio.")
    @Size(max = 24, message = "Tipo do documento pode ter no máximo {max} caracteres.")
    @Column(name = "tipo_documento", nullable = false, length = 24)
    private String tipoDocumento;

    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "A data de inclusão do documento não pode estar vazia.")
    @Column(name= "data_inclusao", nullable = false, columnDefinition = "DATE")
    private LocalDate dataInclusao;

    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario_fk", nullable = false)
    private Beneficiario beneficiario;
}
