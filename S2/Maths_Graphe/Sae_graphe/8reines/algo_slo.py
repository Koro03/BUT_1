from mygraph import Graphe2
import time
from collections import deque

class Jeu(Graphe2):
    #taille de la grille
    N = 13

    #parcours en profondeur
    def dfs(self, ligne_depart, echequier):
        if len(echequier) == self.N:
            return echequier
        for colonne in range(self.N):
            if self.estValide(echequier, len(echequier), colonne):
                echequier.append(colonne)
                solution = self.dfs(ligne_depart, echequier)
                if solution:
                    return solution
                echequier.pop()

    #parcours en largeur
    def bfs(self, ligne_depart):
        file = deque([(ligne_depart, [ligne_depart])])
        while file:
            sommet, chemin = file.popleft()
            if len(chemin) == self.N:
                return chemin
            for colonne in range(self.N):
                if self.estValide(chemin, len(chemin), colonne):
                    file.append((colonne, chemin + [colonne]))

    #verifie si la colonne, la ligne et la diagonal est libre pour placer reine
    def estValide(self, echequier, ligne, colonne):
        for i in range(ligne):
            if echequier[i] == colonne:
                return False
        for i in range(ligne):
            if abs(echequier[i] - colonne) == ligne - i:
                return False
        return True
    
    #fonction d'affichage
    def afficherSolution(self, solution):
        print("Solution :")
        for colonne in solution:
            ligne = ['.'] * self.N
            ligne[colonne] = '1'
            print(' '.join(ligne))
        print()

if __name__ == "__main__":
    jeu = Jeu()
    ligne_depart = int(input("selectionner une ligne de depart :"))

    #calcul du temps de resolution du dfs
    startdfs = time.perf_counter()
    solution = jeu.dfs(ligne_depart, [ligne_depart])
    enddfs = time.perf_counter()

    #calcul du temps de resolution du bfs
    startbfs = time.perf_counter()
    solution2 = jeu.bfs(ligne_depart)
    endbfs = time.perf_counter()

    #affichage des solutions
    if solution:
        jeu.afficherSolution(solution)
        print("temps pour dfs : ", (enddfs - startdfs)*1000,"milliseconde")
    else: 
        print("aucune solution trouvée")

    if solution2:
        jeu.afficherSolution(solution2)
        print("temps pour bfs: ", (endbfs - startbfs)*1000,"milliseconde")
    else:
        print("aucune solution trouvée")
