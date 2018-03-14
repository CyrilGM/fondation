package com.fondation.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fondation.test.domain.BasicEntite;

/**
 * <p>
 *                  Interface de test : repository sur une entité basique
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Repository
public interface BasicEntiteRepository extends JpaRepository<BasicEntite, Long> {

}
