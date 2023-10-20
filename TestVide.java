package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVide {
    private Conteneur C;

    // Cr�ation d'un conteneur vide
    @BeforeEach
    public void creerConteneurVide() {
        C = assertDoesNotThrow(() -> new Conteneur(10));
    }

    // Objectif de test: Tenter de remettre � z�ro un conteneur d�j� vide
    // R�sultat attendu: Lev�e de l'exception ErreurConteneur
    @Test
    public void razVide() {
        // on force le test a echouer si aucune exception n'est levee
        // si une exception de type ErreurConteneur est levee, le test reussit
        assertThrows(ErreurConteneur.class, () -> C.raz());
        
        // on verifie que le conteneur n'a pas ete modifie
        assertTrue(C.estVide());
        assertEquals(0, C.taille());
        assertEquals(10, C.capacite());
    }

    // Objectif de test: V�rifier si un objet est pr�sent dans un conteneur vide
    // R�sultat attendu: L'objet n'est pas pr�sent
    @Test
    public void objetNonPresent() {
        assertFalse(C.present(new Object()));
    }

    // Objectif de test: Tenter de retirer un objet d'un conteneur vide
    // R�sultat attendu: Conteneur reste vide, aucun changement
    @Test
    public void retirerVide() {
        Object cle = new Object();
        C.retirer(cle);
        
        assertTrue(C.estVide());
        assertEquals(0, C.taille());
        assertEquals(10, C.capacite());
    }

    // Objectif de test: Tenter d'obtenir la valeur d'un objet d'un conteneur vide
    // R�sultat attendu: Lev�e de l'exception ErreurConteneur
    @Test
    public void valeurVide() {
        Object cle = new Object();
        assertThrows(ErreurConteneur.class, () -> C.valeur(cle));
    }
}
