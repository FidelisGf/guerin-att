package br.com.guerin.Service.IService;

import br.com.guerin.Entity.Cattle;
import br.com.guerin.Payload.Cattle.ResultFindParents;
import br.com.guerin.Payload.Cattle.ResultFindChildren;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Optional;

public interface ICattleService {
    Cattle update(Long id, Cattle cattle);
    Page<Cattle> findAll(Pageable pageable);
    Optional<Cattle> findById(Long id);
    Cattle save(Cattle cattle);
    Cattle disable(Long id, Cattle cattle);
    Optional<Cattle> findByEarring(Long earring);
    Cattle findByEarringOrNew(Long earring);
    ResultFindParents findParents(Long earring);
    ResultFindChildren findChildren(Long earring);
    ArrayList<Cattle> findBySpecie(Long specie_id);
    ArrayList<Cattle> findByFarm(Long farm_id);
    void validateParents(Cattle cattle);
    void validateFather(Cattle cattle);
    void validateMother(Cattle cattle);
}
