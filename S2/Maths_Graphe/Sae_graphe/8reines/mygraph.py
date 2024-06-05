#https://zanotti.univ-tln.fr/ALGO/I51/Reines.html
graphe = {1 :{},2 :{},3 :{},4 :{},5 :{},6 :{}, 7 :{}, 8 :{}}
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
        return list(self._graphe_dict[sommet])

   
    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        return self._graphe_dict.keys
    
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
            self._graphe_dict[sommet]= []   


    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
            d'une arete (multi-graphe)
        """
        self._graphe_dict[arete[0]].add(arete[1])
        self._graphe_dict[arete[1]].add(arete[0])
    
    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	        Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        liste = []
        for cle in self._graphe_dict:
            for valeur in self._graphe_dict[cle]:
                liste.append((cle,valeur))
        return liste

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

    def trouve_chaine(self, sommet_dep, sommet_arr, chaine=None):
        if chaine is None:
            chaine = []
        chaine.append(sommet_dep)
        if sommet_dep == sommet_arr:
            return chaine
        for voisin in self._graphe_dict[sommet_dep]:
            if voisin not in chaine:
                nouv_chemin = self.trouve_chaine(voisin, sommet_arr, chaine)
                if nouv_chemin:
                    return nouv_chemin
        chaine.pop()
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
    
class Graphe2(Graphe):
    def sommet_degre(self, sommet):
        """ renvoie le degre du sommet """
        return len(self._graphe_dict[sommet])

    def trouve_sommet_isole(self):
        """ renvoie la liste des sommets isoles """
        return [sommet for sommet in self._graphe_dict if len(self._graphe_dict[sommet]) == 0]
    
    def Delta(self):
        """ le degre maximum """
        return max(len(adjacents) for adjacents in self._graphe_dict.values())
    
    def list_degres(self):
        """ calcule tous les degres et renvoie un
        tuple de degres decroissant
        """
        degres = []
        for sommet in self._graphe_dict:
            degres.append(self.sommet_degre(sommet))
        degres.sort(reverse=True)
        return degres
    
    def bfs(self, s):
        # Initialisation de la file et des distances
        Q = deque([s])
        D = {sommet: float("inf") for sommet in self.all_sommets()}
        D[s] =  0
        T = {}  # Dictionnaire pour l'arbre couvrant

        # Boucle principale du BFS
        while Q:
            v = Q.popleft()  # Défilement du sommet à visiter
            for w in self.aretes(v):
                if D[w] == float("inf"):  # Si w n'a pas été visité
                    D[w] = D[v] +  1  # Mise à jour de la distance
                    Q.append(w)  # Ajout de w à la file
                    T[v] = w  # Ajout de l'arête (v, w) à l'arbre couvrant
        return D, T
    
    def dfs(self, s):
        # Initialisation de la pile et des distances
        P = [s]
        D = {sommet: float("inf") for sommet in self.all_sommets()}
        D[s] =  0
        T = {}  # Dictionnaire pour l'arbre couvrant
        # Boucle principale du DFS
        while P:
            v = P[-1]  # Dernier sommet de la pile à visiter
            P.pop()  # Retrait du sommet de la pile
            for w in self.aretes(v):
                if D[w] == float("inf"):  # Si w n'a pas été visité
                    D[w] = D[v] +  1  # Mise à jour de la distance
                    P.append(w)  # Ajout de w à la pile
                    T[v] = w  # Ajout de l'arête (v, w) à l'arbre couvrant
        return D, T