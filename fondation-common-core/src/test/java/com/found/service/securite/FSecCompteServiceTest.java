package com.found.service.securite;

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

import com.found.domain.securite.FSecCompte;
import com.found.mapper.securite.FSecCompteResourceMapper;
import com.found.mapper.securite.FSecCompteResourceMapperImpl;
import com.found.repository.securite.FSecCompteRepository;
import com.found.resource.securite.FSecCompteResource;

import io.vavr.control.Option;

/**
 * <p>
 * 
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
public class FSecCompteServiceTest {

    @MockBean
    private FSecCompteRepository                    compteRepo;
    @Autowired
    private FSecCompteService                       compteService;
    
    // --------------------------------------------- Configuration ------------------------------
    
    @TestConfiguration
    static class FSecCompteServiceTestConfiguration {
        
        @Bean
        public FSecCompteService service(){
            return new FSecCompteService();
        }
        
        @Bean
        public FSecCompteResourceMapper mapper(){
            return new FSecCompteResourceMapperImpl();
        }
    }
    
    /**
     * Configuration des tests 
     * @since 0.0.1
     */
    @Before
    public void setup(){
        FSecCompte compte = new FSecCompte();
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
        FSecCompteResource waitedCompte = new FSecCompteResource();
        waitedCompte.setId(1L);
        waitedCompte.setLogin("TEST");
        waitedCompte.setPassword("TEST");
        
        String login = "TEST";
        Option<FSecCompteResource> compte = this.compteService.findSecCompteByLogin(login);
        assertThat(compte.isEmpty()).isFalse();
        assertThat(compte.get()).isEqualTo(waitedCompte);
    }
    
    
}
