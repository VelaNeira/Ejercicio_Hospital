//Se crea una subclase "Medico" derivada de la subclase "Empleado" 
class Medico(
    val especialidad: String,
    val servicio: String,
    val numConsultorio: String,
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
) : Empleado(codigoEmpleado, horasExtras, fechaIngreso, area, cargo, dni, nombre, apellido, fechaNacimiento, direccion, ciudad)
