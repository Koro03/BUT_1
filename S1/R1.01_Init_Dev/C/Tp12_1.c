#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAXPROD 20

typedef char chaine10[11];
typedef struct{
    chaine10 reference;
    int dateEntStock;
}produit;


typedef struct{
    produit tabloStock[MAXPROD]; 
    int nbElts;
}t_pile;

void menu();
void saisir(produit *adr_prod, int dateJ);
void afficher(produit prod);
void entreProdStock(t_pile pile, produit *prod);
void modifdate(int* adr_datej);
void initProd();
void entreProdStock(t_pile pile, produit *prod);
void initPile(t_pile *pile);
bool estPleine(t_pile pile);
bool estVide(t_pile pile);



int main(){
    menu();
}

void menu(){
    int rep;
    produit adr_prod;
    int dateJ = 1; 
    t_pile pile; 
    initPile(&pile);
    do
    {
        printf("1) entree d'un produit dans le stock\n 2) vente d'un produit sortie du stock\n 3)le temps passe\n 0) Quitter\n");
        scanf("%d",&rep);
        
    } while (rep != 1 && rep != 2 && rep != 3 && rep != 0);
    if (rep == 1)
    {
        printf("quelle produit\n");
        saisir(&adr_prod,dateJ);
        entreProdStock(pile, &adr_prod);
            
    }
        /*else if (rep == 2)
        {
            ///sortieProdStock();
        }else if (rep == 3)
        {
            //modifdate();
        }else if (rep == 0)
        {
            // code 
        }
        */
    
}

void saisir(produit *adr_prod, int dateJ){
    // met dans *adr_prod un produit saisi au clavier à la date dateJ
    printf("référence ?\n");
    scanf("%s",adr_prod->reference);
    adr_prod->dateEntStock=dateJ;
}

void afficher(produit prod){
    // affiche à l'écran le produit prod
    printf("%s %d\n",prod.reference,prod.dateEntStock);
}
void modifdate(int* adr_datej){
    //tourne la page de l'éphéméride
    (*adr_datej)++;
}

void entreProdStock(t_pile pile, produit *prod){
    if (!estPleine(pile))
    {
        pile.tabloStock[pile.nbElts].dateEntStock = prod->dateEntStock;
        pile.nbElts++;
    }
 
}

void sortieProdStock(t_pile pile, produit *prod){
    if (!estVide(pile))
    {
        pile.tabloStock[pile.nbElts].dateEntStock = 0;
        pile.nbElts--;
    }
}

void initPile(t_pile *pile){
    for (int i = 0; i < MAXPROD; i++)
    {
        pile->tabloStock[i].reference = "vide";
    }
    
    pile->nbElts = 0; 
    
}

void vider(t_pile *pile){
    for (int i = pile->nbElts-1 ; i < MAXPROD; i--)
    {
        pile->tabloStock[i].reference = "vide";
    }
    
    pile->nbElts = 0;
}

bool estPleine(t_pile pile){
    bool pleine = false;
    if (pile.nbElts == MAXPROD)
    {
        pleine = true;
    }
    return pleine;
}

bool estVide(t_pile pile){
    bool vide = false;
    if (pile.nbElts == 0)
    {
        vide = true;
    }
    return vide;
    
}

/*****************file******************/

//vider enlever la première valeur en la stockant dans une 
//temp puis faire reculer la valeur du i plus garnd dans la valeur retirer
//ou stocker dans une temp puis faire que chaque valeur 
//est égale au i-1 puis supprimer la dernière valeur de la file
