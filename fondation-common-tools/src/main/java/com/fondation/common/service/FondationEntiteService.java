package com.fondation.common.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fondation.common.config.ApplicationContextAccessor;
import com.fondation.common.domain.IFondationIdentifiableEntite;
import com.fondation.common.helper.GenericsHelper;

import io.vavr.collection.List;
import io.vavr.control.Option;

/**
 * <p>
 *                      Classe de base pour implémenter des services métier.
 *                      Les services métier sont utilisés pour implémenter la logique métier sur des entités standard.
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public class FondationEntiteService<E extends IFondationIdentifiableEntite<I>,I extends Serializable,R extends JpaRepository<E, I>> extends FondationService {

    // Membres internes
    private R                               repository;
    
    // ----------------------- Méthodes publiques ---------------------
    /**
     * Retourne l'entité dont l'id est passé en paramètres
     * @param id
     * @return
     * @since 0.0.1
     */
    public Option<E> get(I id) {
        E result = null;
        if (id!=null){
            result = getRepository().findOne(id);
        }
        return Option.of(result);
    }

    /**
     * Crée une nouvelle entité en base
     * @param entite
     * @return
     * @since 0.0.1
     */
    public Option<E> create(E entite) {
        checkValidityCreate(entite);
        return Option.of(getRepository().save(entite));
    }

    /**
     * Met à jour une entité en base
     * @param entite
     * @return
     * @since 0.0.1
     */
    public Option<E> update(E entite) {
        checkValidityUpdate(entite);
        return Option.of(getRepository().save(entite));
    }

    /**
     * Supprime une entité en base
     * @param id
     * @since 0.0.1
     */
    public void delete(I id) {
        checkValidityDelete(id);
        getRepository().delete(id);
    }
    
    /**
     * Permet de vérifier qu'un enregistrement existe pour l'id passé en paramètre
     * @param id
     * @return
     * @since 0.0.1
     */
    public Boolean exist(I id) {
        return getRepository().exists(id);
    }
    
    /**
     * Effectue une recherche par pagination en base
     * @param pageable
     * @return
     * @since 0.0.1
     */
    public Option<Page<E>> findAll(Pageable pageable){
        return Option.of(getRepository().findAll(pageable));
    }
    
    /**
     * Effectue une recherche pour retourner l'intégralité des données
     * @return
     * @since 0.0.1
     */
    public List<E> findAll(){   
        return List.ofAll(Option.of(getRepository().findAll()).getOrElse(new ArrayList<>()));
    }
    
    // ------------------- Méthodes protégées -------------------------
    /**
     * Retourne le repository lié
     * @return
     * @since 0.0.1
     */
    protected R getRepository() {
        if (this.repository==null){
            this.repository = this.retrieveRepository();
        }
        return this.repository;
    }
    
    /**
     * Effectue l'initialisation du repository lié
     * @return
     * @since 0.0.1
     */
    protected R retrieveRepository(){
        return ApplicationContextAccessor.getContext().getBean(GenericsHelper.getGenericArgumentClass(getClass(), 2));
    }
 
    /**
     * Effectue les validations en cas de création
     * @param entite
     * @since 0.0.1
     */
    protected void checkValidityCreate(E entite){
        this.checkValidityUpdate(entite);
    }
    
    /**
     * Effectue les validations en cas de mise à jour
     * @param entite
     * @since 0.0.1
     */
    protected void checkValidityUpdate(E entite){
        // Rien par défaut
    }
    
    /**
     * Effectue les validations en cas de suppression
     * @param entity
     * @since 0.0.1
     */
    protected void checkValidityDelete(I id){
        // Rien par défaut
    }
    
}
