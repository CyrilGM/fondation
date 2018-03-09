package com.fondation.securite.mapper;

import org.mapstruct.Mapper;

import com.fondation.common.mapper.EntiteResourceMapper;
import com.fondation.securite.domain.FndCompte;
import com.fondation.securite.resource.FndCompteResource;

/**
 * <p>
 *                      Interface de définition d'un mapper pour les ressources Compte utilisateur
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Mapper(componentModel="spring")
public abstract class FndCompteResourceMapper extends EntiteResourceMapper<FndCompte, FndCompteResource>{

}
