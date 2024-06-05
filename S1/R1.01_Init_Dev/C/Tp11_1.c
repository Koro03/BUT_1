#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef char t_chaine50[51] ;
typedef char t_chaine10[11] ;
typedef struct{
    t_chaine50 c_nom; // nom de l’abonné
    t_chaine10 c_num; // numéro de cet abonné
    int c_duree; // durée pour laquelle il est abonné
} t_abonne ;

void affichagAbo();

void creerFichier(char nomfic, t_abonne * abo);

void listerFichier(char nomFic,t_abonne abo);

void ajouterDansFichier();

int main() {
    affichagAbo();
}

void affichagAbo(){
    int numMenu;
    //bool fichierCree = false;
    char nomFic[20];
    t_abonne abo;
    do{
        printf("Quelle option choisir\n 1: creer fichier abo\n 2:lister le fichiers abonnes\n 3: ajouter des abo\n -5:Quitter le menu \n");
        scanf("%d",&numMenu);
    }while(numMenu != 1 && numMenu != 2 && numMenu != 3 && numMenu != -5);
    if(numMenu == 1){
        printf("Quelle nom donne tu a ton fichier\n");
        scanf("%s",nomFic);
        creerFichier(nomFic, &abo );
    }
    else if(numMenu == 2 )
    {
        listerFichier(nomFic,abo);    
    }
    /*elseif(numMenu == 3 )
    {

    }
    */
}

void creerFichier(char fic, t_abonne * abo){
    FILE * mon_fichier;
    mon_fichier = fopen("MOMO.data","w");
    printf("Quelle nom d'abo\n");
    scanf("%s",abo->c_nom);
    printf("Quelle num d'abo\n");
    scanf("%s",abo->c_num);
    printf("Quelle temps d'abo\n");
    scanf("%d",&(abo->c_duree));
    fwrite(abo, sizeof(t_abonne),1,mon_fichier);
    fclose(mon_fichier);
}

void listerFichier(char nomFic,t_abonne abo){
    FILE * mon_fichier;
    mon_fichier = fopen("MOMO.data","r");
    fread(&abo, sizeof(t_abonne),1,mon_fichier);
    while(!feof(mon_fichier)){
        printf("coordonees du client : %s %s %d\n",abo.c_nom,abo.c_num,abo.c_duree);
        fread(&abo,sizeof(t_abonne),1,mon_fichier);
    }
    fclose(mon_fichier);
}

void ajouterDansFichier(char nomFic){
    FILE * mon_fichier;
    mon_fichier = fopen("MOMO.data","a+");
    printf("Quelle nom d'abo\n");
    scanf("%s",abo->c_nom);
    printf("Quelle num d'abo\n");
    scanf("%s",abo->c_num);
    printf("Quelle temps d'abo\n");
    scanf("%d",&(abo->c_duree));
    fwrite(abo, sizeof(t_abonne),1,mon_fichier);
    fclose(mon_fichier);
}
