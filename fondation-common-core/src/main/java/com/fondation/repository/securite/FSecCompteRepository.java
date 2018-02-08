package com.fondation.repository.securite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fondation.domain.securite.FSecCompte;

/**
 * <p>
 *                          Repository des comptes utilisateurs 
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Repository
public interface FSecCompteRepository extends JpaRepository<FSecCompte, Long> {

    /**
     * Trouve un compte par son login
     * @param login
     * @return
     * @since 0.0.1
     */
    public Optional<FSecCompte> findByLogin(String login);
}
