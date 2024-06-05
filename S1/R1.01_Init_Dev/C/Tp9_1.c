#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define N 9
#define N2 9

typedef int t_tab2dim[N][N2];

void init(t_tab2dim tab);
void afficher(t_tab2dim tab);
bool existe(t_tab2dim tab ,int valeur);

int main(){
    t_tab2dim tab;
    int val;
    init(tab);
    afficher(tab);
    printf("Quelle valeur <rechercher\n");
    scanf("%d",&val);
    existe(tab, val);
}

void init(t_tab2dim tab){
    
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N2; j++)
        {
           tab[i][j] = i + j; 
        }
        
    }
    
}

void afficher(t_tab2dim tab){
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N2; j++)
        {
           printf("%3d",tab[i][j]);
        }
        printf("\n");
        
    }
}
bool existe(t_tab2dim tab ,int valeur)
{
    int i=0,j=0;
    bool present = false;

    if (present != true)
    {           
        for (int i = 0; i < N; i++)
        {
            if (present != true)
            {
                for (int j = 0; j < N2; j++)
                {
                    if (tab[i][j] == valeur && present != true)
                    { 
                        present = true;
                        printf("val presente\n");

                    }
                    
                }
            }
                
        }
    }
    return present;
    
}



