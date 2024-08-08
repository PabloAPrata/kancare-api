package org.kan.kancare.boot.dao;

import org.kan.kancare.boot.domain.Documento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentoDao {

    void save(Documento documento);

    void update(Documento documento);

    void delete(Long id);

    Documento findById(Long id);

    List<Documento> findAll();

    @Query("SELECT d FROM Documento d WHERE d.beneficiario.id = :beneficiarioId")
    List<Documento> findByBeneficiarioId(@Param("beneficiarioId") Long beneficiarioId);
}
