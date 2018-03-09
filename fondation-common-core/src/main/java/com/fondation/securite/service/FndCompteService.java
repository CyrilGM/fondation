package com.fondation.securite.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fondation.securite.mapper.FndCompteResourceMapper;
import com.fondation.securite.repository.FndCompteRepository;
import com.fondation.securite.resource.FndCompteResource;

import io.vavr.collection.List;
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
public class FndCompteService {

    // --------------------------------------- Injection des repo ----------------------------------
    @Inject
    private FndCompteRepository                comptesRepo;
    
    // --------------------------------------- Injection des mappers -------------------------------
    @Inject
    private FndCompteResourceMapper            comptesMapper;
    
    // ------------------------------------------ Méthodes publiques ---------------------------------
    /**
     * Retourne la liste des comptes
     * @return
     * @since 0.0.1
     */
    public List<FndCompteResource> getSecComptes(){
        return this.comptesMapper.entitesToResources(List.ofAll(this.comptesRepo.findAll()));
    }
    
    public Option<FndCompteResource> findSecCompte(Long id){
        return Option.of(this.comptesRepo.findOne(id)).flatMap(c->Option.of(this.comptesMapper.entiteToResource(c)));
    }
    
    public Option<FndCompteResource> findSecCompteByLogin(String login){
        return Option.ofOptional(this.comptesRepo.findByLogin(login)).flatMap(c->Option.of(this.comptesMapper.entiteToResource(c)));
    }
    
    /**
     * Insère un compte
     * @param compte
     * @return
     * @since 0.0.1
     */
    public FndCompteResource insertSecCompte(FndCompteResource compte){
        return this.comptesMapper.entiteToResource(this.comptesRepo.save(this.comptesMapper.resourceToEntite(compte)));
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
