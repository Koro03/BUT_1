# coding: utf-8
""" 
Une classe Python pour creer et manipuler des graphes
"""

import numpy as np

from collections import deque

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
            arretes lien entre 2 sommet
        """
        aretes = []
        for sommet in self._graphe_dict:
            for voisin in self._graphe_dict[sommet]:
                if ({voisin, sommet})  not in aretes:
                    aretes.append({sommet, voisin})
        return aretes
    
    def trouve_chaine(self, sommet_dep, sommet_arr, chain=None):
        """ Trouver un chemin élémentaire de sommet_dep à sommet_arr 
            dans le graphe 
            chaine = un sommet qui va être 
            relier pas des arrêtes consécutive jusqu'à un point donner """
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
        """ renvoie le degre du sommet un degres est 
            l'ensemble des liens qui partes d'un sommet
            somme des degrés et le double de nombre d'arrêtes (non orienté)
        """
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
        # Initialisation de la file d'attente Q avec le sommet de départ
        Q = deque([sommet])
        # Initialisation des distances : distance de sommet à lui-même est 0, les autres sont infinies
        D = {sommet: 0}
        for s in self.all_sommets():
            if s != sommet:
                D[s] = float("inf")
        # Initialisation du dictionnaire des prédécesseurs T
        T = {}
        # Algorithme BFS
        while len(Q) != 0:  # Tant que la file d'attente Q n'est pas vide
            v = Q.popleft()  # Prend le premier sommet de la file d'attente
            for w in self.aretes(v):  # Pour chaque voisin w de v
                if D[w] == float("inf"):  # Si w n'a pas encore été visité
                    D[w] = D[v] + 1  # Met à jour la distance de w
                    Q.append(w)  # Ajoute w à la file d'attente pour l'explorer plus tard
                    T[w] = v  # Marque v comme prédécesseur de w dans le chemin le plus court de sommet à w
        # Retourne les distances minimales et les prédécesseurs
        return D, T
    """test bfs
    def bfs (self,sommet):
        fileArr = deque(sommet)
        Distance = []
        Predecesseur = []
        Distance[sommet] = 0

        for v in self.all_sommets():
            if v != sommet:
                Distance[sommet] = float("inf")
        
        while fileArr :
            v = fileArr.popleft()
            for w in self.aretes(v):
                if Distance[w] != "inf":
                    Distance[w] = Distance[v] +1
                    fileArr.append(w)
                    Predecesseur[w] = v

        return Predecesseur , Distance
    """
    """dsf v1
    def dfs(self, sommet): 
        # Initialisation de la pile avec le sommet de départ
        pile = [sommet]
        # Initialisation du dictionnaire des distances avec le sommet de départ
        D = {sommet: 0}
        # Initialisation des distances des autres sommets à l'infini
        for s in self.all_sommets():
            if s != sommet:
                D[s] = float("inf")
        # Initialisation du dictionnaire des prédécesseurs
        T = {}
        # Parcours en profondeur du graphe
        while pile:
            # Extraire le sommet en haut de la pile
            v = pile.pop()
            # Parcourir les voisins de v
            for w in self.aretes(v):
                # Si le voisin w n'a pas encore été visité
                if D[w] == float("inf"):
                    # Mettre à jour la distance de w
                    D[w] = D[v] + 1
                    # Ajouter w à la pile pour le visiter plus tard
                    pile.append(w)
                    # Enregistrer v comme prédécesseur de w
                    T[w] = v
        # Retourner les distances et les prédécesseurs
        return D, T
    """
    def dfs(self, sommet):
        # Initialisation de la pile avec le sommet de départ
        pile = [sommet]
        # Ensemble pour suivre les sommets déjà visités
        visite = set()
        # Initialisation du dictionnaire des prédécesseurs
        D = {sommet: 0}
        # Parcours en profondeur du graphe
        while pile:
            # Extraire le sommet en haut de la pile
            v = pile.pop()
            # Si le sommet n'a pas déjà été visité
            if v not in visite:
                # Marquer le sommet comme visité
                visite.add(v)
                # Parcourir les voisins du sommet
                for w in self.aretes(v):
                    # Si le voisin n'a pas déjà été visité
                    if w not in visite:
                        # Ajouter le voisin à la pile pour le visiter plus tard
                        pile.append(w)
                        # Enregistrer le prédécesseur du voisin
                        D[w] = v
        # Retourner le dictionnaire des prédécesseurs
        return D
    """test dfs
    def dfs(self,sommet):
        Predesesseur = []
        visite = set()
        pileArr = []
        pileArr[sommet] = 0

        while pileArr:
            v = pileArr.pop()
            if v not in visite():
                visite.add(v)
                for w in self.aretes(v):
                    if w not in visite():
                        pileArr.append(w)
                        Predesesseur[w] 
        return Predesesseur
    """
    def w(self,s1,s2):
        return self._graphe_dict[s1][s2]
    
    def Dijkstra(self, sommet):
        # Initialisation des distances et des prédécesseurs
        D = {}  # Dictionnaire des distances minimales
        P = {}  # Dictionnaire des prédécesseurs sur le chemin le plus court
        Q = [sommet]  # File d'attente pour les sommets à explorer
        D[sommet] = 0  # Distance de sommet à lui-même est 0 (on est déjà là)

        # Initialisation des distances des autres sommets à l'infini
        for s in self.all_sommets():
            if s != sommet:
                D[s] = float('inf')

        # Initialisation des prédécesseurs à None pour tous les sommets
        for s in self.all_sommets():
            P[s] = None

        # Algorithme de Dijkstra
        while Q:  # Tant qu'il y a des sommets à explorer
            v = Q.pop(0)  # On récupère le premier sommet de la file d'attente
            for u in self.aretes(v):  # Pour chaque voisin de v
                # Si le chemin par v jusqu'à u est plus court que le chemin connu
                if D[u] > D[v] + self.w(v, u):
                    # Met à jour la distance de u
                    D[u] = D[v] + self.w(v, u)
                    # Marque v comme prédécesseur de u
                    P[u] = v
                    # Ajoute u à la file d'attente pour l'explorer plus tard
                    Q.append(u)
        print(D)
        print(P)
        # Retourne les distances minimales et les prédécesseurs
        return D, P

    
    def plusCourtChemin(self, sommet, destination): 
        # Vérification des sommets dans le graphe
        if sommet not in self.all_sommets() or destination not in self.all_sommets():
            raise ValueError(f"Le sommet {sommet} ou {destination} n'existe pas dans le graphe.")
        # Exécution de Dijkstra pour obtenir les distances et les prédécesseurs
        D, P = self.Dijkstra(sommet)
        # Si la distance à d est infinie, il n'y a pas de chemin
        if D[destination] == float('inf'):
            return "pas de chemin"
        # Initialiser le chemin avec le sommet de destination
        L = [destination]
        v = destination
        # Remonter les prédécesseurs depuis d jusqu'à s
        while v != sommet:
            v = P[v]
            L.append(v)

        # Inverser le chemin pour qu'il aille de s à d
        L.reverse()

        # La longueur du chemin est la distance trouvée par Dijkstra
        l = D[destination]  

        return (L, l)
    
