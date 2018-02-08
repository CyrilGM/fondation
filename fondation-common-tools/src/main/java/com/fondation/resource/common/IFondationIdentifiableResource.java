package com.fondation.resource.common;

/**
 * <p>
 *                          Interface représentant une ressource identifiable
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public interface IFondationIdentifiableResource<I> extends IFondationResource {

    /**
     * Retourne un identifiant
     * @return
     * @since 0.0.1
     */
    public I getId();
    
    /**
     * Positionne un identifiant
     * @param id
     * @since 0.0.1
     */
    public void setId(I id);
}
