package me.juliangorski.trafficlights


import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@OptIn(ExperimentalSerializationApi::class)
private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
}

fun saveStepStatuses(stepStatuses: List<StepStatus>, filename: String) {
    @Serializable
    @SerialName("stepStatuses")
    data class StepStatusList(
        val stepStatuses: List<StepStatus>
    )

    val outputJson = json.encodeToString(StepStatusList(stepStatuses))
    File(filename).writeText(outputJson)
}

@Serializable
@SerialName("leftVehicles")
data class StepStatus(val leftVehicles: List<String>)
