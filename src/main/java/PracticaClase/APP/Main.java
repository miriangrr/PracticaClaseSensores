package PracticaClase.APP;

import PracticaClase.Registro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;


public class Main {

    public static void main(String[] args) {

        List<Registro> registros = new ArrayList<>();

        LocalDateTime inicio = LocalDateTime.now().minusHours(2);

        // Generación de 100 registros con un bucle for
        for (int i = 0; i < 100; i++) {
            Double tempAleatoria = Math.random() * 30 + 10;
            Double humAleatoria = Math.random() * 100;
            registros.add(new Registro(inicio.plusMinutes(i), tempAleatoria, humAleatoria));
        }


        //1-filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70 y la
        //fecha sea anterior a la fecha actual, y mostrarlos.

        LocalDateTime ahora = LocalDateTime.now();

        registros.stream()
                .filter(r -> r.getTemperatura() > 25.0)
                .filter(r -> r.getHumedad() < 70.0)
                .filter(r -> r.getFechaHora().isBefore(ahora))
                .forEach(System.out::println);
        System.out.println("-----------------------------------");


        //2. Encontrar el registro con la temperatura más alta y mostrar el registro completo.

        registros.stream()
                .max((Comparator.comparing(Registro::getTemperatura)))
                .ifPresent(System.out::println);

        //
        //
        //3. Obtener una lista con las fechas/horas de todas las tomas de datos.
        System.out.println("----------------------------------");
        List<LocalDateTime> FechasTotal = registros.stream()
                .map(Registro::getFechaHora).toList();
        System.out.println("Lista fechas/horas" + FechasTotal.size());
        System.out.println("----------------------------------------------");


        //4. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
        //humedades y fechas/horas actualizadas.

        //registros.forEach(registro -> registro.setHumedad(registro.setHumedad((double) +5);
        registros.stream()
                .map(r -> {
                    r.setHumedad(r.getHumedad() + 5);
                    return r;
                })
                .forEach(IO::println);


        //5. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y mostrar la
        //temperatura, humedad y fecha.

        System.out.println("----------------------------------------------");

        registros.stream()
                .filter(r -> r.getHumedad() > 80)
                .min(Comparator.comparing(Registro::getTemperatura))
                .ifPresent(r -> System.out.println(
                        "Temp: " + r.getTemperatura() +
                                " | Hum: " + r.getHumedad() +
                                " | Fecha: " + r.getFechaHora()
                ));


        //6. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y la fecha
        //es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta condición o no.
        boolean existeAlerta = registros.stream()
                .anyMatch(r -> r.getTemperatura() > 30
                        && r.getHumedad() > 90
                        && r.getFechaHora().toLocalDate().equals(LocalDate.now()));
        System.out.println("----------------------------------------------");
        if (existeAlerta) {
            System.out.println("Cuidado,Hay una alerta");
        } else {
            System.out.println("No hay alerta");
        }


        //7. Muestra 10 registros saltándote los 5 primeros


        registros.stream().skip(5).limit(10).forEach(System.out::println);


        //8. Muestra los registros ordenados por fecha (sorted(Comparator))

        registros.stream()
                .sorted(Comparator.comparing(Registro::getFechaHora))
                .forEach(System.out::println);


        //9. Cuenta los registros que tengan temperatura mayor a 35 grados (count()).

        long ContadorRegistros = registros.stream()
                .filter(r -> r.getTemperatura() > 35.0)
                .count();
        System.out.println("Los registros mayores " + ContadorRegistros);




//10. Calcular la temperatura promedio de todos los registros
        OptionalDouble media= registros.stream()
                .mapToDouble(Registro::getTemperatura)
                .average();
        System.out.println("-----------------------------------");
    }
}
