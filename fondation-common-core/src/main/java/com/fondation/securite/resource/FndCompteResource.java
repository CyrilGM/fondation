package com.fondation.securite.resource;

import com.fondation.common.resource.IFondationStdResource;

import lombok.Data;

/**
 * <p>
 *                    Ressource représentant un compte utilisateur    
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Data
public class FndCompteResource implements IFondationStdResource {

    // Membres internes
    private Long                        id;
    private String                      login;
    private String                      password;
}
