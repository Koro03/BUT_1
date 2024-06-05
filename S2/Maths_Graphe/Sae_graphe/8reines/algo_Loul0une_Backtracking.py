import time  # bibliothèque pour mesurer le temps d'exécution

def est_valide(placement, ligne, colonne):
    """
    Vérifie si placer une reine à une certaine position est valide.
    """
    for i in range(ligne):
        if placement[i] == colonne or abs(placement[i] - colonne) == abs(i - ligne):# Fonction pour vérifier si placer une reine à une 
                                                                                    # certaine position est valide
            return False
    return True

def place_reine(placement, ligne, solutions):
    """
    Place les reines de manière récursive sur l'échiquier.
    """
    if ligne == len(placement):
        solutions.append(placement[:]) # Copie de l'emplacement actuel dans la liste des solutions
        return
    for colonne in range(len(placement)):
        if est_valide(placement, ligne, colonne):
            placement[ligne] = colonne  # Place une reine à la position valide
            place_reine(placement, ligne + 1, solutions)  # Appel récursif pour placer la reine suivante
            placement[ligne] = -1  # Retire la reine de la position actuelle après avoir exploré toutes les possibilités

def trouve_solutions_backtracking(taille_echiquier, colonne_reine):
    """
    Trouve toutes les solutions possibles en utilisant l'algorithme de backtracking.
    """
    placement = [-1] * taille_echiquier
    placement[0] = colonne_reine  # Place la première reine sur la première ligne
    solutions = [] # listeb des solutions pour le problème
    place_reine(placement, 1, solutions)  # Commence la recherche des solutions à partir de la deuxième ligne
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
            solutions = trouve_solutions_backtracking(taille_echiquier, colonne_reine-1)
            fin_temps = time.time()  
            temps_execution = fin_temps - debut_temps
            temps_total += temps_execution
            """
            # Affichage des solutions
            for numero_solution, placement in enumerate(solutions, start=1):
                affiche_solution(numero_solution, placement, taille_echiquier)
                print()
            """
            print(f"Temps d'exécution pour cette exécution : {temps_execution:.8f} secondes")
        moyenne_temps = temps_total / 10
        print(f"Nombre de solutions trouvées : {len(solutions)}")
        print(f"Moyenne des temps d'exécution sur 10 exécutions : {moyenne_temps:.8f} secondes")
    else:
        print("La colonne choisie est hors de la plage autorisée.")

