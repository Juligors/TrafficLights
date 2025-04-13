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
            is AddVehicle -> println(command)
            is Step -> println(command)
        }
    }
}