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

    List<Documento> findByBeneficiarioId(Long beneficiarioId);
}
