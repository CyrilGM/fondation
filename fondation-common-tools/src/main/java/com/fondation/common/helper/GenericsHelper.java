package com.fondation.common.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>
 *                          Classe abstraite d'aide pour la gestion de la généricité
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
public abstract class GenericsHelper {

    private GenericsHelper(){
        
    }
    
    // ------------ Méthodes statiques publiques ---------------
    /**
     * Permet de retourner la classe d'un type générique pour une classe donnée
     * @param current Classe
     * @param argIndex Index de l'argument (basé sur 0)
     * @return
     * @since 0.0.1
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getGenericArgumentClass(Class<?> clazz,int argIndex) {
        try {
            Class<T> result = null;
            
            Class<?> current = clazz;
            Type supertype = current.getGenericSuperclass();
            while (supertype!=null){
                if (supertype instanceof ParameterizedType){
                    result = (Class<T>)((ParameterizedType)supertype).getActualTypeArguments()[argIndex];
                    break;
                }
                else {
                    current = current.getSuperclass();
                    supertype = (current!=null ? current.getGenericSuperclass() : null);
                }
            }
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
