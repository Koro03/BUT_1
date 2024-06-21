import numpy as np 
import numpy.random as rd
import matplotlib.pyplot as plt
import pandas as pd

def Moyenne(Serie):
    N=len(Serie)
    return sum(Serie)/N

def Covar(X,Y):
    resultat = 0
    if len(X) == len(Y):
        for i in range(len(X)):
            resultat += ((X[i]-Moyenne(X))*(Y[i]-Moyenne(Y)))
    return 1/len(X) * resultat

def variance(l):
    t = 0
    moy = Moyenne(l)
    k = 1/len(l) 
    for i in range (len(l)):
        t += (l[i] - moy)**2
    return k * t

def Centreduire(T):
    T=np.array(T,dtype=np.float64)
    (n,p)=T.shape
    res=np.zeros((n,p))
    Tmoy=np.mean(T,axis=0)
    TEcart=np.std(T,axis=0)
    for j in range(p):
        res[:,j]=(T[:,j]-Tmoy[j])/TEcart[j]
    return res

print("**********1**********")
# la poulation est les college de france 
print("**********2**********")
# la colonne de numero-college sert à identifier les individues de la pop
print("**********3**********")
CollegesDF = pd.read_csv('/home/etuinfo/elgachet/Documents/math/Colleges.csv')
print("**********4**********")
CollegesAr = CollegesDF.to_numpy()
print(CollegesAr)
print("**********5**********")
CollegesAr0 = CollegesAr[:,[2,3,4,5,6,7,8]]
print(CollegesAr0)
print("*********************")
CollegesAr1 = CollegesAr[:,[0,1,9,10]]
print(CollegesAr1)
print("**********6**********")
#print(Centreduire(CollegesAr0))
print("**********7**********")
print("**********8**********")
CollegesDF=pd.read_csv("Colleges.csv")
CollegesDF = CollegesDF.dropna()
print("**********9**********")

def DiagBatons(Colonne):
    # m contient la valeur minimale de la colonne
    m = min(Colonne)
    M = max(Colonne)  # M contient la valeur maximale de la colonne
    inter = np.linspace(m, M, num=21)  # liste de 21 valeurs allant de m à M. On peut utiliser la fonction np.linspace
    plt.figure()  
    # tracé du diagramme pour les intervalles inter
    plt.hist(Colonne, bins=inter, rwidth=0.8)  # Correction ici: Utilisez 'Colonne' au lieu de 'colonne'
    plt.xlabel('Notes')  # Correction ici: Ajouté plt.xlabel pour étiqueter l'axe des x
    plt.xticks(np.arange(0, 21))  # Correction ici: Ajouté plt.xticks pour afficher les labels des intervalles
    plt.xlabel('Intervalle')  # Correction ici: Cette ligne était redondante et contenait une erreur. Elle a été remplacée par plt.xlabel('Notes').
    plt.ylabel('Fréquence')
    plt.title('Diagramme en Bâtons pour la Colonne Spécifiée')
    plt.show()

print("**********10**********")
print (DiagBatons(CollegesAr0[:,0]))
print("**********16**********")
print (np.cov(Centreduire(CollegesAr0), rowvar=False))

print("**********17**********")