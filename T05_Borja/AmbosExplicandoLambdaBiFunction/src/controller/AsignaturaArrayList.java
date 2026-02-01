package controller;

import model.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class AsignaturaArrayList {

    private ArrayList<Alumno> alumnos;

    public AsignaturaArrayList(){
        alumnos=new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno){
    //para saber si un alumno está: recorro y pregunto en iteracion.
    /*utilizo una lambda para que me devuelva aquel elemento que cumple
    con la condicion de busqueda, y lo que sería:
    for (Alumno a : alumnos){
    if (a.getDni().equals(alumno.getDni())){}
    pasaría a:*/
        //Opcion Filter:
        //alumnos.forEach(i->Alumno::mostrarDatos);

        /*Opcion Stream: Obtiene un elemento que coincida con la lista (un stream
        es un flujo de datos que pa en paralelo a la lista
            lista  -------------
            stream -------------
        , (las modificaciones en un stream se hacen en paralelo,
        a no ser que se haga una reasignación)).*/
        boolean seEncuentra=alumnos.stream().anyMatch(data -> data.getDni().equals(alumno.getDni()));
        if (seEncuentra) {
            System.out.println("el dni no puede introducirse porque ya se encuentra almacenado.");
        } else {
            System.out.println("Alumno agregado correctamente.");
            alumnos.add(alumno);
        }
        /*AnyMatch se parece mucho a contains, pero con la diferencia de que
        contains pregunta por el objeto y el anyMatch pregunta por una
        caracteristica del mismo DEVOLVIENDO UN BOOLEANO*/

        /* Si dentro del stream, quiero meter más logica antes de comparar, Sí o sí hay que poner
        la palabra reservada Return entre llaves:

                        boolean seEncuentra=alumnos.stream().anyMatch(data -> { return data.getDni().equals(alumno.getDni());});
        (aunque lo más común es que nos encontremos con comparaciones de una sola línea).*/

        /* Muy comunmente, lo que vamos a encontrar es:

            if (alumnos.stream().anyMatch(data -> data.getDni().equals(alumno.getDni()))) {
            System.out.println("el dni no puede introducirse porque ya se encuentra almacenado.");
            } else {
                alumnos.add(alumno);
            }
        (evitando tener que crear una variable y reservarle espacio en la memoria. */
    }

    public void calificarAlumnos(){
        alumnos.forEach(data->
            {
                if(data.getNota()<0){
                    data.setNota((int) (Math.random()*10)+1);
                }
            }
        );
    }

    public void mostrarUsuarios(){
        alumnos.forEach(Alumno::mostrarDatos);
    }
}
