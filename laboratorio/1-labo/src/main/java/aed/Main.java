// package sirve para organizar el código, este indica que esta clase pertenece al paquete aed, el nombre del paquete debe coincidir con la estructura de carpetas
package aed;

// Clase principal, el nombre de la clase debe coincidir con el nombre del archivo
// En Java, todo el código debe estar dentro de una clase
// Una clase es un molde para crear objetos, pero en este caso no vamos a crear objetos, solo vamos a usar métodos

class Main {

    // Primera función
    int fibonacci(int n) {
        int res;
        // El método de arriba nos dice que recibe un entero "x" y devuelve un entero "res"
        // En java los tipos de datos son estáticos, es decir, se deben declarar antes de usarlos, a diferencia de otros lenguajes como Python o JavaScript
        // Los declaramos al inicio del método, pero se pueden declarar en cualquier parte del método, siempre y cuando se declaren antes de usarlos

        // El resto del método es simplemente recursión sobre fibonacci, pero con una variable intermedia "res" para guardar el resultado, en lugar de devolverlo directamente
        if (n == 0) {
            res = 0;
        } else if (n == 1) {
            res = 1;
        } else {
            res = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return res;
    }

    // Segunda función (versión mas simple de la anterior)
    int fibonacciReturn(int n) {
        // Se pueden unificar estos if?
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciReturn(n - 1) + fibonacciReturn(n - 2);
    }

    // Tercera función
    // El tipo de dato double[] nos indica que "xs" es una lista de números con decimales.
    double maximo(double[] xs) {
        double res = 0;
        // double es un tipo de dato que representa números con decimales, es un tipo de dato primitivo, no es un objeto, por lo tanto no tiene métodos, a diferencia de otros tipos de datos como String o ArrayList que son objetos y tienen métodos

        for (double x : xs) {
            // x : xs es una forma de iterar sobre un array, es una forma mas sencilla de iterar, el : representa "en", osea que "x" es basicamente un numero con decimal que pertenece a "xs"
            if (x > res) {
                res = x;
            }
        }

        return res;
    }

    // Cuarta función
    // El tipo de dato int[] nos indica que "seq1" y "seq2" son listas de números enteros, y el tipo de dato int[] del método nos indica que devuelve una lista de números enteros
    int[] sumarArreglos(int[] seq1, int[] seq2) {
        int[] res = new int[seq1.length];

        // new int[seq1.length] es una forma de crear un nuevo array de enteros con el mismo tamaño que seq1, esto es necesario porque en Java los arrays tienen un tamaño fijo, a diferencia de otros lenguajes como Python o JavaScript donde los arrays pueden crecer dinámicamente
        // new es un operador que se usa para crear objetos, en este caso creamos un nuevo array de enteros con el mismo tamaño que seq1

        // Lo que le damos al bucle for, (int i = 0; i < seq1.length; i++) es la condición de iteración, tiene una forma de (inicialización; condición; actualización)
        // Esta forma de escribir las condiciones del bucle se llama "bucle for tradicional"
        for (int i = 0; i < seq1.length; i++) {
            // Hay un error, se debe a que seq1 y seq2 no tienen necesariamente el mismo tamaño, por lo tanto no se pueden sumar elemento por elemento, para solucionar esto se puede agregar una validación al inicio del método para verificar que ambos arrays tengan el mismo tamaño, si no es así se puede lanzar una excepción o devolver un array vacío
            res[i] = seq1[i] + seq2[i];
        }

        return res;
    }

    // Quinta función
    // String es el tipo de dato que representa una cadena de caracteres, es un tipo de dato primitivo, no es un objeto, por lo tanto no tiene métodos, a diferencia de otros tipos de datos como String o ArrayList que son objetos y tienen métodos
    String iniciales(String texto) {
        String res = "";
        for (int i = 0; i < texto.length(); i++) {
            // Inizializamos un bucle for tradicional con un entero i que arranca valiendo 0, luego si se cumple i < texto.length() se ejecuta el bloque de abajo y se le suma 1 a i
            if (i == 0 || (texto.charAt(i-1) == ' ' && texto.charAt(i) != ' ')) {
                // El operador == representa una comparación, = es solo para asignar un valor a una variable
                // El operador || representa un "o" y el operador && representa un "y"
                // El operador != representa "diferente de", es decir, si texto.charAt(i) es diferente de un espacio, entonces se cumple la condición
                // .charAt(i) es un método de la clase String que devuelve el caracter en la posición i, el primer caracter tiene la posición 0, el segundo caracter tiene la posición 1, y así sucesivamente
                res += texto.charAt(i);
            }
        }
        return res;
    }
}
