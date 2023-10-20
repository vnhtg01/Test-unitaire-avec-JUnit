# Test-unitaire-avec-JUnit

### Objectif:
L’objectif de ce TP est d’écrire et d’exécuter des tests avec JUnit pour une classe Java implémentant un conteneur de données **Conteneur**. À partir de la spécification informelle donnée, vous devez écrire un ensemble de classes JUnit de façon à pouvoir tester des implémentations de la classe **Conteneur** en boîte noire
### La classe *Conteneur* en Java est conçue pour stocker des couples clé-valeur. Voici un résumé de ses caractéristiques et fonctionnalités :

*Propriétés* :

- Les clés et les valeurs sont des instances de la classe **Object**.
- Ni les clés ni les valeurs ne peuvent être **null**.
- Une valeur peut être associée à plusieurs clés distinctes.
- La capacité du conteneur est fixée à l'initialisation et est strictement supérieure à 1.
- La capacité peut être augmentée uniquement lorsque le conteneur est plein.
- Le conteneur peut être vidé (tous les éléments supprimés) uniquement s'il n'est pas déjà vide.

- Le squelette de la classe Java Conteneur est le suivant :
```
public class Conteneur {
    public Conteneur(int n) throws ErreurConteneur { }
    public void ajouter(Object C, Object O) throws ErreurConteneur { }
    public void retirer(Object C) { }
    public void raz() throws ErreurConteneur { }
    public void redimensionner(int nouv) throws ErreurConteneur { }
    public boolean present(Object C) { }
    public Object valeur(Object C) throws ErreurConteneur { }
    public boolean estVide() { }
    public int taille() { }
    public int capacite() { }
}
```

avec les explications comme: 
- *Méthodes* :

    - **Conteneur(int n)**: Constructeur qui initialise le conteneur avec une capacité donnée n.
    - **ajouter(Object C, Object O)**: Ajoute un couple clé-valeur au conteneur. Si la clé est déjà présente, le couple existant est remplacé. Si le conteneur est plein, une exception DebordementConteneur est levée.
    - **retirer(Object C)**: Retire le couple associé à la clé C. Si la clé n'est pas présente, rien ne se passe.
    - **raz()**: Vide le conteneur. Cette méthode ne peut être utilisée que si le conteneur n'est pas déjà vide.
    - **redimensionner(int nouv)**: Redimensionne la capacité du conteneur. Elle peut seulement être utilisée lorsque le conteneur est plein.
    - **present(Object C)**: Vérifie si une clé C est présente dans le conteneur.
    - **valeur(Object C)**: Retourne la valeur associée à la clé C. Si la clé n'est pas présente, une exception ErreurConteneur est levée.
    - **estVide()**: Vérifie si le conteneur est vide.
    - **taille()**: Retourne le nombre de couples clé-valeur actuellement dans le conteneur.
    - **capacite()**: Retourne la capacité totale du conteneur.
- *Exceptions* :

    - **ErreurConteneur**: Exception générale pour les erreurs liées au conteneur.
    - **DebordementConteneur**: Exception spécifique levée lorsque le conteneur est plein et qu'on tente d'y ajouter un nouvel élément.
    - Ainsi, la classe **Conteneur** est une structure permettant de stocker et de gérer des couples clé-valeur avec des mécanismes de gestion d'erreurs et de redimensionnement.
 
### Introduction à JUnit 5.
JUnit est un outil permettant d’écrire et d’exécuter des tests unitaires sur des programmes Java. Il est intégré à Eclipse mais est également disponible à l’adresse **http://www.junit.org/**.
Un test en JUnit 5 est une méthode annotée par **@Test**. Les méthodes de test sont généralement regroupées en une classe dédiée aux tests. Le corps d’une méthode de test doit comporter quatre parties :
- le *préambule*, qui permet de créer les objets et de les amener dans l’état nécessaire pour
le test ;
- le *corps de test*, dans lequel la méthode à tester est appelée sur les objets créés ;
- l’*identification*, qui permet de délivrer le verdict du test (succès ou échec) en vérifiant
un ensemble de propriétés (assertions) sur l’état des objets après le test. Le tableau 1
résume les différentes assertions possibles en JUnit.
- le *postambule*, qui réinitialise les objets.
Il est possible de grouper les tests ayant un préambule commun (c’est-à-dire devant être exécutés dans le même état) en une classe et de définir une méthode qui exécutera ce préambule
avant chacun des tests de la classe. Cette méthode doit être annotée par @BeforeEach. De la
même manière, si tous les tests d’une classe ont un postambule commun, on peut définir une
méthode annotée par @AfterEach qui sera exécutée après chacun des tests de la classe.

### Probleme : creer les squelettes des quatre classes fournies:
- **TestInit** : Vérifie l’initialisation de **Conteneur**.
- **TestVide** : Vérifie les propriétés d’un **Conteneur** dans un état vide d’objets.
- **TestNonVide** : Vérifie les propriétés d’un **Conteneur** dans un état partiellement
rempli d’objets.
- **TestVide** : Vérifie les propriétés d’un **Conteneur** dans un état rempli d’objets.


