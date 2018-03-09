package com.fondation.common.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fondation.common.domain.IFondationEntite;
import com.fondation.common.mapper.EntiteResourceMapper;
import com.fondation.common.resource.IFondationResource;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private static List<MyEntite> ENTITES_LIST = List.of(
            MyEntite.of(1L, "CHAINE"),
            MyEntite.of(2L, "TEST"),
            null,
            MyEntite.of(3L, null)
    );
    
    private static List<MyResource> RESOURCES_LIST = List.of(
            MyResource.of(1L, "CHAINE"),
            MyResource.of(2L, "TEST"),
            null,
            MyResource.of(3L, null)
    );
    
    // Membres
    private MyMapper                        mapper = new MyMapper();
    
    // ----------------------------------- Tests -------------------------------
    /**
     * Teste qu'une liste d'entités valides est bien transformée en une liste de ressources valides
     * @since 0.0.1
     */
    @Test
    public void whenValidEntiteList_shouldMapResourceList(){
        List<MyResource> result = mapper.entitesToResources(ENTITES_LIST);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(RESOURCES_LIST);
        Option<List<MyResource>> option = mapper.entitesToResources(Option.of(ENTITES_LIST));
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
        List<MyResource> result = mapper.entitesToResources(List.empty());
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        Option<List<MyResource>> option = mapper.entitesToResources(Option.of(List.empty()));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEmpty();
    }
    
    /**
     * Teste qu'une liste d'entités nulle est bien transformée en une liste de ressources nulle
     * @since 0.0.1
     */
    @Test
    public void whenNullEntiteList_shouldMapNullList(){
        List<MyResource> result = mapper.entitesToResources((List<MyEntite>)null);
        assertThat(result).isNull();
        Option<List<MyResource>> option = mapper.entitesToResources(Option.of(null));
        assertThat(option.isEmpty()).isTrue();
    }
    
    /**
     * Teste qu'une liste de ressources valides est bien transformée en une liste d'entités valides
     * @since 0.0.1
     */
    @Test
    public void whenValidResourceList_shouldMapEntiteList(){
        List<MyEntite> result = mapper.resourcesToEntites(RESOURCES_LIST);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(ENTITES_LIST);
        Option<List<MyEntite>> option = mapper.resourcesToEntites(Option.of(RESOURCES_LIST));
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
        List<MyEntite> result = mapper.resourcesToEntites(List.empty());
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        Option<List<MyEntite>> option = mapper.resourcesToEntites(Option.of(List.empty()));
        assertThat(option.isEmpty()).isFalse();
        assertThat(option.get()).isEmpty();
    }
    
    /**
     * Teste qu'une liste de ressources nulle est bien transformée en une liste d'entités nulle
     * @since 0.0.1
     */
    @Test
    public void whenNullResourceList_shoulMapNullList(){
        List<MyEntite> result = mapper.resourcesToEntites((List<MyResource>)null);
        assertThat(result).isNull();
        Option<List<MyEntite>> option = mapper.resourcesToEntites(Option.of(null));
        assertThat(option.isEmpty()).isTrue();
    }
    
    
    
    
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
    @NoArgsConstructor
    @AllArgsConstructor(staticName="of")
    private static class MyEntite implements IFondationEntite {
        
        // Membres internes
        private Long id;
        private String chaine;
    }
    
    /**
     * <p>
     *                  Exemple de ressource interne
     * </p> 
     *
     * @author Cyril Chevalier
     * @since 0.0.1
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName="of")
    private static class MyResource implements IFondationResource {
        
        // Membres internes
        private Long id;
        private String chaine;
    }
    
    private static class MyMapper extends EntiteResourceMapper<MyEntite, MyResource> {

        // ---------------------- Surcharges ----------------------------
        /* (non-Javadoc)
         * @see com.fondation.mapper.common.EntiteResourceMapper#entiteToResource(com.fondation.domain.common.IFondationEntite)
         */
        @Override
        public MyResource entiteToResource(MyEntite entite) {
            MyResource resource = null;
            if (entite!=null){
                resource = new MyResource();
                resource.setId(entite.getId());
                resource.setChaine(entite.getChaine());
            }
            return resource;
        }

        /* (non-Javadoc)
         * @see com.fondation.mapper.common.EntiteResourceMapper#resourceToEntite(com.fondation.resource.common.IFondationResource)
         */
        @Override
        public MyEntite resourceToEntite(MyResource resource) {
            MyEntite entite = null;
            if (resource!=null){
                entite = new MyEntite();
                entite.setId(resource.getId());
                entite.setChaine(resource.getChaine());
            }
            return entite;
        }
        
    }
    
}
