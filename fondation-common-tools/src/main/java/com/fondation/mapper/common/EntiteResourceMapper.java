package com.fondation.mapper.common;

import com.fondation.domain.common.IFondationEntite;
import com.fondation.resource.common.IFondationResource;

import io.vavr.collection.Traversable;
import io.vavr.control.Option;

/**
 * <p>
 *                  Classe de base représentant un mapper d'une ressource vers une entité et inversement
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public abstract class EntiteResourceMapper<E extends IFondationEntite,R extends IFondationResource> {

    /**
     * Transforme une entité en une ressource
     * @param entite Entité
     * @return
     * @since 0.0.1
     */
    public abstract R entiteToResource(E entite);
    
    /**
     * Transforme une ressource en une entité
     * @param resource Ressource
     * @return
     * @since 0.0.1
     */
    public abstract E resourceToEntite(R resource);
    
    /**
     * Transforme une collection d'entités en une collection de ressources
     * @param entites Collection d'entités
     * @return
     * @since 0.0.1
     */
    @SuppressWarnings("unchecked")
    public <T extends Traversable<E>,U extends Traversable<R>> U entitesToResources(T entites){
        return (U)entitesToResources(Option.of(entites)).getOrElse((U)null);
    }
    
    /**
     * Transforme une collection d'entités en une collection de ressources
     * @param entites Collection d'entités
     * @return
     * @since 0.0.1
     */
    @SuppressWarnings("unchecked")
    public <T extends Traversable<E>,U extends Traversable<R>> Option<U> entitesToResources(Option<T> entites){
        return (Option<U>)entites.map(l->l.map(this::entiteToResource));
    }

    /**
     * Transforme une collection de ressources en une collection d'entités
     * @param ressources Collection de ressources
     * @return
     * @since 0.0.1
     */
    @SuppressWarnings("unchecked")
    public <T extends Traversable<R>,U extends Traversable<E>> U resourcesToEntites(T resources){
        return (U)resourcesToEntites(Option.of(resources)).getOrElse((U)null);
    }
    
    /**
     * Transforme une collection de ressources en une collection d'entités
     * @param ressources Collection de ressources
     * @return
     * @since 0.0.1
     */
    @SuppressWarnings("unchecked")
    public <T extends Traversable<R>,U extends Traversable<E>> Option<U> resourcesToEntites(Option<T> entites){
        return (Option<U>)entites.map(l->l.map(this::resourceToEntite));
    }
}
