package com.fondation.domain.common;

/**
 * <p>
 *                      Interface représentant une entité identifiable
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public interface IFondationIdentifiableEntite<I> extends IFondationEntite {

    /**
     * Retourne l'id de l'entité
     * @return
     * @since 0.0.1
     */
    public I getId();
    
    /**
     * Positionne l'id de l'entité
     * @param id
     * @since 0.0.1
     */
    public void setId(I id);
}
