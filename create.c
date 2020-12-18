
#include<stdio.h>
#include<stdlib.h>

void imprimir(int A[])
{
  for ( int i = 0; i < 5; i ++)
    printf(" %d \n",A[i]);

}


int main(void)
{

 int array [] = {3,2,1,0,4}; 
  int aux;
  imprimir(array);

 for ( int i = 0; i <=5-1; i++)
 {
    for ( int j = i+1; j <=i-1; j++)
      
       if ( array[i] > array[j])
       {
          aux = array[i];
         array[i] = array[j];
         array[j] =  aux;
   }
}

printf(" depois \n");
 imprimir(array);
  return 0;
}
