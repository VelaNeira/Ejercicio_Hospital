//Se crea una clase llamada "CitaMedica" que se usara para gestionar las citas medicas 
class Cita(
    val paciente: Paciente,
    val medico: Medico,
    val fecha: String,
    val hora: String
)