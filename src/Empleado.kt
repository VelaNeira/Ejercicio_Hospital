//Se crea la Subclase "Empleado" de la clase base "Persona" 
open class Empleado(
    val codigoEmpleado: String,
    val horasExtras: Int,
    val fechaIngreso: String,
    val area: String,
    val cargo: String,
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudad: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudad) {
    // Método para calcular el salario, a ser sobreescrito en las clases derivadas
    open fun calcularSalario(): Double {
        return 0.0
    }
}