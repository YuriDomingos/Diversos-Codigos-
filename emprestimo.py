
# @Autor : Yuri Francisco DOmingos  // Data  : 07-04-2020
#
# Objectivo : Escreva um programa para aprovar um emprestimo  bancario para compra de uma casa ! O programa vai perguntar o valor da casa 
# e o salario do comprador e em quantos anos ele pretende pagar a casa :
# Calcula o valor da prestacao mensal  sabendo que ele nao pode exceder 30% do salario  ( no caso o emprestimo sera nego  peloprograma do desnsvolvedor    
#
#


valor_casa = float(input('Qual e o valor da casa '))
salario_comprador = float(input('Qual e o  salario do comprador ')) 
percentagem_salario = salario_comprador*0.30

anos=int(input('Em quantos anos desejas pagar ? '))


perc_mensal = (anos*valor_casa)/salario_comprador # estou a pensar nas formulas 

# --  validations 


if ( perc_mensal > percentagem_salario ) :
    
      print('Sorry Credito negado {}'.format(perc_mensal))
else :
  print('Yes Credito concedido {}'.format(perc_mensal))     



# --  calculo da percentagem mensal
 #prestacao_mensal=(salario_comprador*valor_casa)/anos
 
 #if (prestacao_mensal > percentagem_salario ) :
  #   print ' Credito cedido '

 #else :

  # print ' Credito negado '








