package com.fondation.test.service;

import org.springframework.stereotype.Service;

import com.fondation.common.service.FondationEntiteService;
import com.fondation.test.domain.BasicEntite;
import com.fondation.test.repository.BasicEntiteRepository;

/**
 * <p>
 *                  Service de test : service sur une entité basique
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Service
public class BasicEntiteService extends FondationEntiteService<BasicEntite, Long, BasicEntiteRepository> {

}
