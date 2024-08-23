package fesaragon.estructuradatos;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        try {
            ConjuntoADT<Integer> conjunto1 = new ConjuntoADT<>();
            ConjuntoADT<Integer> conjunto2 = new ConjuntoADT<>();
            conjunto1.agregar(1);
            conjunto1.agregar(2);
            conjunto1.agregar(3);
            conjunto2.agregar(3);
            conjunto2.agregar(4);
            conjunto2.agregar(5);
            System.out.println("\n\nVALORES DEL CONJUNTO 1: ");
            conjunto1.imprimir();
            System.out.println("VALORES DEL CONJUNTO 2: ");
            conjunto2.imprimir();
            //Eliminar elemento
            System.out.println("\n");
            System.out.println("Eliminacion del numero 1 en el conjunto 1: ");
            conjunto1.eliminar(1);
            conjunto1.imprimir();
            System.out.println();
            //Existe un elemento 2 en el conjunto 1
            String existeElemento = STR."El conjunto 1 contiene el número 2: \{conjunto1.contiene(2)}\n";
            System.out.println(existeElemento);
            // ConjuntoADT función: unión, intersección y diferencia
            System.out.println("Elementos de los conjuntos antes de union, interseccion y diferencia \nValores del conjunto 1: ");
            conjunto1.imprimir();
            System.out.println("Valores del conjunto 2: ");
            conjunto2.imprimir();
            System.out.println("\n");
            ConjuntoADT<Integer> union = conjunto1.union(conjunto2);
            System.out.println(STR."Longitud de conjunto union: \{union.longitud()} \nValores del conjunto union: ");
            union.imprimir();
            ConjuntoADT<Integer> interseccion = conjunto1.interseccion(conjunto2);
            System.out.println(STR."Longitud de conjunto intersección: \{interseccion.longitud()} \nValores del conjunto intersección: ");
            interseccion.imprimir();

            ConjuntoADT<Integer> diferencia = conjunto1.diferencia(conjunto2);
            System.out.println(STR."Longitud de conjunto diferencia: \{diferencia.longitud()} \nValores del conjunto diferencia: ");
            diferencia.imprimir();

        } catch (ExcepcionConjuntoADT e) {
            System.out.println(e.getMessage());
        }
    }
}
