package br.com.guerin.Service;

import br.com.guerin.Entity.Specie;
import br.com.guerin.Repository.Specie.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SpecieService {
    @Autowired
    private SpecieRepository specieRepository;
    @Transactional
    public void save(Specie specie){
         specieRepository.save(specie);
    }

    public Specie findById(Long id){
        return this.specieRepository.findById(id).orElse(new Specie());
    }
    public Page<Specie> listAll(Pageable pageable){
        return this.specieRepository.findAll(pageable);
    }
    @Transactional
    public void update(Long id, Specie specie){
        if(id == specie.getId()){
            this.specieRepository.save(specie);
        }else{
            throw  new RuntimeException("Erro : Não foi possivel editar a Especie");
        }
    }
    @Transactional
    public void desativar(Long id, Specie specie ){
        if(id == specie.getId()){
            this.specieRepository.desativar(specie.getId());
        }
    }

}
