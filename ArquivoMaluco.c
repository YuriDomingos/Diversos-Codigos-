/*
@Autor : Yuri Francisco Domingos
Data   : 08-04-2020
Objectivo : Escrever os metodos de buscas nas linguagem muito famosas como : C, JAVA ( BFS,DFS)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define MAX_ARESTA 100
#define ERROR_NO_MEMORY -1

// no java 

public class search_JAVA{


// Variables

private boolean marcado [];
private int  arestaPara [];
private int distanciaPara[];

//-------------------------------------
private void BFS_breath_first_search(Grafo g, int v)
{
   // create a queue 

  Fila<Integer> f = new Fila<Integer>();
  
  f.enfileira(v)
  marcado[v]=true; distanciaPara[v] = 0;
  
 while (! f.isEmpty())
 {
    int v1 = f.desenfileira();
     
       for (Aresta a : G.adje(v1))
       {
          int x = a.getV2();
           if (! marcado[x] == v1 )
           {
               arestaPara[x] = v;
               distanciaPara[x] = arestaPara[v]+1;
               marcado[x] = true;
               f.enfileira(x);
           }
   }   }
}


// here 
     


private void DFS_deept_first_search(Grafo G, int v)
{
   marcado[v] = true;
   
   for ( Aresta a : G.Adjac(v))
   {
      int x = a.getV2();
     if (! marcado[x] == v)
     {
        arestaPara[v] = v;
        DFS_deept_first_search(G, x)
     }

  }
}


// this breaket is to close a first block  
}

//-------------------- THis line we will start write a c code just to kepp 

     

typedef struct NO{
 
 int nroVizinho;
 bool visited;
 struct No* Vizinho[MAX_ARESTA];
 char information;  

}*VERTICE;

// just to start up like a simple code

  
struct create_Vertice(char informat)
{
   VERTICE novoVertice = (VERTICE) malloc(sizeof(struct NO));
   if ( novoVertice == NULL )
       return ERROR_NO_MEMORY;
  else
  {
    novoVertice->nroVizinho = 0;
    novoVertice->visited =false;
    novo->Vertice->information = informat;

  // let us clean up a structeres

  for (int i = 0; i< MAX_ARESTA; i++)
      novoVertice->vizinho[i] = NULL;
return (novoVertice);

}


// ----------- let us create it again 


void bfs_breath_firstSearch(VERTICE inicio, VERTICE  destino)
{
    VERTICE Fila[MAX_VERTICE];
   int inicioFila = 0; int tam = 1;
   
  for (int i = 0; i < MAX_ARESTA; i++)
  {
     Fila->Vizinho[i] =  NULL;
  }
Fila[inicioFila] = inicio;

while ( inicioFila < tam )
{
    if ( inicio ==  destino ) return  inicioFila;
  
   for (int i = 0; i < Fila[inicioFila]->nroVizinho; i++)
  {
     if ( Fila[incioFila]->Vizinho[i]->visited == false )
     {
       Fila[inicioFila]->Vizinho[i]->Visited = true;
       Fila[tam] = Fila[inicioFila]->Vizinho[i];
       tam++;
     }
     
   }
   inicioFila++;

}
return -1;

}

int dfs(VERTICE inicio, VERTICE destino, int visitado)
{
    inicio->visited = true;
    
  if ( inicio == true ) return visitado;
  
   int aux = 0;

  while (inicio[aux] != NULL )
  {
     if ( inicio->vizinho[aux] == false )
   {
       incio->vizinho[aux]->visited = true;
        int answer =  dfs(inicio->Vizinho[aux], destino, visitado+1);
         if ( answer != -1 )
 }

}  
   

