g1 = {"A" :{"C"},
           "B" : {"C", "E"},
           "C" : {"A", "B", "D", "E"},
           "D" : {"C"},
           "E" : {"C", "B"},
           "F" : set()
}
graphe = {"A" :{"C": 1},
 "B" : {"C" : 2, "E" : 3},
 "C" : {"A" : 1, "B" : 2, "D" : 4, "E" : 2},
 "D" : {"C" : 4},
 "E" : {"C" : 2, "B" : 3},
 "F" : {}
}
G1=Graphe(g1)
G1.all_aretes()

G2=Graphe2(g1)
G3 = Graphe2(graphe)

print(G2.sommet_degre("A"))
print(G2.trouve_sommet_isole())
print(G2.dfs("A"))
print(G2.bfs("A"))
print("****************************")
print(G3.Dijkstra("A"))
print(G3.plusCourtChemin("A","E"))
"""Est connexe fonctionnel"""
class Graphe2(Graphe2):
    def estconnexe(self,s):
        """ s est un sommet quelconque, donné par l'utilisateur 
        Il faudra renvoyer une exception si le sommet n'existe pas
        """
        
        if s is None:
            s = self.all_sommets()[0]
        if s not in self.all_sommets():
            raise ValueError("Le sommet {} n'existe pas dans le graphe.".format(s))
        Q = deque([s])
        D = {s: 0}
        for sommet in self.all_sommets():
            if sommet != s:
                D[sommet] = float("inf")
        T = {}
        c=1
        while len(Q) != 0:
            v = Q.popleft()
            for w in self.aretes(v):
                if D[w] == float("inf"):
                    D[w] = D[v] + 1
                    Q.append(w)
                    c+=1
                    T[w] = v
        if len(self.all_sommets()) == c:
            return "vraie"
        else:
            return "faux"
    
        
    def estcyclique(self,s=None,TAG=[]):
        if s not in self.all_sommets():
            raise ValueError("Le sommet {} n'existe pas dans le graphe.".format(s))
        # Ensemble des sommets visités
        N = set()
        
        # Queue de sommets à explorer. Si s est fourni, on commence avec s, sinon avec un sommet aléatoire.
        Q = [s] if s is not None else [next(iter(self.all_sommets()))]
        
        # Indicateur de cycle
        C = "graphe acyclique"
        
        while Q:
            v = Q.pop(0)  # Défile le premier sommet de la queue
            
            # Ajouter tous les voisins non visités de v à la queue
            for w in self.aretes(v):
                if w not in N:
                    Q.append(w)
                    N.add(v)
                if w in N:
                    C = "Il y a un cycle"
        return C
    def estconnexe2(self,s):
        """ s est un sommet quelconque, donné par l'utilisateur 
        Il faudra renvoyer une exception si le sommet n'existe pas
        """
        
        list_composantes_connexes=[]
        liste_sommet_visite = set()

        if s is None:
            s = self.all_sommets()[0]
        if s not in self.all_sommets():
            raise ValueError("Le sommet {} n'existe pas dans le graphe.".format(s))
        c=0
        def bfs(sommet):
            Q = deque([sommet])
            list_composantes_connexes_1_sommet = []
            nonlocal c
            while Q:
                v = Q.popleft()

                if v not in liste_sommet_visite:
                    liste_sommet_visite.add(v)
                    list_composantes_connexes_1_sommet.append(v)
                    for w in self.aretes(v):
                        if w not in liste_sommet_visite:
                            Q.append(w)
                            c+=1
            return list_composantes_connexes_1_sommet
        
        for sommet in self.all_sommets():
            if sommet not in liste_sommet_visite:  # Si le sommet n'a pas encore été visité
                list_composantes_connexes_1_sommet = bfs(sommet)  # Trouver tous les sommets de sa composante connexe
                list_composantes_connexes.append(list_composantes_connexes_1_sommet)
        
        print(list_composantes_connexes)
        n = len(list_composantes_connexes)
        L = list_composantes_connexes
        print(n)
        print(c)
        print(len(self.all_sommets()))
        if c == len(self.all_sommets()):
            return "vrai"
        else:
            return ("faux", n)
    def estconnexe3(self,s):
        """ s est un sommet quelconque, donné par l'utilisateur 
        Il faudra renvoyer une exception si le sommet n'existe pas
        
        """
        list_composantes_connexes=[]
        liste_sommet_visite = set()

        if s is None:
            s = self.all_sommets()[0]
        if s not in self.all_sommets():
            raise ValueError("Le sommet {} n'existe pas dans le graphe.".format(s))
        c=0
        def bfs(sommet):
            Q = deque([sommet])
            list_composantes_connexes_1_sommet = []
            nonlocal c
            while Q:
                v = Q.popleft()

                if v not in liste_sommet_visite:
                    liste_sommet_visite.add(v)
                    list_composantes_connexes_1_sommet.append(v)
                    for w in self.aretes(v):
                        if w not in liste_sommet_visite:
                            Q.append(w)
                            c+=1
            return list_composantes_connexes_1_sommet
        
        for sommet in self.all_sommets():
            if sommet not in liste_sommet_visite:  # Si le sommet n'a pas encore été visité
                list_composantes_connexes_1_sommet = bfs(sommet)  # Trouver tous les sommets de sa composante connexe
                list_composantes_connexes.append(list_composantes_connexes_1_sommet)
        
        print(list_composantes_connexes)
        n = len(list_composantes_connexes)
        L = list_composantes_connexes
        print(n)
        print(c)
        print(len(self.all_sommets()))
        if c == len(self.all_sommets()):
            return "vrai"
        else:
            return (("faux",n), L)
        
    def dict_to_matadj(self,dictionnaire):
        # Votre code ici
        sommets = self.all_sommets()
        n = len(sommets)
        matadj = np.zeros((n, n), dtype=int)

        sommet_index = {sommet: index for index, sommet in enumerate(sommets)}

        for sommet, voisins in self._graphe_dict.items():
            for voisin in voisins:
                i, j = sommet_index[sommet], sommet_index[voisin]
                matadj[i, j] = 1
        
        return matadj
g3 = Graphe2(G3)
print(G3.dict_to_matadj())
    