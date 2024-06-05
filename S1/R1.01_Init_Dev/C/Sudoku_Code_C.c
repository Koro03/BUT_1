void chargerGrille(tGrille g){
    char nomFichier[30];
    FILE * f;
    printf("Nom du fichier ? ");
    scanf("%s", nomFichier);
    f = fopen(nomFichier, "rb");
    if (f==NULL){
    printf("\n ERREUR sur le fichier %s\n", nomFichier);
    } else {
    fread(g, sizeof(int), TAILLE*TAILLE, f);
    }
    fclose(f);
}

/*
typedef tGrille = tableau[];
var tGrille = tGrille;
numLigne, numColonne, valeur = int;
*/

void afficherGrille(){
    int i =0,j=0;
    printf("+---------+---------+---------+\n")
    while(i != 3){
        while(j != 3){
            printf("| %d  %d  %d |",i,i,i );
            printf(" %d  %d  %d|",i,i,i );
            printf(" %d  %d  %d|\n",i,i,i );
            j++;
        }
        printf("+---------+---------+---------+\n");  
        i++;
    }

}
int main(){
    
    afficherGrille();
    
}