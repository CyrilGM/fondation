package com.fondation.common.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fondation.test.domain.BasicEntite;
import com.fondation.test.mapper.BasicEntiteResourceMapper;
import com.fondation.test.mapper.BasicEntiteResourceMapperImpl;
import com.fondation.test.resource.BasicResource;

import io.vavr.collection.List;
import io.vavr.control.Option;

/**
 * <p>
 *                  Tests unitaires sur le mapper de base entre entités et ressources
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public class EntiteResourceMapperTest {

    // Constantes
    private static List<BasicEntite> ENTITES_LIST = List.of(
            BasicEntite.of(1L, "CHAINE"),
            BasicEntite.of(2L, "TEST"),
            null,
            BasicEntite.of(3L, null)
    );
    
    private static List<BasicResource> RESOURCES_LIST = List.of(
            BasicResource.of(1L, "CHAINE"),
            BasicResource.of(2L, "TEST"),
            null,
            BasicResource.of(3L, null)
    );
    
    // Membres
    private BasicEntiteResourceMapper                        mapper = new BasicEntiteResourceMapperImpl();
    
    // ----------------------------------- Tests -------------------------------
    /**
     * Teste qu'une liste d'entités valides est bien transformée en une liste de ressources valides
     * @since 0.0.1
     */
    @Test
    public void whenValidEntiteList_shouldMapResourceList(){
        List<BasicResource> result = mapper.entitesToResources(ENTITES_LIST);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(RESOURCES_LIST);
        Option<List<BasicResource>> option = mapper.entitesToResources(Option.of(ENTITES_LIST));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEqualTo(RESOURCES_LIST);
    }
    
    /**
     * Teste qu'une liste d'entités vide est bien transformée en une liste de ressources vide
     * 
     * @since 0.0.1
     */
    @Test
    public void whenEmptyEntiteList_shouldMapEmptyList(){
        List<BasicResource> result = mapper.entitesToResources(List.empty());
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        Option<List<BasicResource>> option = mapper.entitesToResources(Option.of(List.empty()));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEmpty();
    }
    
    /**
     * Teste qu'une liste d'entités nulle est bien transformée en une liste de ressources nulle
     * @since 0.0.1
     */
    @Test
    public void whenNullEntiteList_shouldMapNullList(){
        List<BasicResource> result = mapper.entitesToResources((List<BasicEntite>)null);
        assertThat(result).isNull();
        Option<List<BasicResource>> option = mapper.entitesToResources(Option.of(null));
        assertThat(option.isEmpty()).isTrue();
    }
    
    /**
     * Teste qu'une liste de ressources valides est bien transformée en une liste d'entités valides
     * @since 0.0.1
     */
    @Test
    public void whenValidResourceList_shouldMapEntiteList(){
        List<BasicEntite> result = mapper.resourcesToEntites(RESOURCES_LIST);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(ENTITES_LIST);
        Option<List<BasicEntite>> option = mapper.resourcesToEntites(Option.of(RESOURCES_LIST));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEqualTo(ENTITES_LIST);
    }
    
    /**
     * Teste qu'une liste de ressources vide est bien transformée en une liste d'entités vide
     * 
     * @since 0.0.1
     */
    @Test
    public void whenEmptyResourceList_shouldMapEmptyList(){
        List<BasicEntite> result = mapper.resourcesToEntites(List.empty());
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        Option<List<BasicEntite>> option = mapper.resourcesToEntites(Option.of(List.empty()));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEmpty();
    }
    
    /**
     * Teste qu'une liste de ressources nulle est bien transformée en une liste d'entités nulle
     * @since 0.0.1
     */
    @Test
    public void whenNullResourceList_shouldMapNullList(){
        List<BasicEntite> result = mapper.resourcesToEntites((List<BasicResource>)null);
        assertThat(result).isNull();
        Option<List<BasicEntite>> option = mapper.resourcesToEntites(Option.of(null));
        assertThat(option.isEmpty()).isTrue();
    }
}
