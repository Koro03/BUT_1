#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

int evoluCyclisme(int cyclismeS,int footS,int voileS, int inactifS);
int evoluFoot(int cyclismeS,int footS,int voileS, int inactifS);
int evoluVoile(int cyclismeS,int footS,int voileS, int inactifS);
int evoluInactifs(int cyclismeS,int footS,int voileS, int inactifS);

#define cyclisme 35
#define  foot  25 
#define  voile  20
#define  inactif 20

int main(){
    int cyclismeS = cyclisme , footS = foot, voileS = voile ,inactifS = inactif; 
    cyclismeS = evoluCyclisme(cyclismeS,footS,voileS,inactifS);
    printf("vélo : %d\n", cyclismeS);
    footS = evoluFoot(cyclismeS,footS,voileS,inactifS);
    printf("foot : %d\n", footS);
    voileS = evoluVoile(cyclismeS,footS,voileS,inactifS);
    printf("voile : %d\n",voileS);
    inactifS = evoluInactifs(cyclismeS,footS,voileS,inactifS);
    printf("inactifs : %d\n",inactifS);
    return 0;
}

int evoluCyclisme(int cyclismeS,int footS,int voileS, int inactifS){
    cyclismeS = cyclismeS - ((cyclisme*3.0/100) + (cyclisme*2.0/100) + (cyclisme*5.0/100));
    cyclismeS = cyclismeS + (foot*6.0/100) + (voile*8.0/100) + (inactif * 5.0/100);
    return cyclismeS;
}   
int evoluFoot(int cyclismeS,int footS,int voileS, int inactifS){
    footS = footS - ((foot*6.0/100) + (foot* 3.0/100)+ (foot * 11.0/100));
    footS = footS + ((cyclisme*3.0/100) + (voile* 2.0/100)+ (inactif * 3.0/100));

    return footS;
}
int evoluVoile(int cyclismeS,int footS,int voileS, int inactifS){
    voileS = voileS - ((voile*6.0/100) + (voile* 2.0/100)+ (voile * 15.0/100));
    voileS = voileS + ((cyclisme*2.0/100) + (foot* 3.0/100)+ (inactif * 4.0/100));    
    return voileS;
}
int evoluInactifs(int cyclismeS,int footS,int voileS, int inactifS){
    inactifS = inactifS - ((inactif*5.0/100) + (inactif* 3.0/100)+ (inactif * 4.0/100));
    inactifS = inactifS + ((cyclisme*5.0/100) + (foot* 11.0/100)+ (voile * 15.0/100));    
    return inactifS;
}