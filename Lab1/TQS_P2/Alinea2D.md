# Jacoco: 
Jacoco permite saber a coverage que os nossos testes estão a ter sobre os métodos das classes.
Olhando estes dados estatisticos podemos saber que métodos ainda não têm testes e desse modo averiguar se há necessidade de criação de mais testes

# Results interpretation:
Com base dos resultados do Jacoco podemos verificar que:  
    -Na classe CuponEuromillions o método format() não foi testado
    -Na classe Dip os métodos: generateRandomDip() e  equals(Object) foram parcialmente testados. Não tiveram coverage total ao nivel dos branches. 
    No entanto, auto-generated code como é o caso do equals() e do hashCode(), não precisa ser testado.
    -Na classe EuromillionsDraw os métodos generateRandomDraw() e getDrawResults(), não foram testados.
    
    