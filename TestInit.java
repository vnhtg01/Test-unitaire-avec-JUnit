package test;

import testEtat.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInit {

    // Objectif de test: Cr�er un conteneur avec une capacit� sup�rieure � 1
    // R�sultat attendu: Un conteneur vide est cr�� avec la capacit� fournie en argument
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

    // Objectif de test: Cr�er un conteneur avec la capacit� minimum (c'est-�-dire 2)
    // R�sultat attendu: Un conteneur vide est cr�� avec la capacit� fournie en argument
    @Test
    public void capaciteMin() {
        Conteneur C = assertDoesNotThrow(() -> new Conteneur(2));

        assertNotNull(C);
        
        assertTrue(C.estVide());
        assertEquals(0, C.taille());
        assertEquals(2, C.capacite());
    }

    // Objectif de test: Essayer de cr�er un conteneur avec une capacit� invalide (<= 1)
    // R�sultat attendu: Une exception de type ErreurConteneur est lev�e
    @Test
    public void capaciteInvalide() {
        assertThrows(ErreurConteneur.class, () -> new Conteneur(1));
        assertThrows(ErreurConteneur.class, () -> new Conteneur(0));
    }
}
