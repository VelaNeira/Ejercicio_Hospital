// Variables
val empleados = mutableListOf<Empleado>()
val pacientes = mutableListOf<Paciente>()
val medicos = mutableListOf<Medico>()
val citas = mutableListOf<Cita>()

fun main() {
    while (true) {
        // Presentación del menú
        println("************************************************")
        println("           Bienvenido al sistema de gestión")
        println("************************************************")
        println("Seleccione una opción del menú:")
        println("1. Registrar empleado")
        println("2. Registrar paciente")
        println("3. Registrar médico")
        println("4. Registrar cita")
        println("5. Listar médicos por especialidad")
        println("6. Listar pacientes atendidos por médico")
        println("7. Calcular salario de empleado")
        println("0. Salir")
        println("************************************************")

        // Lectura de la opción del usuario
        print("Ingrese su opción: ")
        when (readLine()?.trim()) {
            "1" -> registrarEmpleado()
            "2" -> registrarPaciente()
            "3" -> registrarMedico()
            "4" -> registrarCita()
            "5" -> listarMedicosPorEspecialidad()
            "6" -> listarPacientesPorMedico()
            "7" -> calcularSalarioEmpleado()
            "0" -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción no válida, por favor intente nuevamente.")
        }
    }
}

// Función para registrar un empleado
fun registrarEmpleado() {
    println("Ingrese código de empleado:")
    val codigoEmpleado = readLine()!!
    println("Ingrese horas extras:")
    val horasExtras = readLine()!!.toInt()
    println("Ingrese fecha de ingreso (dd/MM/yyyy):")
    val fechaIngreso = readLine()!!
    println("Ingrese área:")
    val area = readLine()!!
    println("Ingrese cargo:")
    val cargo = readLine()!!
    println("Ingrese DNI:")
    val dni = readLine()!!
    println("Ingrese nombre:")
    val nombre = readLine()!!
    println("Ingrese apellido:")
    val apellido = readLine()!!
    println("Ingrese fecha de nacimiento (dd/MM/yyyy):")
    val fechaNacimiento = readLine()!!
    println("Ingrese dirección:")
    val direccion = readLine()!!
    println("Ingrese ciudad:")
    val ciudad = readLine()!!

    println("¿Es empleado por planilla o eventual? (P/E):")
    val tipoEmpleado = readLine()!!

    when (tipoEmpleado.uppercase()) {
        "P" -> {
            println("Ingrese salario mensual:")
            val salarioMensual = readLine()!!.toDouble()
            println("Ingrese porcentaje adicional por hora extra:")
            val porcentajeAdicionalHoraExtra = readLine()!!.toDouble()
            empleados.add(EmpleadoPlanilla(salarioMensual, porcentajeAdicionalHoraExtra, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, dni, nombre, apellido, fechaNacimiento, direccion, ciudad))
        }
        "E" -> {
            println("Ingrese honorarios por hora:")
            val honorariosPorHora = readLine()!!.toDouble()
            println("Ingrese horas totales trabajadas:")
            val horasTotales = readLine()!!.toInt()
            println("Ingrese fecha de término del contrato (dd/MM/yyyy):")
            val fechaTerminoContrato = readLine()!!
            empleados.add(EmpleadoEventual(honorariosPorHora, horasTotales, fechaTerminoContrato, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, dni, nombre, apellido, fechaNacimiento, direccion, ciudad))
        }
        else -> println("Tipo de empleado no válido.")
    }
}

// Función para registrar un paciente
fun registrarPaciente() {
    println("Ingrese número de historia clínica:")
    val historiaClinica = readLine()!!
    println("Ingrese sexo:")
    val sexo = readLine()!!
    println("Ingrese grupo sanguíneo:")
    val grupoSanguineo = readLine()!!
    println("Ingrese alergias (separadas por comas):")
    val alergias = readLine()!!.split(",").map { it.trim() }
    println("Ingrese DNI:")
    val dni = readLine()!!
    println("Ingrese nombre:")
    val nombre = readLine()!!
    println("Ingrese apellido:")
    val apellido = readLine()!!
    println("Ingrese fecha de nacimiento (dd/MM/yyyy):")
    val fechaNacimiento = readLine()!!
    println("Ingrese dirección:")
    val direccion = readLine()!!
    println("Ingrese ciudad:")
    val ciudad = readLine()!!

    pacientes.add(Paciente(historiaClinica, sexo, grupoSanguineo, alergias, dni, nombre, apellido, fechaNacimiento, direccion, ciudad))
}

