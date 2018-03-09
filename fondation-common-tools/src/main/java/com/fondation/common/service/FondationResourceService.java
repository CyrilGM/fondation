package com.fondation.common.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fondation.common.config.ApplicationContextAccessor;
import com.fondation.common.domain.IFondationIdentifiableEntite;
import com.fondation.common.helper.GenericsHelper;
import com.fondation.common.mapper.EntiteResourceMapper;
import com.fondation.common.resource.IFondationIdentifiableResource;

import io.vavr.collection.List;
import io.vavr.control.Option;

/**
 * <p>
 *                          Classe de base pour l'implémentation d'un service sur des ressources
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public class FondationResourceService<E extends IFondationIdentifiableEntite<I>,I extends Serializable,R extends IFondationIdentifiableResource<I>,S extends FondationEntiteService<E, I, ? extends JpaRepository<E,I>>,M extends EntiteResourceMapper<E,R>> extends FondationService {

    // Membres internes
    private M                                   mapper;
    private S                                   service;

    
    // ----------------------- Méthodes publiques ---------------------
    /**
     * Retourne la ressource dont l'id est passé en paramètres
     * @param id
     * @return
     * @since 0.0.1
     */
    public Option<R> get(I id) {
        Option<R> result = Option.none();
        if (id!=null){
            result = toResourceOption(this.getEntiteService().get(id));
        }
        return result;
    }

    /**
     * Crée une nouvelle ressource en base 
     * @param resource
     * @return
     * @since 0.0.1
     */
    public Option<R> create(R resource) {
        // L'implémentation de base consiste à transformer la ressource en entité puis à la créer
        Option<R> result = Option.none();
        E entite = getMapper().resourceToEntite(resource);
        if (entite!=null){
            result = toResourceOption(this.getEntiteService().create(entite));
        }
        return result;
    }

    /**
     * Met à jour une ressource en base
     * @param resource
     * @return
     * @since 0.0.1
     */
    public Option<R> update(R resource) {
        // L'implémentation de base consiste à transformer la ressource en entité puis à la créer
        Option<R> result = Option.none();
        E entite = getMapper().resourceToEntite(resource);
        if (entite!=null){
            result = toResourceOption(this.getEntiteService().update(entite));
        }
        return result;
    }

    /**
     * Supprime une entité en base
     * @param id
     * @since 0.0.1
     */
    public void delete(I id) {
        getEntiteService().delete(id);
    }
    
    /**
     * Effectue une recherche par pagination en base
     * @param pageable
     * @return
     * @since 0.0.1
     */
    public Option<Page<R>> findAll(Pageable pageable){
        return getEntiteService().findAll(pageable).flatMap(p->Option.of(p.map(e->getMapper().entiteToResource(e))));
    }
    
    /**
     * Effectue une recherche pour retourner l'intégralité des données
     * @return
     * @since 0.0.1
     */
    public List<R> findAll(){   
        return getMapper().entitesToResources(getEntiteService().findAll());
    }
    
    // -------------------------------- Méthodes protégées ---------------------------
    /**
     * Transforme une option sur une entité en une option sur une ressource
     * @param entiteOption
     * @return
     * @since 0.0.1
     */
    protected Option<R> toResourceOption(Option<E> entiteOption){
        return entiteOption.flatMap(e->Option.of(getMapper().entiteToResource(e)));
    }
    
    /**
     * Transforme une option sur une ressource en une option sur une entité
     * @param resourceOption
     * @return
     * @since 0.0.1
     */
    protected Option<E> toEntiteOption(Option<R> resourceOption){
        return resourceOption.flatMap(r->Option.of(getMapper().resourceToEntite(r)));
    }
    
    /**
     * Retourne le mapper de ressource
     * @return
     * @since 0.0.1
     */
    protected M getMapper(){
        if (this.mapper==null){
            this.mapper = this.retrieveMapper();
        }
        return this.mapper;
    }
    
    /**
     * Retourne le service d'entité lié
     * @return
     * @since 0.0.1
     */
    protected S getEntiteService(){
        if (this.service==null){
            this.service = this.retrieveEntiteService();
        }
        return this.service;
    }
    
    /**
     * Effectue l'initialisation du mapper lié
     * @return
     * @since 0.0.1
     */
    protected M retrieveMapper(){
        return ApplicationContextAccessor.getContext().getBean(GenericsHelper.getGenericArgumentClass(getClass(), 4));
    }
    
    /**
     * Effectue l'initialisation du service d'entité lié
     * @return
     * @since 0.0.1
     */
    protected S retrieveEntiteService(){
        return ApplicationContextAccessor.getContext().getBean(GenericsHelper.getGenericArgumentClass(getClass(), 3));
    }
}
