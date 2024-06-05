# include <stdio.h>
# include <stdlib.h>
# include <string.h>

// les constantes symboliques
#define MAX_ANNONCES 1000
#define MAX_LIGNES 1001
#define MAX_CHAMP 5

// les types
typedef int t_lignes[MAX_LIGNES];
typedef int t_champ[MAX_CHAMP];
typedef struct{
        int id;
        char marque;
        char designation;
        int annee;
        int km;
        int prix;
}t_annonce;

typedef struct{
        t_annonce tab_annonces[MAX_ANNONCES];
        int nb;
}t_stock;

// les prototypes des fonctions
void initStock(t_stock *stock_auto);
void lectureTexte1();
void lectureTexte2();
void lectureTexte3();
void afficheAnnonces();
void afficheAnnoncesMarque();
void sauvegardeBinaire();
void lectureBinaire();
void saisieAnnonce();
void ajoutAnnonceFichierBinaire();
// les constantes
const t_annonce ANNONCE_VIDE = {0,' ',' ',0,0,0};
// le programme principal
int main(){
    t_stock stock_auto;
    t_annonce annonce;
    int choix = -1;
    // initialisation des structures
    initStock(&stock_auto);
    lectureTexte1();
    lectureTexte2();
    lectureTexte3();
    afficheAnnonces();
    afficheAnnoncesMarque();
    sauvegardeBinaire();
    lectureBinaire();
    saisieAnnonce();
    ajoutAnnonceFichierBinaire();

    // menu
    while(choix != 0){
        printf("---------------------------------------------------------------------\n");
        printf("1 : lire le fichier texte des annonces (pas d'espace dans les champs)\n");
        printf("2 : lire le fichier texte des annonces \n");
        printf("3 : lire le fichier texte des annonces (variables locales)\n");
        printf("4 : afficher les annonces\n");
        printf("5 : afficher les annonces d'une marque\n");
        printf("6 : sauvegarder les annonces dans un fichier binaire\n");
        printf("7 : lire le fichier binaire des annonces\n");
        printf("8 : ajouter une annonce dans le fichier binaire\n");
        printf("9 : supprimer une annonce\n");
        printf("votre choix :");
        scanf("%d", &choix);
        switch(choix){
            case 0: break;
            case 1: 
                    break;
            case 2: 
                    break;
            case 3: 
                    break;
            case 4: 
                    break;
            case 5: 
                    break;
            case 6: 
                    break;
            case 7: 
                    break;
            case 8: 
                    
                    break;
            default: printf("erreur de choix\n");
        }
    }
    return EXIT_SUCCESS;
}

void initStock(t_stock *stock_auto){
        for (int i = 0; i < MAX_ANNONCES; i++)
        {
                stock_auto->tab_annonces[i] = ANNONCE_VIDE;
                stock_auto->nb = 0;

        }
        
}
void lectureTexte1(){
        FILE* fic;
        char txt[1000]; 
        fic = fopen("annonces.csv","r+");
        fread();
        
        
}

void lectureTexte2(){}
void lectureTexte3(){}
void afficheAnnonces()
void afficheAnnoncesMarque(){}
void sauvegardeBinaire(){}
void lectureBinaire(){}
void saisieAnnonce(){}
void ajoutAnnonceFichierBinaire(){}