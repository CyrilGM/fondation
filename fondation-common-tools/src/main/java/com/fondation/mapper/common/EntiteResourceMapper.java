package com.fondation.mapper.common;

import com.fondation.domain.common.IFondationEntite;
import com.fondation.resource.common.IFondationResource;

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
    
    
}
