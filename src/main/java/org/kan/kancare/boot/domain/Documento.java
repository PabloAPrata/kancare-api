package org.kan.kancare.boot.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOCUMENTOS")
public class Documento extends AbstractEntity<Long> {

    @Column(name = "tipo_documento", nullable = false, length = 60)
    private String tipoDocumento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name= "data_inclusao", nullable = false, columnDefinition = "DATE")
    private LocalDate dataInclusao;

    @Column(name= "data_atualizacao", columnDefinition = "DATE")
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario_fk")
    private Beneficiario beneficiario;
}
