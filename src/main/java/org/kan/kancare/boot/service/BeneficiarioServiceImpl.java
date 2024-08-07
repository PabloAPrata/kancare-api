package org.kan.kancare.boot.service;

import org.kan.kancare.boot.dao.BeneficiarioDao;
import org.kan.kancare.boot.domain.Beneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioDao dao;

    @Override
    public void salvar(Beneficiario beneficiario) {
        dao.save(beneficiario);
    }

    @Override
    public void editar(Beneficiario beneficiario) {
        dao.update(beneficiario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Beneficiario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Beneficiario> buscarTodos() {
        return dao.findAll();
    }
}
