# coding: utf-8
""" 
Une classe Python pour creer et manipuler des graphes
"""

from collections import deque

echiquier = {}


class Graphe(object):

    def __init__(self, graphe_dict=None):
        """ initialise un objet graphe.
	    Si aucun dictionnaire n'est
	    créé ou donné, on en utilisera un 
	    vide
        """
        if graphe_dict == None:
            graphe_dict = dict()
        self._graphe_dict = graphe_dict

    def aretes(self, sommet):
        """ retourne une liste de toutes les aretes d'un sommet"""
        return self._graphe_dict[sommet]

    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        return set(self._graphe_dict.keys())

    def all_aretes(self):
        """ retourne toutes les aretes du graphe """
        return self.__list_aretes()

    def add_sommet(self, sommet):
        """ Si le "sommet" n'set pas déjà présent
	dans le graphe, on rajoute au dictionnaire 
	une clé "sommet" avec une liste vide pour valeur. 
	Sinon on ne fait rien.
        """
        if sommet not in self._graphe_dict:
            self._graphe_dict[sommet] = []

    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
	    d'une arete (multi-graphe)
        """
        arete = set(arete)
        arete1, arete2 = tuple(arete)
        for x, y in [(arete1, arete2), (arete2, arete1)]:
            if x in self._graphe_dict:
                self._graphe_dict[x].add(y)
            else:
                self._graphe_dict[x] = {y}

    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	    Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        aretes = []
        for sommet in self._graphe_dict:
            for voisin in self._graphe_dict[sommet]:
                if ({voisin, sommet})  not in aretes:
                    aretes.append({sommet, voisin})
        return aretes
    
    def trouve_chaine(self, sommet_dep, sommet_arr, chain=None):
        """ Trouver un chemin élémentaire de sommet_dep à sommet_arr 
            dans le graphe """
        graphe = self._graphe_dict
        if not({sommet_dep,sommet_arr}.issubset(graphe)):
            return None
        if chain == None:
            chain = []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return chain
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chain = self.trouve_chaine(sommet, sommet_arr, chain)
                if ext_chain: 
                    return ext_chain
        return None
    
    
    def trouve_tous_chaines(self, sommet_dep, sommet_arr, chain=[]):
        """ Trouver tous les chemins élémentaires de sommet_dep à 
            sommet_arr dans le graphe """
        graphe = self._graphe_dict  
        #if ((sommet_dep not in graphe) | (sommet_arr not in graphe)):
        if not({sommet_dep,sommet_arr}.issubset(graphe)):
            return []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return [chain]
        if sommet_dep not in graphe:
            return []
        chains = []
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chains = self.trouve_tous_chaines(sommet, sommet_arr, chain)
                for c in ext_chains: 
                    chains.append(c)
        return chains    
    def __iter__(self):
        self._iter_obj = iter(self._graphe_dict)
        return self._iter_obj

    def __next__(self):
        """ Pour itérer sur les sommets du graphe """
        return next(self._iter_obj)

    def __str__(self):
        res = "sommets: "
        for k in self._graphe_dict.keys():
            res += str(k) + " "
        res += "\naretes: "
        for arete in self.__list_aretes():
            res += str(arete) + " "
        return res


class Graphe2(Graphe):
    
    def sommet_degre(self, sommet):
        """ renvoie le degre du sommet """
        degre =  len(self._graphe_dict[sommet]) 
        if sommet in self._graphe_dict[sommet]:
            degre += 1 
        return degre

    def trouve_sommet_isole(self):
        """ renvoie la liste des sommets isoles """
        graphe = self._graphe_dict
        isoles = []
        for sommet in graphe:
            if not graphe[sommet]:
                isoles += [sommet]
        return isoles
        
    def Delta(self):
        """ le degre maximum  """
        max = 0
        for sommet in self._graphe_dict:
            sommet_degre = self.sommet_degre(sommet)
            if sommet_degre > max:
                max = sommet_degre
        return max
    
    def list_degres(self):
        """ calcule tous les degres et renvoie un 
	    tuple de degres decroissant
	"""
        degres = []
        for sommet in self._graphe_dict:
            degres.append(self.sommet_degre(sommet))
        degres.sort(reverse=True)
        return degres

    def bfs(self, sommet):
        Q = deque([sommet])
        D = {sommet: 0}
        for s in self.all_sommets():
            if s != sommet:
                D[s] = float("inf")
        T = {}
        while len(Q) != 0:
            v = Q.popleft()
            for w in self.aretes(v):
                if D[w] == float("inf"):
                    D[w] = D[v] + 1
                    Q.append(w)
                    T[w] = v

        return D, T
 
    def dfs(self, sommet): 
        pile = [sommet]

        D = {sommet: 0}
        for s in self.all_sommets():
            if s != sommet:
                D[s] = float("inf")
        T = {}
        while pile:
            v = pile.pop()
            for w in self.aretes(v):
                if D[w] == float("inf"):
                    D[w] = D[v] + 1
  
                    pile.append(w)

                    T[w] = v
        return D, T
    


class Reines8(Graphe):
    def __init__(self):
        super().__init__()
        # Crée un graphe vide de 8x8 échiquier
        for i in range(8):
            for j in range(8):
                self.add_sommet((i, j))
    

    
    def check_position_safe(board, row, col):
        """
        Vérifie si placer une reine à la position (row, col) sur l'échiquier est sûr.
        """
    # Vérifie la colonne
        for i in range(row):
            if board[i] == col or \
            board[i] - i == col - row or \
            board[i] + i == col + row:
             return False
        return True

    def generate_neighbor_configs(board):
        """
    Génère les configurations voisines en plaçant une reine supplémentaire dans une colonne non occupée.
    """
        neighbors = []
        n = len(board)
        for col in range(n):
            for row in range(n):
                if check_position_safe(board, row, col):
                    new_board = board[:]
                    new_board.append(col)
                    neighbors.append(new_board)
        return neighbors

    def solve_n_queens_bfs(n):
        """
    Résout le problème des n reines en utilisant BFS.
    """
    # Crée une configuration initiale avec aucune reine placée
        initial_config = []
        queue = deque([initial_config])

        while queue:
            config = queue.popleft()
            if len(config) == n:  # Solution trouvée
                return config
            neighbors = generate_neighbor_configs(config)
            queue.extend(neighbors)

        return None  # Aucune solution trouvée


solution = solve_n_queens_bfs(8)
if solution:
    print("Solution trouvée:")
    for row, col in enumerate(solution):
        print("Reine à la ligne", row, "colonne", col)
else:
    print("Aucune solution trouvée pour les 8 reines.")

