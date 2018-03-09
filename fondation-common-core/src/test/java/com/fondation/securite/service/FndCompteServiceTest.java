package com.fondation.securite.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fondation.securite.mapper.FndCompteResourceMapperImpl;
import com.fondation.securite.domain.FndCompte;
import com.fondation.securite.mapper.FndCompteResourceMapper;
import com.fondation.securite.repository.FndCompteRepository;
import com.fondation.securite.resource.FndCompteResource;

import io.vavr.control.Option;

/**
 * <p>
 *                          Tests sur le service d'accès aux comptes
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
public class FndCompteServiceTest {

    @MockBean
    private FndCompteRepository                    compteRepo;
    @Autowired
    private FndCompteService                       compteService;
    
    // --------------------------------------------- Configuration ------------------------------
    
    @TestConfiguration
    static class FndCompteServiceTestConfiguration {
        
        @Bean
        public FndCompteService service(){
            return new FndCompteService();
        }
        
        @Bean
        public FndCompteResourceMapper mapper(){
            return new FndCompteResourceMapperImpl();
        }
    }
    
    /**
     * Configuration des tests 
     * @since 0.0.1
     */
    @Before
    public void setup(){
        FndCompte compte = new FndCompte();
        compte.setId(1L);
        compte.setLogin("TEST");
        compte.setPassword("TEST");
        
        Mockito.when(compteRepo.findByLogin("TEST")).thenReturn(Optional.of(compte));
    }
    
    // ------------------------------------------- Tests -----------------------------------------
    /**
     * Teste que les comptes soient bien trouvés 
     * @since 0.0.1
     */
    @Test
    public void whenValidLogin_thenCompteShouldBeFound(){
        FndCompteResource waitedCompte = new FndCompteResource();
        waitedCompte.setId(1L);
        waitedCompte.setLogin("TEST");
        waitedCompte.setPassword("TEST");
        
        String login = "TEST";
        Option<FndCompteResource> compte = this.compteService.findSecCompteByLogin(login);
        assertThat(compte.isEmpty()).isFalse();
        assertThat(compte.get()).isEqualTo(waitedCompte);
    }
    
    
}
