//Se crea una subclase "EmpleadoEvento" derivada de la subclase "Empleado" 
class EmpleadoEventual(
    val honorariosPorHora: Double,
    val horasTotales: Int,
    val fechaTerminoContrato: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudad: String
) : Empleado(codigoEmpleado, horasExtras, fechaIngreso, area, cargo, dni, nombre, apellido, fechaNacimiento, direccion, ciudad){
    // Implementación del cálculo de salario para empleados eventuales
    override fun calcularSalario(): Double {
        val salarioBase = honorariosPorHora * (horasTotales - horasExtras) // Honorarios por horas normales
        val salarioHoraExtra = honorariosPorHora * 1.5 // Suponiendo un 50% más por horas extras
        return salarioBase + (horasExtras * salarioHoraExtra)
    }
}
