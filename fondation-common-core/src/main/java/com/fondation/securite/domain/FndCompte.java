package com.fondation.securite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fondation.common.domain.IFondationStdEntite;

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
@Table(schema="securite")
public class FndCompte implements IFondationStdEntite {

    // Membres privés
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long                    id;
    @NotNull
    private String                  login;
    @NotNull
    private String                  password;
}
