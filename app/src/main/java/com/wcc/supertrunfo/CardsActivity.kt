package com.wcc.supertrunfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wcc.supertrunfo.entities.Vehicle
import com.wcc.supertrunfo.presenters.CardsPresenter
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity : AppCompatActivity() {
    private val presenter = CardsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val playerOneName = intent.getStringExtra("player_one") ?: "Player One"
        val playerTwoName = intent.getStringExtra("player_two") ?: "Player Two"

        cardPlayerOneLabel.text = "Card $playerOneName"
        cardPlayerTwoLabel.text = "Card $playerTwoName"

        cardPlayerOneVelocity.text = "Máx velocity: ${presenter.getCardOneMaxVelocity()}"
        cardPlayerTwoVelocity.text = "Máx velocity: ${presenter.getCardTwoMaxVelocity()}"

        cardPlayerOneAccelerationTime.text = "Acceleration time: ${presenter.getCardOneAccelarationTime()}"
        cardPlayerTwoAccelerationTime.text = "Acceleration time: ${presenter.getCardTwoAccelarationTime()}"

        cardPlayerOnePassengers.text = "Passengers: ${presenter.getCardOnePassengers()}"
        cardPlayerTwoPassengers.text = "Passengers: ${presenter.getCardTwoPassengers()}"

        cardPlayerOneXP.text = "XP: ${presenter.getCardOneXP()}"
        cardPlayerTwoXP.text = "XP: ${presenter.getCardTwoXP()}"

        chooseCriteriaButton.setOnClickListener {
            val intent = Intent(this, ChooseCriteriaActivity::class.java)
            intent.putExtra("player_one", playerOneName)
            intent.putExtra("player_two", playerTwoName)
            startActivity(intent)
        }
    }
}