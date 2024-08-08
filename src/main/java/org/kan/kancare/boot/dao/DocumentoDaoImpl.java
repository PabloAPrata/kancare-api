package org.kan.kancare.boot.dao;

import org.kan.kancare.boot.domain.Documento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentoDaoImpl extends AbstractDao<Documento, Long> implements DocumentoDao {
    @Override
    public List<Documento> findByBeneficiarioId(Long beneficiarioId) {
        return createQuery("SELECT d FROM Documento d WHERE d.beneficiario.id = ?1", beneficiarioId);
    }
}
