package br.com.guerin.Service.IService;

import br.com.guerin.Entity.Vaccine;
import br.com.guerin.Entity.VaccineApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

public interface IVaccineApplicationService {
    void disable(Long id, VaccineApplication vaccineApplication);
    Optional<VaccineApplication> findById(Long id);
    Page<VaccineApplication> findAll(Pageable pageable);
    VaccineApplication saveTransactional(VaccineApplication vaccineApplication);
    VaccineApplication update(Long id, VaccineApplication vaccineApplication);
    VaccineApplication save(VaccineApplication vaccineApplication);
    Optional<ArrayList<VaccineApplication>> findByVaccine(Vaccine vaccine);
    boolean validateSaveAndUpdate(VaccineApplication vaccineApplication);
}
