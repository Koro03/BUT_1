#ifndef TYPES_H
#define TYPES_H
#include "const.h"
typedef char t_message[MAX_CAR];
typedef struct {
    t_message message;
}t_element;

typedef struct 
{
    t_element tabElt[MAX_MESSAGES];
    int nbElt;
}t_file;
#endif