package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlein {
    private Conteneur C;
    private Object A1, A2, A3, A4, A5, B1, B2, B3, B4, B5;

    // Creation d'un conteneur plein
    @BeforeEach
    public void creerConteneurPlein() {
        C = assertDoesNotThrow(() -> new Conteneur(5));

        A1 = new Object();
        A2 = new Object();
        A3 = new Object();
        A4 = new Object();
        A5 = new Object();
        B1 = new Object();
        B2 = new Object();
        B3 = new Object();
        B4 = new Object();
        B5 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));
        assertDoesNotThrow(() -> C.ajouter(A3, B3));
        assertDoesNotThrow(() -> C.ajouter(A4, B4));
        assertDoesNotThrow(() -> C.ajouter(A5, B5));
    }

    // Objectif de test : Ajout d'un element dont la cle est deja presente dans un conteneur plein
    // Resultat attendu : Ajout possible et ancien couple de meme cle ecrase
    @Test
    public void ajouterPresentPlein() {
        Object B = new Object();

        // On force le test a echouer si une exception est levee
        assertDoesNotThrow(() -> C.ajouter(A2, B));

        assertTrue(C.present(A2));

        // On force le test a echouer si une exception est levee
        // Si aucune exception n'est levee, on verifie que B
        // est bien le nouveau couple de la cle A2
        assertEquals(B, assertDoesNotThrow(() -> C.valeur(A2)));

        // on verifie que le conteneur n'a pas ete modifie
        assertEquals(C.taille(), 5);
        assertEquals(C.capacite(), 5);
    }
    
    // Objectif de test : Ajouter un nouvel �l�ment � un conteneur plein
    // R�sultat attendu : Lev�e de l'exception ErreurConteneur car le conteneur est plein
    @Test
    public void ajouterNouveauPlein() {
        Object A6 = new Object();
        Object B6 = new Object();

        // On attend une exception de type ErreurConteneur
        assertThrows(ErreurConteneur.class, () -> C.ajouter(A6, B6));

        // on v�rifie que le conteneur n'a pas �t� modifi�
        assertEquals(C.taille(), 5);
        assertEquals(C.capacite(), 5);
    }

    // Objectif de test : Remise � z�ro d'un conteneur plein
    // R�sultat attendu : Le conteneur doit �tre vid�
    @Test
    public void razPlein() {
        // On ne s'attend � aucune exception
        assertDoesNotThrow(() -> C.raz());

        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
        assertEquals(C.capacite(), 5);
    }
    
    // Objectif de test : Retirer un �l�ment d'un conteneur plein
    // R�sultat attendu : Le conteneur a une taille r�duite de 1 et l'�l�ment sp�cifi� n'est plus pr�sent    
    @Test
    public void retirerPlein() {

        assertDoesNotThrow(() -> C.retirer(A3));
        assertEquals(4, C.taille());
        assertFalse(C.present(A3));
        assertEquals(5, C.capacite());
    }
    
    // Objectif de test : Obtenir la valeur d'un �l�ment dans un conteneur plein
    // R�sultat attendu : La valeur correcte est retourn�e sans exception    
    @Test
    public void valeurPlein() {
        assertEquals(B1, assertDoesNotThrow(() -> C.valeur(A1)));
    }

    // Objectif de test : Essayer d'obtenir la valeur d'un �l�ment non existant dans un conteneur plein
    // R�sultat attendu : Lev�e de l'exception ErreurConteneur
    @Test
    public void valeurInexistantePlein() {
        Object A6 = new Object();
        assertThrows(ErreurConteneur.class, () -> C.valeur(A6));
    }
    
    // Objectif de test : V�rifier la pr�sence d'un �l�ment dans un conteneur plein
    // R�sultat attendu : L'�l�ment est pr�sent
    @Test
    public void presentPlein() {
        assertTrue(C.present(A1));
    }
    
    // Objectif de test : V�rifier la non-pr�sence d'un �l�ment dans un conteneur plein
    // R�sultat attendu : L'�l�ment n'est pas pr�sent
    @Test
    public void notPresentPlein() {
        Object A7 = new Object();
        assertFalse(C.present(A7));
    }
}
