package com.found.service.securite;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.found.mapper.securite.FSecCompteResourceMapper;
import com.found.repository.securite.FSecCompteRepository;
import com.found.resource.securite.FSecCompteResource;

import io.vavr.control.Option;

/**
 * <p>
 *                  Classe représentant un service pour la gestion des ressources comptes
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Service
public class FSecCompteService {

    // --------------------------------------- Injection des repo ----------------------------------
    @Inject
    private FSecCompteRepository                comptesRepo;
    
    // --------------------------------------- Injection des mappers -------------------------------
    @Inject
    private FSecCompteResourceMapper            comptesMapper;
    
    // ------------------------------------------ Méthodes publiques ---------------------------------
    /**
     * Retourne la liste des comptes
     * @return
     * @since 0.0.1
     */
    public List<FSecCompteResource> getSecComptes(){
        return this.comptesMapper.entityListToResourceList(this.comptesRepo.findAll());
    }
    
    public Option<FSecCompteResource> findSecCompte(Long id){
        return Option.of(this.comptesRepo.findOne(id)).flatMap(c->Option.of(this.comptesMapper.entityToResource(c)));
    }
    
    public Option<FSecCompteResource> findSecCompteByLogin(String login){
        return Option.ofOptional(this.comptesRepo.findByLogin(login)).flatMap(c->Option.of(this.comptesMapper.entityToResource(c)));
    }
    
    /**
     * Insère un compte
     * @param compte
     * @return
     * @since 0.0.1
     */
    public FSecCompteResource insertSecCompte(FSecCompteResource compte){
        return this.comptesMapper.entityToResource(this.comptesRepo.save(this.comptesMapper.resourceToEntity(compte)));
    }
    
    /**
     * Supprime un compte
     * @param compteId
     * @since 0.0.1
     */
    public void deleteSecCompte(Long compteId){
        this.comptesRepo.delete(compteId);
    }
}
