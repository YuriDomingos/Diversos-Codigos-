 #include <stdio.h>
#include <string.h>

/*
@Autor ; Yuri Domingos
Data   : 7 - 05 - 2021
Objectivo :
*/
void order_string_nomes(char nomes[100][100], char temp[100])
{
  for ( int i=0;i<4;i++)
  {
    for(int j=i;j<4;j++)
     {
        if(strcmp(nomes[i],nomes[j])>0)
        {
            strcpy(temp,nomes[i]);
            strcpy(nomes[i],nomes[j]);
             strcpy(nomes[j],temp);
        }

     }
      puts(nomes[i]);  // mostramos a lista de nome ordenada wey

    }
}


int main()
{

  char Engenheiros[100][100]={"Yuri","Milzio","Escutelo","Gilberto","Brutal"};

    char temp[100];
   order_string_nomes(Engenheiros,temp);




}
