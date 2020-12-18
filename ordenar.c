#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<unistd.h>
#define ARRAY_LENGTH 6 

/*
@Autor : Yuri Domingos
Objectivo : Brincar com pipes 
Data : 17 -06 - 2020
*/


void carregar(int V[] )
{

  int A[ARRAY_LENGTH] = { 5,2,0,1,-1,4};

 for ( int i = 0; i < ARRAY_LENGTH; i++)
 {
     V[i] = A[i];
 }

}
 

void sort_array(int Array1[], int Array2[], int counter)
{
   int help = Array1[counter];
   Array1[counter] = Array2[counter];
   Array2[counter] = help;
}


void show_up( int Array[], int length, int i)
{
  if ( i < length)
  {
     printf(" %d ",Array[i]);
     show_up(Array,length, i+1);

   }
}
  


int main ( void )
{
   pid_t child;
   int fd1[2], fd2[2], turn = 0;


if ( ( pipe(fd1) < 0) || ( pipe(fd2) < 0) )
{
  perror(" error while was creating information \n");
  return -1;

}


child = fork();

if ( child < 0 ) 
{
  perror(" error while was creating a child task \n");
  return -1;
}

if ( child == 0 )
{
   int ARRAY[ARRAY_LENGTH] , ARRAY_SORT[ARRAY_LENGTH];
   carregar(ARRAY);
   printf(" First apresentation array in our screen \n\n");
   show_up(ARRAY, ARRAY_LENGTH,0);
   printf("\n \n     \n");

  close(fd1[0]);
  close(fd2[1]);

  while(1)
      if ( turn  == 0)
      {
          write(fd1[1], ARRAY,sizeof(ARRAY));
          turn  = 1;
      }
      else
      {

        read(fd2[0],ARRAY_SORT, sizeof(ARRAY_SORT));
        printf(" depois da conversa com filho \n\n");
           show_up(ARRAY_SORT, ARRAY_LENGTH,0);
       turn  = 0;

      }

  close(fd1[1]);
  close(fd2[0]);

}
else
{ 

       int ARRAY[ARRAY_LENGTH] , ARRAY_SORT[ARRAY_LENGTH];
   
      close(fd1[1]);
      close(fd2[0]);

   while(1)
   {
    if ( turn  == 0 )
    {
       read(fd1[0], ARRAY, sizeof(ARRAY));
       turn = 1;
    }
   else
   
    if ( turn  == 1 )
    {
      for ( int i = 0; i <= ((ARRAY_LENGTH )/2); i++)
      {
          sort_array( ARRAY , ARRAY_SORT,i);
      }
   
      write(fd2[1], ARRAY_SORT, sizeof(ARRAY_SORT));
      turn = 0;
    }
  }
 


 close(fd1[1]);
 close(fd2[0]);

}

return 0;

}            
     
         
      
                

    

 

     



