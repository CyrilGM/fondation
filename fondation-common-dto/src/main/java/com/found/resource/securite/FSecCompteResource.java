package com.found.resource.securite;

import lombok.Data;

/**
 * <p>
 *                      
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Data
public class FSecCompteResource {

    // Membres internes
    private Long                        id;
    private String                      login;
    private String                      password;
}
