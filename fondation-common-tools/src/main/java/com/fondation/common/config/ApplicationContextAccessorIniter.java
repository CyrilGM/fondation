package com.fondation.common.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *                          Initialiseur de contexte d'application Spring
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Configuration
public class ApplicationContextAccessorIniter implements ApplicationContextAware {

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextAccessor.setContext(applicationContext);
    }

}
