
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<errno.h>
#define ARRAYLENGTH 6


int read_value()
{
   int n;
   printf(" Digite o valor \n");
   scanf("%d",&n);
   return n;

}

void read_array_number(int Array[]) 
{
  for ( int i = 0; i <= ARRAYLENGTH; i++)
  {
     Array[i] = read_value();
  }
}


void show_array(int Array[])
{
   for (int i = 0; i < ARRAYLENGTH; i++)
   {
     printf(" %d \n",Array[i]);
   }
}



//--------------------------------------------------  implementacao no main 


int main(void)
{

  FILE *arq;
  pid_t child ; int aux , status , ARRAY[ARRAYLENGTH];

 printf(" read array elements \n");
 
 read_array_number(ARRAY);

 child = fork();

 if ( child < 0 )
 {
   perror("Error creating a process \n");
 }
 else if ( child == 0)
 {
   arq = fopen("arquivo.txt","w+");
   if ( arq == NULL )
      printf("Error could not create \n");
  else
  {
     


  
  
