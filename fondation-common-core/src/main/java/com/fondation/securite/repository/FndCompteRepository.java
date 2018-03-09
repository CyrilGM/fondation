package com.fondation.securite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fondation.securite.domain.FndCompte;

/**
 * <p>
 *                          Repository des comptes utilisateurs 
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Repository
public interface FndCompteRepository extends JpaRepository<FndCompte, Long> {

    /**
     * Trouve un compte par son login
     * @param login
     * @return
     * @since 0.0.1
     */
    public Optional<FndCompte> findByLogin(String login);
}
