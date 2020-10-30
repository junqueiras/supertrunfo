package com.wcc.supertrunfo

import com.wcc.supertrunfo.entities.Driver
import com.wcc.supertrunfo.entities.Player
import com.wcc.supertrunfo.entities.Vehicle

class Card (
    val vehicle: Vehicle,
    val driver: Driver,
    private val player: Player
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = initMaxVelocity()
//    val accelerationTime = initAccelarationTime()
    val passengers = initPassengers()
    val XP = initXP()

    private fun initMaxVelocity(): Int {
        return when (vehicle.type) {
            "car" -> getMaxCarVelocity() // aqui vai contas quando o tipo de veículos for carro
            "motorcycle" -> getMaxMotocycleVelocity() // aqui vai contas quando o tipo de veículos for moto
            else -> bikeMaxVelocity() // aqui vai contas quando o tipo de veículos for bike
        }
    }

    private fun getMaxCarVelocity(): Int {
        return if (vehicle.style == "sedã") {
            vehicle.maxAcceleration
        } else {
            vehicle.maxAcceleration + 10
        }
    }

    private fun getMaxMotocycleVelocity(): Int {
        return 1 / vehicle.weight * vehicle.maxAcceleration
    }

    private fun bikeMaxVelocity(): Int {
        return vehicle.maxAcceleration * driver.boldness
    }

//    private fun initAccelarationTime(): Int {
//        return vehicle.accelerationTime
//    }

    private fun initPassengers(): Int {
        return vehicle.passengers * (1 + driver.defensiveDriving)
    }

    private fun initXP(): Int {
        return when (vehicle.type) {
            "car" -> driver.carXP
            "motorcycle" -> driver.motorcycleXP
            else -> driver.bikeXP
        }
    }
}
