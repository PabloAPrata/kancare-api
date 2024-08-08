package org.kan.kancare.boot.dao;

import org.kan.kancare.boot.domain.Documento;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DocumentoDaoImpl extends AbstractDao<Documento, Long> implements DocumentoDao {

    @Override
    public List<Documento> findByBeneficiarioId(Long beneficiarioId) {
        Map<String, Object> params = new HashMap<>();
        params.put("beneficiarioId", beneficiarioId);

        return createQuery("from Documento d where d.beneficiario.id = :beneficiarioId", params);
    }
}
