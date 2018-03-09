package com.fondation.securite.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fondation.securite.domain.FndCompte;
import com.fondation.securite.repository.FndCompteRepository;

/**
 * <p>
 *                      Tests du repository des comptes utilisateurs
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class FndCompteRepositoryTest {

    // --------------------------------------- Injections --------------------------------------
    @Inject
    private TestEntityManager               em;
    @Inject
    private FndCompteRepository             compteRepo;
    
    // -------------------------------------- Tests --------------------------------------------
    /**
     * Teste que la recherche par login fonctionne bien
     * @since 0.0.1
     */
    @Test
    public void whenFindByLogin_thenReturnCompte(){
        FndCompte compte = new FndCompte();
        compte.setLogin("TEST");
        compte.setPassword("TEST");
        compte = em.persist(compte);
        em.flush();
        
        Optional<FndCompte> found = compteRepo.findByLogin(compte.getLogin());
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo(compte);
    }
    
}
