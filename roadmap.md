# Roadmap/to-do list (<u>non-exhaustive</u>)

## Code, documentation et partie technique

- [x] Schémas et diagrammes de la base de données
- [x] Configuration Docker compose pour la BDD PostgreSQL
- [x] Structure du dépôt (répertoires) pour accueillir le code
- [x] Script de création des tables
- [x] Création du projet Java (système de build IntelliJ)
- [x] Décomposition en couches MVC (différents packages)
- [ ] Développer la couche de connexion à la BDD
- [ ] Développer la couche métier
- [ ] Développer la couche interface graphique
- [ ] Développer la couche controller
- [ ] Diagrammes de classes UML
- [x] Développer les classes Java fondamentales
  - `Role`
  - `Country`
  - `City`
  - `Employee`
  - `Vat`
  - `Category`
  - `Brand`
  - `Supplier`
  - `Product`
  - `PriceHistory`
  - `Customer`
  - `Purchase`
  - `OrderLine`

## Fonctionnalités métier

- [ ] **Gérer le stock**
  - [ ] Page de login
  - [ ] Partie dédiée au directeur
    - [ ] Créer d'un employé
    - [ ] Gérer des employés
      - [ ] Modifier un employé
      - [ ] Supprimer un employé
  - [ ] Partie dédiée aux articles
    - [ ] Créer un article
    - [ ] Rechercher un article
      - [ ] Supprimer un article
      - [ ] Modifier un article
      - [ ] Mdifier le prix (interaction avec la table `price_history`)
    - [ ] Rechercher à partir de certains attributs (ex: nom, prix, etc)
    - [ ] Tri
    - [ ] Afficher les articles épuisés
- [ ] **Gérer les clients et les achats**
  - [ ] Créer un achat
    - [ ] Gérer les quantités
    - [ ] Modifier un achat (sur base du numéro unique d'achat)
    - [ ] Supprimer un achat (sur base du numéro unique d'achat)
    - [ ] Créer une carte de fidélité
    - [ ] Modifier une carte de fidélité (sur base du numéro unique de la carte)
    - [ ] Supprimer une carte de fidélité (sur base du numéro unique de la carte)
