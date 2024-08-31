//Se crea la Subclase del paciente de la clase base "Persona" 
class Paciente(
    val historiaClinica: String,
    val sexo: String,
    val grupoSanguineo: String,
    val alergias: List<String>,
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudad: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudad)