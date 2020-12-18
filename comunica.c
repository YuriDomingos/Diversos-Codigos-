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

   int son1, son2 , status1, status2;

     FILE *arquivo;
     arquivo = fopen("/home/yuri/Documents/Yuri_novo/ProcessosUcan/Pipes_Train/comunica1.txt","w+");

    if ( arquivo != NULL )
    {
        printf(" O processp pai chegou %d \n e chamo meus filhos  filho 1 = filho2  \n", getpid()); 
     
        fflush(stdout);  
        if ( (son1 = fork()) == -1 )
        { 
             perror(" Error while was creating a fork routine \n");
             return -1;
        }
        else if ( son1 ==  0 )
        {
           //printf(" filho PID =  [ %d ] chegou para responder o pai %d \n",getpid(),getppid());      
     
        }
        else
        {
            waitpid(son1,&status1,0);
        }

       fflush(stdout);
  
       if ( (son2 = fork()) == -1 )
        { 
             perror(" Error while was creating a fork routine \n");
             return -1;
        }
        else if ( son2 ==  0 )
        {
           printf(" filho2 PID =  [ %d ] chegou para responder o pai [%d] \n ",getpid(),getppid());      
     
        }
        else
        {
            waitpid(son2,&status2,0);
        }
         
       fflush(stdout);
    }else
        perror(" error could not create a file \n");


   fclose(arquivo);


 return 0;

}

  
