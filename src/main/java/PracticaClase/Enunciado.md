Debes crear una clase Registro que va a almacenar las lecturas de temperatura y humedad de una
plantación. La clase llevará los siguientes atributos: LocalDateTime fechaHora, Double temperatura,
Double humedad. Debes crear una colección de 100 registros (genérala con un for o con
Stream.generate que cree objetos Registro poniendo valores aleatorios de temperatura y humedad, y
la fecha le añada un minuto a cada registro), y deberás resolver lo siguiente utilizando Streams:
1. Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70 y la
   fecha sea anterior a la fecha actual, y mostrarlos.
2. Encontrar el registro con la temperatura más alta y mostrar el registro completo.
3. Obtener una lista con las fechas/horas de todas las tomas de datos.
4. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
   humedades y fechas/horas actualizadas.
5. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y mostrar la
   temperatura, humedad y fecha.
6. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y la fecha
   es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta condición o no.
7. Muestra 10 registros saltándote los 5 primeros.
8. Muestra los registros ordenados por fecha (sorted(Comparator))
9. Cuenta los registros que tengan temperatura mayor a 35 grados (count()).
10. Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double> y
    llamar a average()).