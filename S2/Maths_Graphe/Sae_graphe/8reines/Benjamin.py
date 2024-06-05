from collections import deque
import time

from collections import deque
import time


class SolverDames:
    def __init__(self, taille):
        self.taille = taille
        self.solutions = []

    def placer_reine(self, echiquier, ligne, colonne):
        echiquier[ligne][colonne] = 1

    def enlever_reine(self, echiquier, ligne, colonne):
        echiquier[ligne][colonne] = 0

    def reine_possible(self, echiquier, ligne, colonne):
        for i in range(ligne):
            if echiquier[i][colonne] == 1:
                return False
        # diagonale gauche
        x, y = ligne - 1, colonne - 1  # Début de la diagonale gauche
        while x >= 0 and y >= 0:  
            if echiquier[x][y] == 1:  
                return False  
            # Aller à la ligne précédente
            x -= 1  
            y -= 1
            
        #diagonale droite
        x, y = ligne - 1, colonne + 1  # Début de la diagonale droite
        while x >= 0 and y < self.taille:  
            if echiquier[x][y] == 1:  
                return False  
            # Aller à la ligne précédente
            x -= 1  
            # Aller à la colonne suivante dans la diagonale droite
            y += 1  

        # S'il n'y a pas de reine dans la diagonale droite, retourner True (il est sûr de placer une reine ici)
        return True


    def PbEchiquier(self, colonne_depart):
        solutions = []
        # Faire une file avec la librairie deque
        fileEtat = deque()
        # État initial : échiquier vide sauf la colonne de départ avec une reine
        echiquier_initial = [[0] * self.taille for j in range(self.taille)]
        self.placer_reine(echiquier_initial, 0, colonne_depart)
        fileEtat.append(echiquier_initial)
        # recherhe si toute la file d'état est vide 
        while fileEtat:
            echiquier = fileEtat.popleft()
            #on fait la somme des case car toute les case valent 0 sauf la ou 
            #il y a une reine donc on sait le nombres de reines placées
            nombre_de_reines_placees = sum(sum(case for case in ligne) for ligne in echiquier)
            #on recherche si le nombre de reines vaut le nombre de dames rechercher
            if nombre_de_reines_placees == self.taille:
                solutions.append([list(row) for row in echiquier])
                continue
            ligne = nombre_de_reines_placees  # La prochaine ligne à explorer
            # placement de toute les reines
            for col in range(self.taille):
                if self.reine_possible(echiquier, ligne, col):
                    NouvEtat = [list(row) for row in echiquier]
                    self.placer_reine(NouvEtat, ligne, col)
                    fileEtat.append(NouvEtat)
        self.solutions = solutions
        return solutions

# Récupérer la colonne de départ de l'utilisateur
colonne_depart = int(input("Entrez la colonne de départ pour placer la première reine (de 0 à 8) : "))

n = int(input("taille de l'échiquier : "))

debut_temps = time.time()

  # Taille de l'échiquier
solver = SolverDames(n)
solutions = solver.PbEchiquier(colonne_depart )
nb = 0
for solution in solutions:
    for ligne in solution:
        ligne_final = ''.join(['D' if i == 1 else '.' for i in ligne])
        print(ligne_final)
    nb += 1 
    print('solution numéro ' + str(nb))

fin_temps = time.time()

temps_ecoule = fin_temps - debut_temps

print("Temps d'exécution:", temps_ecoule, "secondes")

