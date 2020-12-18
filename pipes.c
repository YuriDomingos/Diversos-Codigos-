#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<errno.h>
#include<sys/types.h>
#include<string.h>




int main( void )
{
   int file1[2],file2[2], turn = 0; 
   pid_t pid;

if ( pipe(file1) < 0 )
 {
     printf(" error while was creating a pipeline comunicaction \n");
     return -1;
 }



if ( pipe(file2) < 0)
{
   printf(" error while was creating a pipeline comunicaction \n");
   return -1;

}

  pid = fork();

  if ( pid == -1 )
  {
     printf(" error while was creating a pipeline comunicaction \n");
     return -1;
  }


 if ( pid > 0 )
 {
   close(file1[0]);
   close(file2[1]);
    int num[2]; int soma;
 while(1)
 if ( turn == 0 )  // to send a value 
 {
      printf(" digite o primeiro numero \n"); scanf("%d",&num[0]);
      printf(" digite o primeiro numero \n"); scanf("%d",&num[1]);
   
      write(file1[1],num,sizeof(num));
      turn = 1;
 }
  else
    
   if ( turn  == 1 ) // is a father taking a value 
   {
    
      read(file2[0],&soma,sizeof(soma));    
      printf("  a soma  = %d \n ",soma);  
      turn  = 0; 
   }


   close ( file1[1]);
   close( file2[0]);
 
  
 }
 else
 {
      close ( file1[1]);
      close( file2[0]);
      int soma; int num[2];

    while(1){

    if ( turn == 0 )
   {
        read(file1[0], num, sizeof(num));
        turn = 1;
   }else
  
      if ( turn  == 1 )
      {
         soma = num[0]+num[1];
         write(file2[1], &soma,sizeof(soma));
         turn == 0;
      }


  close(file2[1]);
  close(file1[0]);

 }

 }
 
   return 0;
  
}
