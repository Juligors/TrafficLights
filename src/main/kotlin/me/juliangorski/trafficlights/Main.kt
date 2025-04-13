package me.juliangorski.trafficlights


fun main(args: Array<String>) {
    if (args.size != 2) {
        throw Exception("Please provide input file and output file")
    }
    val inputFilename = args[0]
    val outputFilename = args[1]

    val commands = loadCommands(inputFilename)

    for (command in commands) {
        when (command) {
            is Command.AddVehicle -> println("${command.vehicleId}, ${command.startRoad}, ${command.endRoad}")
            is Command.Step -> println(command)
        }
    }

    val stepStatuses = listOf(
        StepStatus(listOf("vehicle1", "vehicle2")),
        StepStatus(listOf()),
        StepStatus(listOf("vehicle3")),
        StepStatus(listOf("vehicle4")),
    )
    saveStepStatuses(stepStatuses, outputFilename)
}