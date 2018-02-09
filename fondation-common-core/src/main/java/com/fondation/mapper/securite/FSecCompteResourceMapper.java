package com.fondation.mapper.securite;

import org.mapstruct.Mapper;

import com.fondation.domain.securite.FSecCompte;
import com.fondation.mapper.common.EntiteResourceMapper;
import com.fondation.resource.securite.FSecCompteResource;

/**
 * <p>
 *                      Interface de définition d'un mapper pour les ressources Compte utilisateur
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Mapper
public abstract class FSecCompteResourceMapper extends EntiteResourceMapper<FSecCompte, FSecCompteResource>{

}
