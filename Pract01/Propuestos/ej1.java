package Laboratorio.Pract01.Propuestos;

import java.util.*;

public class ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de estudiantes: ");
        int n = scanner.nextInt();
        
        double[] calificaciones = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la calificacion del estudiante " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextDouble();
        }

        double mediana = calcularMediana(calificaciones);
        List<Double> moda = calcularModa(calificaciones);
        double desviacion = calcularDesviacionEstandar(calificaciones);

        System.out.println("Mediana: " + mediana);
        System.out.println("\nModa(s): ");
        for (double m : moda) {
            System.out.print(m + " ");
        }
        System.out.printf("\nDesviacion estandar: " + desviacion);
    }

    public static double calcularMediana(double[] datos) {
        double[] copia = datos.clone();
        Arrays.sort(copia);
        int n = copia.length;
        if (n % 2 == 0) {
            return (copia[n/2 - 1] + copia[n/2]) / 2.0;
        } else {
            return copia[n/2];
        }
    }

    public static List<Double> calcularModa(double[] datos) {
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double nota : datos) {
            frecuencia.put(nota, frecuencia.getOrDefault(nota, 0) + 1);
        }

        int maxFrecuencia = Collections.max(frecuencia.values());
        List<Double> modas = new ArrayList<>();
        
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() == maxFrecuencia && maxFrecuencia > 1) {
                modas.add(entry.getKey());
            }
        }

        if (modas.isEmpty()) {
            System.out.print("(No hay moda, todas se repiten una vez) ");
        }

        return modas;
    }

    public static double calcularDesviacionEstandar(double[] datos) {
        double suma = 0.0;
        for (double nota : datos) {
            suma += nota;
        }
        double media = suma / datos.length;

        double sumaCuadrados = 0.0;
        for (double nota : datos) {
            sumaCuadrados += Math.pow(nota - media, 2);
        }

        return Math.sqrt(sumaCuadrados / datos.length);
    }
}
