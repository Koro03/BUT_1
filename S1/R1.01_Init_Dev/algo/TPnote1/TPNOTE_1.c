#include <stdio.h>
#include <stdlib.h>

const int Prix1 = 5;
const int Prix2 = 8;
const int Prix3 = 11;
const int Prix4 = 15;
int main(){

    int age,distance;

    printf("Quelle age avez vous ?\n");
    scanf("%d", &age);

    printf("Quelle disatance voulez vous courir ?(5,12,20km)\n");
    scanf("%d", &distance);    

    if (age < 15 && distance == 5 ){
        printf("Vous allez payez %d", Prix1);
    }else if(age < 15 && distance == 12 ){
        printf("Vous allez payez %d", Prix1);
    }else if (age < 15 && distance == 20 ){
        printf("Vous allez payez %d", Prix2);
    }
    
    else if((age >= 15 && age < 60) && distance ==5){
        printf("Vous allez payez %d", Prix3);
    }else if((age >= 15 && age < 60) && distance ==12){
        printf("Vous allez payez %d", Prix3);
    }else if((age >= 15 && age < 60) && distance ==20){
        printf("Vous allez payez %d", Prix4);
    }
    
    else if(age >= 60 && distance ==5){
        printf("Vous allez payez %d", Prix1);
    }else if(age >= 60 && distance ==12){
        printf("Vous allez payez %d", Prix2);
    }
    else if(age >= 60 && distance ==20){
        printf("Vous allez payez %d", Prix3);
    }
    return EXIT_SUCCESS ;
}