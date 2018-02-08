package com.fondation.domain.securite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fondation.domain.common.IFondationStdEntite;

import lombok.Data;

/**
 * <p>
 *              Entité représentant un compte
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Entity
@Data
public class FSecCompte implements IFondationStdEntite {

    // Membres privés
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long                    id;
    @NotNull
    private String                  login;
    @NotNull
    private String                  password;
}
