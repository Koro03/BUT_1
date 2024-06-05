import random
import time

def est_valide(placement):
    """
    Vérifie si une configuration de reines est valide.
    """
    for i in range(len(placement)):
        for j in range(i + 1, len(placement)):
            if placement[i] == placement[j] or abs(placement[i] - placement[j]) == abs(i - j):
                return False
    return True

def trouve_solution_aleatoire(taille_echiquier, colonne_reine):
    """
    Trouve une solution aléatoire en plaçant les reines de manière aléatoire sur l'échiquier.
    """
    placement = [-1] * taille_echiquier
    placement[0] = colonne_reine # Place la première reine sur la première ligne
    while True:
        # Génère une permutation aléatoire pour les positions des reines restantes
        permutation = random.sample(range(taille_echiquier), taille_echiquier - 1)
        # Place les reines restantes
        for i in range(1, taille_echiquier):
            placement[i] = permutation[i - 1]
        if est_valide(placement):
            return placement

def affiche_solution(numero_solution, placement, taille_echiquier):
    """
    Affiche une solution spécifique de l'échiquier.
    """
    print(f"Solution N° {numero_solution}:")
    for ligne in range(taille_echiquier):
        for colonne in range(taille_echiquier):
            if placement[ligne] == colonne:
                print(" Q", end=" ")
            else:
                print(" .", end=" ")
        print()

if __name__ == "__main__":
    taille_echiquier = 8
    print(f"Entrez la colonne (de 1 à {taille_echiquier}) où vous souhaitez placer la première reine sur la première ligne : ")
    colonne_reine = int(input())

    if 0 <= colonne_reine-1 < taille_echiquier:
        temps_total = 0
        for _ in range(10): # Exécute le programme 10 fois
            debut_temps = time.time()  
            solution = trouve_solution_aleatoire(taille_echiquier, colonne_reine-1)
            fin_temps = time.time()  
            temps_execution = fin_temps - debut_temps
            temps_total += temps_execution
            """
            affiche_solution(1, solution, taille_echiquier)
            """
            print(f"Temps d'exécution pour cette exécution : {temps_execution:.8f} secondes")
        moyenne_temps = temps_total / 10
        print(f"Moyenne des temps d'exécution sur 10 exécutions : {moyenne_temps:.8f} secondes")
    else:
        print("La colonne choisie est hors de la plage autorisée.")
