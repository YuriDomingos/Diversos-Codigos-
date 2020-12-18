/*
@Autor : Yuri Francisco Domingos
Data   : 9 -06 - 2020
*/

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

int main( void )
{

//-- esta linha mostra uma chamada de sistema

int pid;

pid = fork();


if ( pid == 0) 

  execl("/bin/ls","ls","-al",NULL);

}
 else
  execl("/bin/pwd","pwd",NULL);

 return 0;
}
