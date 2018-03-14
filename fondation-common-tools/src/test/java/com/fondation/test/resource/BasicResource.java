package com.fondation.test.resource;

import com.fondation.common.resource.IFondationIdentifiableResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 *                      Classe de test : ressource basique
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@Data
@Builder
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor(staticName="of")
public class BasicResource implements IFondationIdentifiableResource<Long> {

    // Membres internes
    private Long                        id;
    private String                      chaine;
}
