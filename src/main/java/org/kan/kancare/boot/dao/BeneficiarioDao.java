package org.kan.kancare.boot.dao;

import org.kan.kancare.boot.domain.Beneficiario;

import java.util.List;

public interface BeneficiarioDao {

    void save(Beneficiario beneficiario);

    void update(Beneficiario beneficiario);

    void delete(Long id);

    Beneficiario findById(Long id);

    List<Beneficiario> findAll();
}
