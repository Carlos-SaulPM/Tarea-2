package fesaragon.estructuradatos;

public class ConjuntoADT<T> {
    private T[] conjunto;
    private int longitud;

    public ConjuntoADT() {
        this.conjunto = (T[]) new Object[0];
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean contiene(T elemento) {
        for (T aux : this.conjunto) {
            if (aux.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(T elemento) throws ExcepcionConjuntoADT {
        if (contiene(elemento)) {
            throw new ExcepcionConjuntoADT("El elemento ya se encuentra en el conjunto");
        }

        T[] aux = (T[]) new Object[longitud + 1];
        for (int i = 0; i < this.conjunto.length; i++) {
            aux[i] = this.conjunto[i];
        }
        aux[longitud] = elemento;
        this.conjunto = aux;
        this.longitud++;
    }

    public void eliminar(T elemento) throws ExcepcionConjuntoADT {
        if (!contiene(elemento)) {
            throw new ExcepcionConjuntoADT("No se encuentra el elemento para eliminarlo");
        }
        T[] aux = (T[]) new Object[longitud - 1];
        int j = 0; // Es para controlar el indice del arreglo aux
        for (int i = 0; i < this.conjunto.length; i++) {
            if (!conjunto[i].equals(elemento)) {
                aux[j++] = conjunto[i];
            }
        }
        this.conjunto = aux;
        this.longitud--;
    }

    public boolean equals(ConjuntoADT<T> conjunto2) {
        if (this.longitud != conjunto2.longitud){
            return false;
        }
        for (T elemento1 : this.conjunto) {
            if (!conjunto2.contiene(elemento1)) {
                return false;
            }
        }

        return true;
    }

    public boolean esSubConjunto(ConjuntoADT<T> conjunto2) throws ExcepcionConjuntoADT{
        if (conjunto2.longitud > this.longitud ){
            throw new ExcepcionConjuntoADT("El conjunto con el que estas comparando tiene mayores elementos, por ende no puede ser un subconjunto");
        }
        for (T elemento : this.conjunto) {
            if (!conjunto2.contiene(elemento)) {
                return false;
            }
        }
        return true;
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> conjunto2) throws ExcepcionConjuntoADT {
        ConjuntoADT<T> nuevoConjunto = new ConjuntoADT<>();
        for (T elemento : this.conjunto) {
            nuevoConjunto.agregar(elemento);
        }
        for (T elemento : conjunto2.conjunto) {
            if (!nuevoConjunto.contiene(elemento)) {
                nuevoConjunto.agregar(elemento);
            }
        }
        return nuevoConjunto;
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> conjunto2) throws ExcepcionConjuntoADT {
        ConjuntoADT<T> nuevoConjunto = new ConjuntoADT<>();
        for (T elemento : this.conjunto) {
            if (conjunto2.contiene(elemento)) {
                nuevoConjunto.agregar(elemento);
            }
        }
        return nuevoConjunto;
    }

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> conjunto2) throws ExcepcionConjuntoADT {
        ConjuntoADT<T> nuevoConjunto = new ConjuntoADT<>();
        for (T elemento : this.conjunto) {
            if (!conjunto2.contiene(elemento)) {
                nuevoConjunto.agregar(elemento);
            }
        }
        return nuevoConjunto;
    }
    public void imprimir() {
        System.out.print("{ ");
        for (T elemento : conjunto) {
            System.out.print(elemento + " ");
        }
        System.out.println("}");
    }

}
