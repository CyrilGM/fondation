package com.fondation.test.mapper;

import org.mapstruct.Mapper;

import com.fondation.common.mapper.EntiteResourceMapper;
import com.fondation.test.domain.BasicEntite;
import com.fondation.test.resource.BasicResource;

/**
 * <p>
 *                      Classe de test : implémentation d'un mapper de test
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Mapper(componentModel="spring")
public abstract class BasicEntiteResourceMapper extends EntiteResourceMapper<BasicEntite, BasicResource> {


}
