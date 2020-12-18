#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<unistd.h>


int main ( void )
{
 pid_t child;
 int turn = 0 , file1[2] , file2[2]; // I have create two pipe to comunicate them 

if ( (pipe(file1) < 0 ) || ( pipe (file2) < 0))  
{
  perror(" error while was creting a pipelines \n");
  return -1;
}

 child = fork();  

if ( child < 0 )
{
   perror(" error while was creating a son \n");
   return -1;
}

if ( child == 0 )
{
   int number[2] , soma;
   
  close(file1[0]);  // I closed  a read of father and left opened write option  well
  close(file2[1]);  // I closed son write power and  

  while(1)
  if ( turn == 0 )
  {
     printf(" digite o primeiro numero \n"); scanf("%d",&number[0]);
     printf(" digite o segundo  numero \n"); scanf("%d",&number[1]);
    
     write(file1[1], number, sizeof(number));
     turn  = 1;
   

  }
  else
  {
     if ( turn  == 1 )
     {
         read(file2[0], &soma, sizeof(soma));

         printf(" o resultado da soma eh %d \n",soma);
     } 
    
  }


  close(file1[1]);
  close(file2[0]);

}
else
{

   int number[2], soma;
 
   close(file2[0]);
   close(file1[1]);


 while(1)
 {  
   if ( turn == 0 )
   {
     read(file1[0], number, sizeof(number));
     turn = 1; 
  }
  else
  {
      soma = number[0]+number[1]; 
      write(file2[1], &soma, sizeof(soma));
      turn = 0;
  }

 }


  close(file1[0]);
  close(file2[1]);
 
}  

 

 return 0;

}
