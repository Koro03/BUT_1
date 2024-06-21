import numpy as np 
import numpy.random as rd
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression

"""
Import des données du csv

"""
CollegesDF = pd.read_csv("C:/Users/benfa\Documents/Iut_1a/BUT_1/S2/math/vue_etablissement_sansQP.csv")
CollegesDF = CollegesDF.dropna()
CollegesAr = CollegesDF.to_numpy()


"""
Création des fonctions

"""
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

def DiagBatonsAcademie(Colonne):
    # m contient la valeur minimale de la colonne
    m = min(Colonne)
    M = max(Colonne)  # M contient la valeur maximale de la colonne
    inter = np.linspace(m, M, num=M-m+1)  # liste de 21 valeurs allant de m à M. On peut utiliser la fonction np.linspace
    plt.figure()  
    # tracé du diagramme pour les intervalles inter
    plt.hist(Colonne, bins=inter, rwidth=0.5)  # Correction ici: Utilisez 'Colonne' au lieu de 'colonne'
    plt.xticks(np.arange(m, M,2))  # Correction ici: Ajouté plt.xticks pour afficher les labels des intervalles
    plt.xlabel('valeurs du code')  # Correction ici: Cette ligne était redondante et contenait une erreur. Elle a été remplacée par plt.xlabel('Notes').
    plt.ylabel('nombre de code')
    plt.title('Diagramme baton des code academie')
    plt.show()
    
def DiagBatonsFilles(Colonne):
    # m contient la valeur minimale de la colonne
    m = min(Colonne)
    M = max(Colonne)  # M contient la valeur maximale de la colonne
    inter = np.linspace(m, M, num=M-m+1)  # liste de 21 valeurs allant de m à M. On peut utiliser la fonction np.linspace
    plt.figure()  
    # tracé du diagramme pour les intervalles inter
    plt.hist(Colonne, bins=inter, rwidth=0.5)  # Correction ici: Utilisez 'Colonne' au lieu de 'colonne'
    plt.xticks(np.arange(m, M,6))  # Correction ici: Ajouté plt.xticks pour afficher les labels des intervalles
    plt.xlabel('nombres de filles')  # Correction ici: Cette ligne était redondante et contenait une erreur. Elle a été remplacée par plt.xlabel('Notes').
    plt.ylabel('nombres de filles par niveau')
    plt.title("Diagramme en Bâtons d'effectifs de filles")
    plt.show()

def DiagBatonsGarcon(Colonne):
    # m contient la valeur minimale de la colonne
    m = min(Colonne)
    M = max(Colonne)  # M contient la valeur maximale de la colonne
    inter = np.linspace(m, M, num=M-m+1)  # liste de 21 valeurs allant de m à M. On peut utiliser la fonction np.linspace
    plt.figure()  
    # tracé du diagramme pour les intervalles inter
    plt.hist(Colonne, bins=inter, rwidth=0.5)  # Correction ici: Utilisez 'Colonne' au lieu de 'colonne'
    plt.xlabel('Notes')  # Correction ici: Ajouté plt.xlabel pour étiqueter l'axe des x
    plt.xticks(np.arange(m, M,6))  # Correction ici: Ajouté plt.xticks pour afficher les labels des intervalles
    plt.xlabel('nombre de garçons')  # Correction ici: Cette ligne était redondante et contenait une erreur. Elle a été remplacée par plt.xlabel('Notes').
    plt.ylabel("nombre de garçons par niveau")
    plt.title("Diagramme en Bâtons de l'effectifs de garçons")
    plt.show()

def DiagBatonsUlis(Colonne):
    # m contient la valeur minimale de la colonne
    m = min(Colonne)
    M = max(Colonne)  # M contient la valeur maximale de la colonne
    inter = np.linspace(m, M, num=M-m+1)  # liste de 21 valeurs allant de m à M. On peut utiliser la fonction np.linspace
    plt.figure()  
    # tracé du diagramme pour les intervalles inter
    plt.hist(Colonne, bins=inter, rwidth=0.5)  # Correction ici: Utilisez 'Colonne' au lieu de 'colonne'
    plt.xticks(np.arange(m, M))  # Correction ici: Ajouté plt.xticks pour afficher les labels des intervalles
    plt.xlabel("nombre d'ulis par classe ")  # Correction ici: Cette ligne était redondante et contenait une erreur. Elle a été remplacée par plt.xlabel('Notes').
    plt.ylabel('Nombre de classe')
    plt.title("Diagramme en Bâtons du nombre d'élèves ulis")
    plt.show()




"""
Execution des différents script

"""
CollegesAr_CR = Centreduire(CollegesAr)
Colleges0Ar_CR = Centreduire(CollegesAr[:,[1,2,3,4]])
code_academeie = CollegesAr[:,1]
nb_eleves_ulis = CollegesAr[:,2]
effectifs_filles = CollegesAr[:,3]
effectifs_garçons = CollegesAr[:,4]
quartierpriroritaire_cr = CollegesAr_CR[:,0]
#diagramme baton 
print(DiagBatonsAcademie(code_academeie))
print(DiagBatonsUlis(nb_eleves_ulis))
print(DiagBatonsFilles(effectifs_filles))
print(DiagBatonsGarcon(effectifs_garçons))

#matrice de covariance
MatriceCov = np.cov(Centreduire(CollegesAr), rowvar=False)
print (MatriceCov)


#régression linéaire multiple

CollegesAr_Explicative = Colleges0Ar_CR[:,[0,1]]
linear_regression = LinearRegression()
linear_regression.fit(CollegesAr_Explicative, quartierpriroritaire_cr)
a=linear_regression.coef_
print(a)

# corrélation multiple
Ypred = a[0]*CollegesAr_Explicative[:,0]+a[1]*CollegesAr_Explicative[:,1]
CorCol=linear_regression.score(CollegesAr_Explicative,quartierpriroritaire_cr)

print(Ypred)
print(CorCol)
