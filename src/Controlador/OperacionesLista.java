/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;

/**
 *
 * @author Kirig
 */
public class OperacionesLista {

    // Clase interna Nodo
    private class Nodo {

        private Alumno alumno;
        private Nodo siguiente;

        public Nodo(Alumno alumno) {
            this.alumno = alumno;
            this.siguiente = null;
        }
        
        public Alumno getAlumno() {
            return alumno;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    private Nodo cabeza;

    // Método para agregar un alumno a la lista (al principio)
    public void agregar(Alumno alumno) {
        Nodo nuevoNodo = new Nodo(alumno);
        if (cabeza == null) {      //insertamos 1er alumno (no hay nada en la cabeza)
            cabeza = nuevoNodo;         //1er nodo d la lista
        } else {                    //ya tiene elementos la lista (se meteran al final d la lista los alumnos)
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);     // enlaza al final
        }
    }

    // Buscar alumno por matrícula
    public Alumno buscarPorMatricula(String matricula) {

        return null;
    }

    // Buscar alumnos por licenciatura
    public void buscarPorLicenciatura(String claveLic) {
        
        Nodo lic =cabeza;//inicia el nodo desde la cabez
        if(lic!=null){//compara el primer valor en la lista para saber si forma parte de la licenciatura buscada
            if (claveLic.equals(lic.getAlumno().getLicenciatura())) {
                System.out.println(lic.getAlumno().toString());
            }
        }
        //avanza un nodo en la lista y comienza a comparar, siempre y cuando el siguiente nodo no este vacio
        while(lic.getSiguiente()!=null){ 
            lic=lic.getSiguiente();
            if (claveLic.equals(lic.getAlumno().getLicenciatura())) {//compara la licenciatura buscada con la del alumno
                System.out.println(lic.getAlumno().toString());//imprime los datos del alumno
            }   
        }
    }

    // Buscar alumnos por género
    public void buscarPorGenero(String genero) {

    }

    // Eliminar alumno por matrícula
    public boolean eliminarPorMatricula(String matricula) {
        if (cabeza == null) {                //en caso de que se proporcione una lista sin nada
            System.out.println("La lista está vacía.");
            return false;
        }
        // Caso mas facil : alumno al principio de la lista
        if (cabeza.getAlumno().getMatricula().equals(matricula)) {
            cabeza = cabeza.getSiguiente(); // Se elimina el primer nodo(cabeza)
            return true;                //(si se eliminó al alumno)
        }
        // Recorremos la lista buscando al alumno
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {         //mientras haya alumnos en la lista
            if (actual.getSiguiente().getAlumno().getMatricula().equals(matricula)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // Se elimina el nodo
                return true;            //(si se eliminó al alumno)
            }
            actual = actual.getSiguiente();
        }
        //el alumno no existe
        return false;
    }

}
