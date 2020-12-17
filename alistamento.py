#@Autor : Yuri Francisco Domingos
#Data   : 08-04-2020
# -- Programa que resolve o problema do alistaento militar se pode informa, se nao informa quantos anos passaramo ou quantos nos faltam


ano_atual = 2020
idade_media = 18
ano_nascimento = int(input('Digite o ano de nascimento do jovem  !!'))

diferenca =ano_atual-ano_nascimento
if (((ano_atual - ano_nascimento) == idade_media )) :
  print (' chegou a hora do alismento {}'.format(idade_media))

elif (((ano_atual-ano_nascimento) < idade_media)) :
 
      print('Ainda falta {} anos para o alistamento porque voce atualmente tem {} anos'.format((idade_media-diferenca),diferenca))
else :
    print('Ja passou a hora do alistamento a {} anos porque voce tem {} anos'.format((diferenca-idade_media),diferenca))

#
 