// Función para registrar un médico
fun registrarMedico() {
    println("Ingrese especialidad:")
    val especialidad = readLine()!!
    println("Ingrese servicio:")
    val servicio = readLine()!!
    println("Ingrese número de consultorio:")
    val numConsultorio = readLine()!!
    println("Ingrese código de empleado:")
    val codigoEmpleado = readLine()!!
    println("Ingrese horas extras:")
    val horasExtras = readLine()!!.toInt()
    println("Ingrese fecha de ingreso (dd/MM/yyyy):")
    val fechaIngreso = readLine()!!
    println("Ingrese área:")
    val area = readLine()!!
    println("Ingrese cargo:")
    val cargo = readLine()!!
    println("Ingrese DNI:")
    val dni = readLine()!!
    println("Ingrese nombre:")
    val nombre = readLine()!!
    println("Ingrese apellido:")
    val apellido = readLine()!!
    println("Ingrese fecha de nacimiento (dd/MM/yyyy):")
    val fechaNacimiento = readLine()!!
    println("Ingrese dirección:")
    val direccion = readLine()!!
    println("Ingrese ciudad:")
    val ciudad = readLine()!!

    medicos.add(Medico(especialidad, servicio, numConsultorio, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, dni, nombre, apellido, fechaNacimiento, direccion, ciudad))
}

// Función para registrar una cita
fun registrarCita() {
    println("Ingrese DNI del paciente:")
    val pacienteDni = readLine()!!
    val paciente = pacientes.find { it.dni == pacienteDni } ?: run {
        println("Paciente no encontrado.")
        return
    }

    println("Ingrese código del médico:")
    val medicoCodigo = readLine()!!
    val medico = medicos.find { it.codigoEmpleado == medicoCodigo } ?: run {
        println("Médico no encontrado.")
        return
    }

    println("Ingrese fecha de la cita (dd/MM/yyyy):")
    val fecha = readLine()!!
    println("Ingrese hora de la cita (HH:mm):")
    val hora = readLine()!!

    citas.add(Cita(paciente, medico, fecha, hora))
}

// Función para listar médicos por especialidad
fun listarMedicosPorEspecialidad() {
    println("Ingrese especialidad para listar médicos:")
    val especialidad = readLine()!!
    val medicosEspecialidad = medicos.filter { it.especialidad.equals(especialidad, ignoreCase = true) }

    if (medicosEspecialidad.isEmpty()) {
        println("No se encontraron médicos con la especialidad '$especialidad'.")
    } else {
        println("Médicos con especialidad '$especialidad':")
        medicosEspecialidad.forEach { medico ->
            println("Nombre: ${medico.nombre} ${medico.apellido}, Consultorio: ${medico.numConsultorio}")
        }
    }
}

// Función para listar pacientes atendidos por un médico
fun listarPacientesPorMedico() {
    println("Ingrese código del médico:")
    val medicoCodigo = readLine()!!
    val pacientesAtendidos = citas.filter { it.medico.codigoEmpleado == medicoCodigo }.map { it.paciente }

    if (pacientesAtendidos.isEmpty()) {
        println("No se encontraron pacientes atendidos por el médico con código '$medicoCodigo'.")
    } else {
        println("Pacientes atendidos por el médico con código '$medicoCodigo':")
        pacientesAtendidos.forEach { paciente ->
            println("Nombre: ${paciente.nombre} ${paciente.apellido}")
        }
    }
}

fun calcularSalarioEmpleado() {
    println("Ingrese código del empleado:")
    val codigoEmpleado = readLine()!!
    val empleado = empleados.find { it.codigoEmpleado == codigoEmpleado }

    if (empleado != null) {
        val salario = empleado.calcularSalario()
        println("El salario total del empleado con código '$codigoEmpleado' es: $salario")
    } else {
        println("Empleado no encontrado.")
    }
}

