import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommandList(
    val commands: List<Command>
)

@Serializable
sealed class Command

@Serializable
@SerialName("addVehicle")
data class AddVehicle(
    val vehicleId: String,
    val startRoad: String,
    val endRoad: String
) : Command()

@Serializable
@SerialName("step")
data object Step : Command()
