package Laboratorio.Pract03.Propuestos.CalculadoraGenerica;

import java.util.Scanner;

public class Operador<T extends Number> {
    private T valor1;
    private T valor2;

    public Operador(T valor1, T valor2){
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    public T getValor1() {
        return valor1;
    }

    public T getValor2() {
        return valor2;
    }
    
}
class Main{
    static <T extends Number> double suma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    static <T extends Number> double resta(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    static <T extends Number> double producto(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    static <T extends Number> double division(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a.doubleValue() / b.doubleValue();
    }

    static <T extends Number> double potencia(T base, T exponente) {
        return Math.pow(base.doubleValue(), exponente.doubleValue());
    }

    static <T extends Number> double raizCuadrada(T a) {
        return Math.sqrt(a.doubleValue());
    }

    static <T extends Number> double raizCubica(T a) {
        return Math.cbrt(a.doubleValue());
    }

    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int opcion;
            do{
            System.out.println("Menu de Operaciones Clases Genericas: ");
            System.out.println("1. Suma\n2. Resta\n3.Producto\n4. Division\n5. Potencia\n6. Raiz Cuadrada\n7. Raiz Cubica\n8. Salir");
            opcion = scn.nextInt();
            if (opcion >= 1 && opcion <= 5) {
                System.out.print("¿Desea usar Integer (1) o Double (2)? ");
                int tipo = scn.nextInt();

                if (tipo == 1) {
                    System.out.print("Ingrese el primer número: ");
                    Integer a = scn.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    Integer b = scn.nextInt();
                    Operador<Integer> op = new Operador<>(a, b);
                    ejecutarOperacion(op, opcion);
                } else {
                    System.out.print("Ingrese el primer número: ");
                    Double a = scn.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    Double b = scn.nextDouble();
                    Operador<Double> op = new Operador<>(a, b);
                    ejecutarOperacion(op, opcion);
                }
            } else if (opcion == 6 || opcion == 7) {
                System.out.print("¿Desea usar Integer (1) o Double (2)? ");
                int tipo = scn.nextInt();

                if (tipo == 1) {
                    System.out.print("Ingrese el número: ");
                    Integer a = scn.nextInt();
                    if (opcion == 6)
                        System.out.println("Raíz cuadrada: " + raizCuadrada(a));
                    else
                        System.out.println("Raíz cúbica: " + raizCubica(a));
                } else {
                    System.out.print("Ingrese el número: ");
                    Double a = scn.nextDouble();
                    if (opcion == 6)
                        System.out.println("Raíz cuadrada: " + raizCuadrada(a));
                    else
                        System.out.println("Raíz cúbica: " + raizCubica(a));
                }
            } else if (opcion == 8) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida.");
            }
            }while(opcion!=8);
    }
    private static <T extends Number> void ejecutarOperacion(Operador<T> op, int opcion) {
        double resultado = 0;
        try {
            switch (opcion) {
                case 1:
                    resultado = suma(op.getValor1(), op.getValor2());
                    System.out.println("Resultado de la suma: " + resultado);
                    break;
                case 2:
                    resultado = resta(op.getValor1(), op.getValor2());
                    System.out.println("Resultado de la resta: " + resultado);
                    break;
                case 3:
                    resultado = producto(op.getValor1(), op.getValor2());
                    System.out.println("Resultado del producto: " + resultado);
                    break;
                case 4:
                    resultado = division(op.getValor1(), op.getValor2());
                    System.out.println("Resultado de la división: " + resultado);
                    break;
                case 5:
                    resultado = potencia(op.getValor1(), op.getValor2());
                    System.out.println("Resultado de la potencia: " + resultado);
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
