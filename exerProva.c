/*
@Autor : Yuri Domingos
Data  :  15 - 06 -2020
Objectivo : Resolucao da prova  ( UCAN -> Sistemas Operativos 2 )
*/


#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<errno.h>
#include<sys/wait.h>



int main ( void )
{
  int n = 2, pids[2];

 printf(" Ola eu sou o pai %d \n", getpid());


 for ( int i = 0; i < n; i++ )
 {
   pids[i] = fork();

   if ( pids[i] == 0 ) break;
 }

 if ( pids[0] == 0 )
 {
    printf(" filho1 [ %d ]  Pai [ %d ] \n",getpid(),getppid());
 }

  if ( pids[1] == 0 )
 {
    printf(" filho2 [ %d ]  Pai [ %d ] \n",getpid(),getppid());
 }


return 0;

}


