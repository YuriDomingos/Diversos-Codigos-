/*
@Autor : Yuri Domingos
Data   : 16 - 12 - 2020
Objetivo : Resolver a prova de C 

*/

#include<stdio.h>
#include<stdlib.h>

int main(void)
{
    printf(" -----------------------------------------------------------------------------------\n");
    printf("|                                                                                   |\n");
    printf("|                                                                                   |\n");
    printf("|                            Sistema de Crédito da Empresa YuriSystems              |\n");
    printf("|                                                                                   |\n");
    printf("|                                                                                   |\n");

    printf("|                                                                                   |\n");
    printf("------------------------------------------------------------------------------------|\n");

double salario = 0.0;
double desconto ;
double juro ;
double credito_valor = 10.00000000;
int anoDeRetorno;




printf(" Digite o salario do funcionario :");

scanf("%lf",&salario);

if (salario <= 200)
{
    printf("Erro ! O credito nao pode ser concedido, salario insuficiente \n");

}else
{
    printf(" Sim pode pode ter o crédito : ");

     desconto= (salario*25/100); // subtrai o valor os 25% dos funcionários beneficiados
     juro = (salario*10/100);    // Subtrai o valor do juro do crédito concedido
   


    anoDeRetorno = ((salario)/(desconto+juro)); // o salário bruto 
     
    salario -=(desconto+juro);

    printf("O valor do salario que vai ganhar mensalmente %lf \n", salario );
    printf("Vai pagar o credito durante %d anos   \n ",  anoDeRetorno);

}

    return 0;
}