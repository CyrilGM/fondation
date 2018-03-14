package com.fondation.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fondation.common.domain.IFondationIdentifiableEntite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 *                      Classe de test : entité basique
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
@Entity
@Table
public class BasicEntite implements IFondationIdentifiableEntite<Long> {

    // Membres internes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long                    id;
    private String                  chaine;
}
