package main;

import java.util.Scanner;
import java.util.Random;

public class Proyecto_3 {

    static Scanner sc = new Scanner(System.in);

    static class Numero {
        int valor;
        Numero(int valor) { this.valor = valor; }
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuOpciones();
            opcion = leerEntero("Elija el programa a ejecutar: ");
            switch (opcion) {
                case 1:  validacionContra();       break;
                case 2:  calculadora();            break;
                case 3:  numerosPrimos();          break;
                case 4:  sumaNumerosPares();       break;
                case 5:  convertirTemperatura();   break;
                case 6:  contadorVocales();        break;
                case 7:  calculoFactorial();       break;
                case 8:  juegoAdivinar();          break;
                case 9:  pasoReferencia();         break;
                case 10: tablaMultiplicar();       break;
                case 11: System.out.println("-Usted ha salido del Programa-"); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 11);
    }
    
    public static void mostrarMenuOpciones() {
        System.out.println("\n------- Menú Principal -------");
        System.out.println(" 1.  Validación de contraseña");
        System.out.println(" 2.  Calculadora básica");
        System.out.println(" 3.  Números primos");
        System.out.println(" 4.  Suma de números pares");
        System.out.println(" 5.  Conversión de temperatura");
        System.out.println(" 6.  Contador de vocales");
        System.out.println(" 7.  Cálculo de factorial");
        System.out.println(" 8.  Juego de adivinanza");
        System.out.println(" 9.  Paso por referencia");
        System.out.println("10.  Tabla de multiplicar");
        System.out.println("11.  Salir del programa");
        System.out.println("_________________________________");
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
//case 1
    public static void validacionContra() {
        System.out.println("\n--- Validación de contraseña ---");
        final String contraseñaCorrecta = "1234";
        String contraseña;
        do {
            System.out.print("Ingrese la contraseña: ");
            contraseña = sc.nextLine();
            if (!contraseña.equals(contraseñaCorrecta)) {
                System.out.println("Contraseña incorrecta. Intente nuevamente.");
            }
        } while (!contraseña.equals(contraseñaCorrecta));
        System.out.println("Contraseña Correcta.");
    }
 //case 2
    public static void calculadora() {
        System.out.println("\n--- Calculadora básica ---");
        double numero1 = leerDouble("Ingrese el primer número: ");
        double numero2 = leerDouble("Ingrese el segundo número: ");
        System.out.println("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir");
        int operacion = leerEntero("Elija una operación: ");
        switch (operacion) {
            case 1: System.out.println("Resultado: " + sumar(numero1, numero2));       break;
            case 2: System.out.println("Resultado: " + restar(numero1, numero2));      break;
            case 3: System.out.println("Resultado: " + multiplicar(numero1, numero2)); break;
            case 4:
                if (numero2 != 0) System.out.println("Resultado: " + dividir(numero1, numero2));
                else           System.out.println("Error: no se puede dividir entre cero.");
                break;
            default: System.out.println("Operación inválida.");
        }
    }

    public static double sumar(double x, double y)       { return x + y; }
    public static double restar(double x, double y)      { return x - y; }
    public static double multiplicar(double x, double y) { return x * y; }
    public static double dividir(double x, double y)     { return x / y; }

//case 3
    public static void numerosPrimos() {
        System.out.println("\n--- Números primos ---");
        int numero = leerEntero("Ingrese un número: ");
        if (esPrimo(numero))
            System.out.println(numero + " ES un número primo.");
        else
            System.out.println(numero + " NO es un número primo.");
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
//case 4
    public static void sumaNumerosPares() {
        System.out.println("\n--- Suma de números pares ---");
        int suma = 0;
        int numero = leerEntero("Ingrese un número (0 para terminar): ");
        while (numero != 0) {
            if (numero % 2 == 0) suma += numero;
            numero = leerEntero("Ingrese un número (0 para terminar): ");
        }
        System.out.println("La suma de los números pares es: " + suma);
    }
    
//case 5
    public static void convertirTemperatura() {
        System.out.println("\n--- Conversión de temperatura ---");
        System.out.println("1. Celsius a Fahrenheit\n2. Fahrenheit a Celsius");
        int opcion = leerEntero("Opción: ");
        double temp = leerDouble("Ingrese la temperatura: ");
        if (opcion == 1)
            System.out.println("Resultado: " + celsiusAFahrenheit(temp) + " °F");
        else if (opcion == 2)
            System.out.println("Resultado: " + fahrenheitACelsius(temp) + " °C");
        else
            System.out.println("Opción inválida.");
    }

    public static double celsiusAFahrenheit(double a) { return (a * 9.0 / 5) + 32; }
    public static double fahrenheitACelsius(double b) { return (b - 32) * 5.0 / 9; }

//case 6
    public static void contadorVocales() {
        System.out.println("\n--- Contador de vocales ---");
        System.out.print("Ingrese una palabra o frase: ");
        String texto = sc.nextLine();
        System.out.println("Cantidad de vocales: " + contarVocales(texto));
    }

    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') contador++;
        }
        return contador;
    }

//case 7
    public static void calculoFactorial() {
        System.out.println("\n--- Cálculo de factorial ---");
        int numero = leerEntero("Ingrese un número entero no negativo: ");
        long resultado = factorial(numero);
        if (resultado >= 0)
            System.out.println("El factorial de " + numero + " es: " + resultado);
    }

    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("No se permiten números negativos.");
            return -1;
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) resultado *= i;
        return resultado;
    }

//case 8
    public static void juegoAdivinar() {
        System.out.println("\n--- Juego de adivinanza ---");
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int intento;
        do {
            intento = leerEntero("Adivine el número (1-100): ");
            if      (intento < numeroSecreto) System.out.println("El número es mayor.");
            else if (intento > numeroSecreto) System.out.println("El número es menor.");
        } while (intento != numeroSecreto);
        System.out.println("¡Correcto! El número era " + numeroSecreto + ".");
    }

//case 9
    public static void pasoReferencia() {
        System.out.println("\n--- Paso por referencia ---");
        int v1 = leerEntero("Ingrese el primer número: ");
        int v2 = leerEntero("Ingrese el segundo número: ");
        Numero num1 = new Numero(v1);
        Numero num2 = new Numero(v2);
        System.out.println("Antes:  num1 = " + num1.valor + "  |  num2 = " + num2.valor);
        intercambiar(num1, num2);
        System.out.println("Después: num1 = " + num1.valor + "  |  num2 = " + num2.valor);
    }

    public static void intercambiar(Numero a, Numero b) {
        int temp = a.valor;
        a.valor  = b.valor;
        b.valor  = temp;
    }
    
//case 10
    public static void tablaMultiplicar() {
        System.out.println("\n--- Tabla de multiplicar ---");
        int numero = leerEntero("Ingrese un número: ");
        generarTabla(numero);
    }

    public static void generarTabla(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}
       
       
		


