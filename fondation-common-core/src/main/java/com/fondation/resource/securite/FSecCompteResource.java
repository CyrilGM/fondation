package com.fondation.resource.securite;

import com.fondation.resource.common.IFondationStdResource;

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
public class FSecCompteResource implements IFondationStdResource {

    // Membres internes
    private Long                        id;
    private String                      login;
    private String                      password;
}
