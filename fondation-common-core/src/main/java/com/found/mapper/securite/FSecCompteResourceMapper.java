package com.found.mapper.securite;

import java.util.List;

import org.mapstruct.Mapper;

import com.found.domain.securite.FSecCompte;
import com.found.resource.securite.FSecCompteResource;

/**
 * <p>
 *                      Interface de définition d'un mapper pour les ressources Compte utilisateur
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Mapper
public interface FSecCompteResourceMapper {

    /**
     * Transforme les entités en ressources
     * @param compte
     * @return
     * @since 0.0.1
     */
    public FSecCompteResource entityToResource(FSecCompte compte);
    
    /**
     * Transforme les listes d'entités en liste de ressources
     * @param compte
     * @return
     * @since 0.0.1
     */
    public List<FSecCompteResource> entityListToResourceList(List<FSecCompte> comptes);
    
    /**
     * Transforme les ressources en entités
     * @param resource
     * @return
     * @since 0.0.1
     */
    public FSecCompte resourceToEntity(FSecCompteResource resource);
    
    /**
     * Transforme les listes de ressources en liste d'entités
     * @param resources
     * @return
     * @since 0.0.1
     */
    public List<FSecCompte> resourceListToEntityList(List<FSecCompteResource> resources);
}
