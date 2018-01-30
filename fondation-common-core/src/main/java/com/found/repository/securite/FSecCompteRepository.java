package com.found.repository.securite;

import org.springframework.data.jpa.repository.JpaRepository;

import com.found.domain.securite.FSecCompte;

/**
 * <p>
 *                          Repository des comptes utilisateurs 
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public interface FSecCompteRepository extends JpaRepository<FSecCompte, Long> {

}
