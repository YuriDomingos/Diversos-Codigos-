#include<stdio.h>
#include<stdlib.h>
#include<time.h>


int main(void)
{

   clock_t t;

t = clock();

for ( int i = 0; i <= 100; i++)
{
   printf( " i = %d ",i);
  
     t = clock()-t;

  printf(" time = %.13f \n",((double)t)/((CLOCKS_PER_SEC/100)));
}

return 0;

}
 
