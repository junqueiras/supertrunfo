package com.wcc.supertrunfo

class Card (
    val vehicle: Vehicle,
    val driver: Driver,
    val player: Player
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = setMaxVelocity()
    val accelerationTime = setAccelarationTime()
    val passengers = setPassengers()

    private fun setMaxVelocity(): Int {

    }

    private fun setAccelarationTime(): Int {

    }

    private fun setPassengers(): Int {
        return vehicle.passengers * (1 + driver.defensiveDriving)
    }
}
