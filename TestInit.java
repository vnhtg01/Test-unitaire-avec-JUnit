package test;

import testEtat.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInit {

    // Objectif de test: Créer un conteneur avec une capacité supérieure à 1
    // Résultat attendu: Un conteneur vide est créé avec la capacité fournie en argument
    @Test
    public void capaciteSup1() {
        // On force le test a echouer si une exception est levee
        // On recupere le conteneur si tout se passe correctement
        Conteneur C = assertDoesNotThrow(() -> new Conteneur(5));

        assertNotNull(C);
        
        assertTrue(C.estVide());
        assertEquals(0, C.taille());
        assertEquals(5, C.capacite());
    }

    // Objectif de test: Créer un conteneur avec la capacité minimum (c'est-à-dire 2)
    // Résultat attendu: Un conteneur vide est créé avec la capacité fournie en argument
    @Test
    public void capaciteMin() {
        Conteneur C = assertDoesNotThrow(() -> new Conteneur(2));

        assertNotNull(C);
        
        assertTrue(C.estVide());
        assertEquals(0, C.taille());
        assertEquals(2, C.capacite());
    }

    // Objectif de test: Essayer de créer un conteneur avec une capacité invalide (<= 1)
    // Résultat attendu: Une exception de type ErreurConteneur est levée
    @Test
    public void capaciteInvalide() {
        assertThrows(ErreurConteneur.class, () -> new Conteneur(1));
        assertThrows(ErreurConteneur.class, () -> new Conteneur(0));
    }
}
