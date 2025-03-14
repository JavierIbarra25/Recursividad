public class VistaSolPoniente {

    public static void main(String[] args) {
        int[] alturas = {3, 7, 8, 3, 6, 1};
        int resultado = contarEdificiosConVista(alturas, alturas.length - 1, Integer.MIN_VALUE);
        System.out.println("Número de edificios con vista al sol poniente: " + resultado);
    }

    /**
     * Método recursivo para contar los edificios con vista al sol poniente.
     *
     * alturas            Array de alturas de los edificios.
     * indice             Índice actual en el array (comenzando desde el oeste).
     * @maxAlturaIzquierda Altura máxima encontrada a la izquierda del edificio actual.
     * Número de edificios con vista al sol poniente desde el índice actual.
     */
    public static int contarEdificiosConVista(int[] alturas, int indice, int maxAlturaIzquierda) {
        // Caso base: si hemos recorrido todo el array (llegamos al este)
        if (indice < 0) {
            return 0;
        }

        // Verificar si el edificio actual tiene vista al sol poniente
        int vistaActual = 0;
        if (alturas[indice] > maxAlturaIzquierda) {
            vistaActual = 1;
        }

        // Actualizar la altura máxima a la izquierda
        int nuevaMaxAlturaIzquierda = Math.max(maxAlturaIzquierda, alturas[indice]);

        // Llamada recursiva para el siguiente edificio (moviéndonos hacia el este)
        return vistaActual + contarEdificiosConVista(alturas, indice - 1, nuevaMaxAlturaIzquierda);
    }
}
