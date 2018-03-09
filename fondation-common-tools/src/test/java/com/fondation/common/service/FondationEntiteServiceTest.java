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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.fondation.common.domain.IFondationIdentifiableEntite;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private MyEntiteRepository                      repo;
    @Autowired
    private MyService                               service;

    // --------------------------------------------- Configuration ------------------------------
    
    @TestConfiguration
    static class FondationEntiteServiceTestConfig {
        
        @Bean
        public MyService service(){
            return new MyService();
        }
        
    }
    
    /**
     * Configuration des tests 
     * @since 0.0.1
     */
    @Before
    public void setup(){
        MyEntite entite = MyEntite.of(0L, "TEST");
        Mockito.when(repo.findOne(0L)).thenReturn(entite);
    }

    // ----------------------------------------------- Tests -------------------------------------------
    @Test
    public void whenValidGetId_thenEntiteShouldBeFound(){
        Option<MyEntite> entite = service.get(0L);
        assertThat(entite.isDefined()).isTrue();
        assertThat(entite.get()).isEqualTo(MyEntite.of(0L, "TST"));
    }
    
    // ------------------- Méthodes protégées -------------------------

    // ---------------------- Classes internes ----------------
    /**
     * <p>
     *                  Exemple d'entité interne
     * </p> 
     *
     * @author Cyril Chevalier
     * @since 0.0.1
     */
    @Data
    @EqualsAndHashCode(of={"id"})
    @NoArgsConstructor
    @AllArgsConstructor(staticName="of")
    private static class MyEntite implements IFondationIdentifiableEntite<Long> {
        
        // Membres internes
        private Long id;
        private String chaine;
    }
    
   
    /**
     * 
     * <p>
     *                  Repository sur MyEntite
     * </p> 
     *
     * @author Cyril Chevalier
     * @since 0.0.1
     */
    private static interface MyEntiteRepository extends JpaRepository<MyEntite, Long> {
        
    }
    
    /**
     * 
     * <p>
     *                 Service de base sur les entités
     * </p> 
     *
     * @author Cyril Chevalier
     * @since 0.0.1
     */
    private static class MyService extends FondationEntiteService<MyEntite, Long, MyEntiteRepository> {
        
    }
    
    
}
