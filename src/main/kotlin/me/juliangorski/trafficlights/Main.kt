package me.juliangorski.trafficlights

import kotlinx.serialization.json.Json
import java.io.File

fun main(args: Array<String>) {
    if (args.size != 2) {
        throw Exception("Please provide input file and output file")
    }
    val inputFilename = args[0]
    val outputFilename = args[1]

    val json = Json {
        classDiscriminator = "type"
    }

    val jsonString = File(inputFilename).readText()
    val commandList = json.decodeFromString<CommandList>(jsonString)

    for (command in commandList.commands) {
        when (command) {
            is AddVehicle -> println(command)
            is Step -> println(command)
        }
    }
}