// Se creo la subclase "Empleado por plantilla" derivada de la subclase "Empleado"
class EmpleadoPlanilla(
    val salarioMensual: Double,
    val porcentajeAdicionalHoraExtra: Double,
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
    // Implementación del cálculo de salario para empleados por planilla
    override fun calcularSalario(): Double {
        val salarioHoraExtra = salarioMensual * porcentajeAdicionalHoraExtra / 100
        return salarioMensual + (horasExtras * salarioHoraExtra)
    }
}
