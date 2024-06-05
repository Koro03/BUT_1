#include "const.h"
#include "types.h"

t_file initialiser(){
    t_file f;
    for (int i = 0; i < MAX_MESSAGES; i++)
    {
        f.tabElt[i] = ELTVIDE;     
    }
    f.nbElt += 1 ;
    return f;    
}