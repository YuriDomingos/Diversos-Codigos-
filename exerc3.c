
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/wait.h>
#include<sys/types.h>
#define NUMPROCESS 3


/*


@Autor : Yuri Domingos 
Data   : Código velho

*/
int main ( void )
{
   int n = 2, pids[NUMPROCESS] , i;

  printf(" Hello I am a father and I will have 2 son  | MY PID = %d \n",getpid());

  //-- we will use a for to create many tasks or jobs 

 for ( i = 0; i < n; i++)
 {
   pids[i] = fork();
  
  if ( pids[i] == 0) break;
 }

 if ( pids[0] == 0)
 {
   printf("  Son 1  PID = %d my father = %d \n",getpid(),getppid());
 } 

else if ( pids[1] == 0 )
{
  printf(" Son 2  PID = %d my father = %d ",getpid(),getppid());
}

exit(0);

return 0;

}



