/*
@Autor : Yuri Francisco Domingos 
Data   : 9 -06 - 2020
Disciplina : Sistemas Operativos
*/

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<signal.h>
#include<sys/wait.h>
#include<sys/types.h>

int main( void)
{
   pid_t  childpid;

  printf(" Hello I am a father %d \n",getpid());
   
   fflush(stdout);
  if ( (childpid = fork()) == -1 )
  {
     perror(" error  could not create a process \n");
     exit(1);

  }
  else if ( (childpid = fork()) == 0)
  {
     printf(" Hello I am son my PID =  %d, father PID = %d \n ", getpid(),getppid());
     exit(0);
  }
  else 
  {
     wait(0);
     printf(" I a father just to remember %d  \n", getpid());
  }

 return 0;

}

 
