import itertools
import time # bibliothèque pour mesurer le temps d'exécution

def est_valide(placement):
    """
    Vérifie si une configuration de reines est valide.
    """
    for i in range(len(placement)):
        for j in range(i + 1, len(placement)):
            if placement[i] == placement[j] or abs(placement[i] - placement[j]) == abs(i - j):
                return False
    return True

def trouve_solutions_bruteforce(taille_echiquier):
    """
    Trouve toutes les solutions possibles en utilisant la force brute.
    """
    solutions = []
    for permutation in itertools.permutations(range(taille_echiquier)):
        if est_valide(permutation):
            solutions.append(permutation)
            break # Arrête la recherche après avoir trouvé la première solution valide
    return solutions

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
            solutions = trouve_solutions_bruteforce(taille_echiquier)
            fin_temps = time.time()  
            temps_execution = fin_temps - debut_temps
            temps_total += temps_execution
            if solutions: 
                """
                affiche_solution(1, solutions[0], taille_echiquier)
                """
                print(f"Temps d'exécution pour cette exécution : {temps_execution:.8f} secondes")
            else:
                print("Aucune solution trouvée.")
        moyenne_temps = temps_total / 10
        print(f"Moyenne des temps d'exécution sur 10 exécutions : {moyenne_temps:.8f} secondes")
    else:
        print("La colonne choisie est hors de la plage autorisée.")

