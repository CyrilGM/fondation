package com.fondation.common.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fondation.test.domain.BasicEntite;
import com.fondation.test.repository.BasicEntiteRepository;
import com.fondation.test.service.BasicEntiteService;

import io.vavr.control.Option;

/**
 * <p>
 *                      Test de fonctionnement du service de base de gestion des entités
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FondationEntiteServiceTest {
    
    // Membres internes
    @MockBean
    private BasicEntiteRepository                   repo;
    @Autowired
    private BasicEntiteService                      service;

    // --------------------------------------------- Configuration ------------------------------
    /**
     * <p>
     *                  Configuration interne pour les tests 
     * </p> 
     *
     * @author Cyril Chevalier
     * @since 0.0.1
     */
    @TestConfiguration
    static class FondationEntiteServiceTestConfig {
        
        @Bean
        public BasicEntiteService service(){
            return new BasicEntiteService();
        }
        
    }
    
    // -------------------------------------------- Setup -----------------------------------------
    /**
     * Configuration des tests 
     * @since 0.0.1
     */
    @Before
    public void setup(){
        BasicEntite entite = BasicEntite.of(0L, "TEST");
        Mockito.when(repo.findOne(0L)).thenReturn(entite);
    }

    // ----------------------------------------------- Tests -------------------------------------------
    /**
     * Test de récupération
     * @since 0.0.1
     */
    @Test
    public void whenValidGetId_thenEntiteShouldBeFound(){
        Option<BasicEntite> entite = service.get(0L);
        assertThat(entite.isDefined()).isTrue();
        assertThat(entite.get()).isEqualTo(BasicEntite.of(0L, "TST"));
    }
    

    
    
}
