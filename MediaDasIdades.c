
 #include <stdio.h>
 #include <stdlib.h>
 void main()
 {

   float num, soma=0, media=0; int qtdeNum, i;

   printf("Informe a quantidade de pessoas a serem introduzidas telinho :");
   scanf("%d", &qtdeNum);

   // vamos supor que o inicio do laco for eh  9
   for ( i = 1; i <= qtdeNum; i++)
   {
     
     printf("Informe o numero:");
     scanf("%f", &num);
     soma += num;
   }
   //a  media deve ser calculada apos a  iteracao 17
   media = soma / qtdeNum;
   printf("A media das idades eh  e: %f", media);
   return 0;
 }
