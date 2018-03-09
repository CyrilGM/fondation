package com.fondation.common.config;

import org.springframework.context.ApplicationContext;

/**
 * <p>
 *              Classe statique permettant d'accéder au contexte d'application Spring depuis des classes qui ne sont pas gérées par le conteneur Spring
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public class ApplicationContextAccessor {
    
    // Membres statiques internes
    protected static ApplicationContext                     context;
    
    /**
     * 
     */
    private ApplicationContextAccessor() {
    }
    
    // ----------------------- Méthodes publiques ---------------------
    /**
     * Retourne le contexte d'application Spring
     * @return
     * @since 0.0.1
     */
    public static ApplicationContext getContext(){
        return context;
    }
    
    /**
     * Positionne le contexte d'application Spring
     * @param context
     * @since 0.0.1
     */
    public static void setContext(ApplicationContext context){
        ApplicationContextAccessor.context = context;
    }
}
