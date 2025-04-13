package me.juliangorski.trafficlights

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
sealed class Command

@Serializable
@SerialName("addVehicle")
data class AddVehicle(val vehicleId: String, val startRoad: String, val endRoad: String) : Command()

@Serializable
@SerialName("step")
data object Step : Command()

fun loadCommands(filename: String): List<Command> {
    // NOTE: we need this class because of input json format
    @Serializable
    data class CommandList(
        val commands: List<Command>
    )

    val jsonString = File(filename).readText()
    val commandList = Json.decodeFromString<CommandList>(jsonString)

    return commandList.commands
}
