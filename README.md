# Donjons & Dragons - Jeu Java

## Description du projet

Le but de ce projet est de créer un jeu inspiré des jeux de plateau de l’univers **Donjons & Dragons**, en utilisant le langage **Java**.  
Ce projet se découpe en plusieurs itérations, au cours desquelles de nouvelles fonctionnalités seront ajoutées.

Le jeu fonctionne dans la **console de l’IDE**. Il affiche les informations et le joueur peut saisir des instructions telles que :  
choisir la classe du personnage, nommer le personnage, lancer un dé, ou quitter le jeu.

> Les règles fournies constituent une base de réflexion. Vous êtes libre d’ajouter des classes supplémentaires, de modifier les ennemis, ajuster les points de vie ou la répartition des ennemis pour personnaliser votre jeu.

---

## Table des matières

1. [Règles du jeu](#règles-du-jeu)
2. [Le plateau de jeu](#le-plateau-de-jeu)
3. [Personnages](#personnages)
4. [Caisses surprises](#caisses-surprises)
5. [Équipements offensifs](#équipements-offensifs)
6. [Ennemis](#ennemis)
7. [Déroulement du jeu](#déroulement-du-jeu)
8. [Règles des combats](#règles-des-combats)
9. [Fin de partie](#fin-de-partie)

---

## Règles du jeu

Le joueur doit faire traverser le plateau à son personnage.  
Sur son chemin, il rencontrera des **ennemis**, des **armes** et des **bonus**.  
La partie est réussie si le joueur atteint la fin du plateau vivant.

---

## Le plateau de jeu

- Le plateau est constitué de **64 cases**.
- Chaque case peut être :
    - Vide
    - Contenir un **ennemi**
    - Contenir une **caisse surprise**

---

## Personnages

Au début de chaque partie, le joueur choisit un personnage et lui donne un nom.

| Classe     | Vie | Attaque |
|------------|-----|---------|
| Guerrier   | 10  | 5       |
| Magicien   | 6   | 8       |

---

## Caisses surprises

- Contiennent des objets : **équipements offensifs** ou **potions**.
- Les équipements ne sont ajoutés au personnage que si :
    - le personnage est compatible
    - le nouvel équipement est plus avantageux que l’actuel

---

## Équipements offensifs

### Armes (Guerrier)
- **Massue** : +3 attaque
- **Épée** : +5 attaque

### Sorts (Magicien)
- **Éclair** : +2 attaque
- **Boule de feu** : +7 attaque

### Potions (Tous)
- **Potion de vie standard** : +2 points de vie
- **Grande potion de vie** : +5 points de vie

---

## Ennemis

| Ennemi   | Attaque | Vie |
|----------|---------|-----|
| Sorcier  | 2       | 9   |
| Gobelin  | 1       | 6   |
| Dragon   | 4       | 15  |

---

## Déroulement du jeu

- Le jeu se joue **tour par tour**.
- À chaque tour, le joueur lance un **dé à 6 faces** pour déterminer le nombre de cases avancées.

Selon la case atteinte :
- **Vide** : le tour suivant commence
- **Caisse surprise** :
    - Equipement → ajouté si compatible et avantageux
    - Potion → points de vie récupérés
- **Ennemi** → un combat se déclenche

---

## Règles des combats

- Le personnage frappe l’ennemi selon son attaque + bonus d’équipement.
- Si l’ennemi tombe à 0 vie → mort et disparition du plateau
- Sinon l’ennemi riposte et diminue la vie du personnage
- La vie de l’ennemi reste **persistante** sur sa case

---

## Fin de partie

- **Gagnée** : le joueur atteint la fin du plateau
- **Perdue** : le joueur perd tous ses points de vie

---

## UML & Organisation du projet

Le projet est organisé autour des principales classes suivantes :

- **Personnage** (superclasse) → `Guerrier`, `Magicien`
- **Ennemi**
- **Equipement**
- **Case** → contient Ennemi, Equipement ou vide
- **Plateau** → tableau de 64 cases
- **De** → gestion du lancer de dé
- **Combat** → gère le combat entre personnage et ennemi
- **Menu** → interaction utilisateur (affichage, saisie)
- **Jeu** → coordination générale des tours, déplacements, combats et fin de partie

---

## Installation et exécution

1. Cloner le projet :
   ```bash
   git clone <URL_DU_REPO>
# Diagramme UML - Jeu Donjons et Dragons

---

## 📌 Classes Principales

### **Menu**
| Attribut          | Type       |
|-------------------|------------|
| scanner           | Scanner    |

| Méthode                          | Retour  |
|----------------------------------|---------|
| displayMainMenu()                | void    |
| selectCharacter()                | Character |

---

### **Game**
| Attribut          | Type       |
|-------------------|------------|
| board             | Board      |
| player            | Character  |
| dice              | Dice       |
| isGameOver        | boolean    |

| Méthode                          | Retour  |
|----------------------------------|---------|
| start()                          | void    |
| playTurn()                       | void    |
| checkEndCondition()              | boolean |
| handleCombat(Enemy enemy)       | void    |
| handleChest(Chest chest)        | void    |

---

### **Character**
| Attribut                     | Type                |
|------------------------------|---------------------|
| name                         | String              |
| attack                       | int                 |
| life                         | int                 |
| maxLife                      | int                 |
| position                     | int                 |
| offensiveEquipment           | OffensiveEquipment  |
| defensiveEquipment           | DefensiveEquipment  |

| Méthode                          | Retour  |
|----------------------------------|---------|
| takeDamage(int damage)          | void    |
| pickUpItem(Item item)            | void    |
| move(int steps)                 | void    |
| isAlive()                       | boolean |

---

## 🧙 Personnages

### **Warrior** (héritage : Character)
| Attribut          | Type       |
|-------------------|------------|
| baseLife          | int        |
| baseAttack        | int        |

| Méthode                          | Retour  |
|----------------------------------|---------|
| equipSpell(Spell spell)          | void    |

---

### **Wizard** (héritage : Character)
| Attribut          | Type       |
|-------------------|------------|
| baseLife          | int        |
| baseAttack        | int        |

| Méthode                          | Retour  |
|----------------------------------|---------|
| equipWeapon(Weapon weapon)       | void    |

---

## 🗺️ Plateau et Cases

### **Board**
| Attribut          | Type       |
|-------------------|------------|
| squares           | Square[64] |
| size              | int        |

| Méthode                          | Retour  |
|----------------------------------|---------|
| initSquare(int position)         | Square  |
| removeEnemy(int position)        | void    |
| removeChest(int position)        | void    |

---

### **Square**
| Attribut          | Type       |
|-------------------|------------|
| position          | int        |
| enemy             | Enemy      |
| chest             | Chest      |

| Méthode                          | Retour  |
|----------------------------------|---------|
| isEmpty()                        | boolean |
| removeEnemy()                    | void    |
| removeChest()                    | void    |

---

## ⚔️ Équipements et Objets

### **OffensiveEquipment**
| Attribut          | Type       |
|-------------------|------------|
| attackBonus       | int        |
| type              | String     |

| Méthode                          | Retour  |
|----------------------------------|---------|
| isCompatible(Character character)| boolean |

---

### **Weapon** (héritage : OffensiveEquipment)
| Attribut          | Type       |
|-------------------|------------|
| attackBonus       | int        |

---

#### **Mace** (héritage : Weapon)
| Attribut          | Type       |
 |-------------------|------------|
| attackBonus       | int = 3    |

---

#### **Sword** (héritage : Weapon)
| Attribut          | Type       |
 |-------------------|------------|
| attackBonus       | int = 5    |

---

### **Spell** (héritage : OffensiveEquipment)
| Attribut          | Type       |
|-------------------|------------|
| attackBonus       | int        |

---
#### **LightBolt** (héritage : Spell)
| Attribut          | Type       |
 |-------------------|------------|
| attackBonus       | int = 2    |

---

#### **Fireball** (héritage : Spell)
| Attribut          | Type       |
 |-------------------|------------|
| attackBonus       | int = 7    |

---

### **DefensiveEquipment**
| Attribut          | Type       |
|-------------------|------------|
| defenseBonus      | int        |
| type              | String     |

| Méthode                          | Retour  |
|----------------------------------|---------|
| use(Character character)         | void    |

---

### **Consumable** (héritage : Item)
| Attribut          | Type       |
|-------------------|------------|
| lifeBonus         | int        |
| type              | String     |

| Méthode                          | Retour  |
|----------------------------------|---------|
| use(Character character)         | void    |

---

### **Potion** (héritage : Consumable)
| Attribut          | Type       |
|-------------------|------------|
| lifeBonus         | int        |

---
#### **SmallHealtPotion** (héritage : Potion)
| Attribut          | Type       |
 |-------------------|------------|
| lifeBonus         | int = 2    |

---

#### **BigHealthPotion** (héritage : Potion)
| Attribut          | Type       |
 |-------------------|------------|
| lifeBonus         | int = 5    |

---

## 🎲 Divers

### **Dice**
| Attribut          | Type       |
|-------------------|------------|
| sides             | int        |

| Méthode                          | Retour  |
|----------------------------------|---------|
| roll()                           | int     |

---

### **Chest**
| Attribut          | Type       |
|-------------------|------------|
| content           | Item       |
| isOpen            | boolean    |

| Méthode                          | Retour  |
|----------------------------------|---------|
| open()                           | Item    |

---

### **Item**
| Attribut          | Type       |
|-------------------|------------|
| name              | String     |

| Méthode                          | Retour  |
|----------------------------------|---------|
| getName()                        | String  |

---

## 👹 Ennemis

### **Enemy**
| Attribut          | Type       |
|-------------------|------------|
| name              | String     |
| life              | int        |
| attack            | int        |

| Méthode                          | Retour  |
|----------------------------------|---------|
| takeDamage(int damage)          | void    |
| isAlive()                       | boolean |
| flee()                          | void    |

---

### **Goblin** (héritage : Enemy)
| Attribut          | Type       |
|-------------------|------------|
| life              | int        |
| attack            | int        |

---

### **Dragon** (héritage : Enemy)
| Attribut          | Type       |
|-------------------|------------|
| life              | int        |
| attack            | int        |

---

### **Sorcerer** (héritage : Enemy)
| Attribut          | Type       |
|-------------------|------------|
| life              | int        |
| attack            | int        |

---
