package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNonVide {
    private Conteneur C;
    private Object A1, A2, B1, B2;

    // Cr�ation d'un conteneur partiellement rempli
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

    // Objectif de test: V�rifier si un objet est pr�sent dans le conteneur
    // R�sultat attendu: L'objet est pr�sent
    @Test
    public void objetPresent() {
        assertTrue(C.present(A1));
        assertTrue(C.present(A2));
        assertFalse(C.present(new Object()));
    }

    // Objectif de test: Retirer un objet du conteneur
    // R�sultat attendu: L'objet a �t� retir�
    @Test
    public void retirerObjet() {
        C.retirer(A1);
        
        assertFalse(C.present(A1));
        assertTrue(C.present(A2));
        assertEquals(1, C.taille());
    }

    // Objectif de test: Tenter d'obtenir la valeur d'un objet pr�sent dans le conteneur
    // R�sultat attendu: Obtenir la valeur associ�e � l'objet
    @Test
    public void obtenirValeur() {
        try {
            assertEquals(B1, C.valeur(A1));
            assertEquals(B2, C.valeur(A2));
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly.");
        }

        // Attendez-vous � ce qu'une exception soit lev�e lorsque vous essayez 
        // d'obtenir la valeur d'un objet qui n'existe pas dans le Conteneur
        assertThrows(ErreurConteneur.class, () -> C.valeur(new Object()));
    }


    // Objectif de test: Ajouter un nouvel objet dans le conteneur
    // R�sultat attendu: L'objet a �t� ajout�
    @Test
    public void ajouterObjet() {
        Object A3 = new Object();
        Object B3 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A3, B3));

        assertTrue(C.present(A3));
        assertEquals(3, C.taille());
    }
    
    // Objectif de test: Ajouter un objet avec une cl� d�j� pr�sente dans le conteneur
    // R�sultat attendu: L'objet doit �tre ajout� sans lever d'exception, 
    // �crasant ainsi l'ancienne valeur
    @Test
    public void ajouterObjetExistant() {
        Object B3 = new Object();
        
        try {
            C.ajouter(A1, B3);  // Ajouter un nouvel objet avec une cl� existante (A1)
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly when trying to add an existing object.");
        }

        try {
            assertEquals(B3, C.valeur(A1));  // La nouvelle valeur de A1 doit �tre B3 maintenant
        } catch (ErreurConteneur e) {
            fail("ErreurConteneur was thrown unexpectedly when trying to retrieve the value.");
        }
    }
    
}


