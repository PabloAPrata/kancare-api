package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O tipo do documento não pode estar vazio.")
    @Size(max = 24, message = "Tipo do documento pode ter no máximo {max} caracteres.")
    @Column(name = "tipo_documento", nullable = false, length = 24)
    private String tipoDocumento;

    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "O campo dataInclusao não pode estar vazio")
    @Column(name= "data_inclusao", columnDefinition = "DATE")
    private LocalDate dataInclusao;

    @NotNull(message = "O campo dataAtualizacao não pode estar vazio")
    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario_fk")
    private Beneficiario beneficiario;
}
