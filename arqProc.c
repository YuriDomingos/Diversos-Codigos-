#include<stdio.h>
#include<stdlib.h>

/*

@Autor : Yuri Domingos 
Data   : Código velho
*/


int main()
{
   FILE *arq;
 
   arq = fopen("arquivo.txt", "w+");
   int i = 0;
   if ( arq == NULL )
      printf(" error while was creating \n");
   else
   {
      while( i <=10 )
      {
               fprintf(arq," %d \n",i);
               i++;
       }
    }
  
  fclose(arq);

 return 0;

 } 


