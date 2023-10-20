package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNonVide {
    private Conteneur C;
    private Object A1, A2, B1, B2;

    // Création d'un conteneur partiellement rempli
    @BeforeEach 
    public void creerConteneurNonVide() {
        C = assertDoesNotThrow(() -> new Conteneur(5));

        A1 = new Object();
        A2 = new Object();
        B1 = new Object();
        B2 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));
    }

    // Objectif de test: Vérifier si un objet est présent dans le conteneur
    // Résultat attendu: L'objet est présent
    @Test
    public void objetPresent() {
        assertTrue(C.present(A1));
        assertTrue(C.present(A2));
        assertFalse(C.present(new Object()));
    }

    // Objectif de test: Retirer un objet du conteneur
    // Résultat attendu: L'objet a été retiré
    @Test
    public void retirerObjet() {
        C.retirer(A1);
        
        assertFalse(C.present(A1));
        assertTrue(C.present(A2));
        assertEquals(1, C.taille());
    }

    // Objectif de test: Tenter d'obtenir la valeur d'un objet présent dans le conteneur
    // Résultat attendu: Obtenir la valeur associée à l'objet
    @Test
    public void obtenirValeur() {
        try {
            assertEquals(B1, C.valeur(A1));
            assertEquals(B2, C.valeur(A2));
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly.");
        }

        // Attendez-vous à ce qu'une exception soit levée lorsque vous essayez 
        // d'obtenir la valeur d'un objet qui n'existe pas dans le Conteneur
        assertThrows(ErreurConteneur.class, () -> C.valeur(new Object()));
    }


    // Objectif de test: Ajouter un nouvel objet dans le conteneur
    // Résultat attendu: L'objet a été ajouté
    @Test
    public void ajouterObjet() {
        Object A3 = new Object();
        Object B3 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A3, B3));

        assertTrue(C.present(A3));
        assertEquals(3, C.taille());
    }
    
    // Objectif de test: Ajouter un objet avec une clé déjà présente dans le conteneur
    // Résultat attendu: L'objet doit être ajouté sans lever d'exception, 
    // écrasant ainsi l'ancienne valeur
    @Test
    public void ajouterObjetExistant() {
        Object B3 = new Object();
        
        try {
            C.ajouter(A1, B3);  // Ajouter un nouvel objet avec une clé existante (A1)
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly when trying to add an existing object.");
        }

        try {
            assertEquals(B3, C.valeur(A1));  // La nouvelle valeur de A1 doit être B3 maintenant
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly when trying to retrieve the value.");
        }
    }
    
}


