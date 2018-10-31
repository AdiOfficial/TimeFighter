package ws.tilda.anastasiia.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeLeftTextView: TextView
    internal var score = 0
    internal var gameStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 60000 // the length of the countdown in milliseconds
    internal val countDownInterval: Long = 1000 // the rate at which the countdown will increment in milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tap_me_button)
        gameScoreTextView = findViewById(R.id.game_score_text_view)
        gameScoreTextView.text = getString(R.string.score_text_view_name, score.toString())
        timeLeftTextView = findViewById(R.id.time_left_text_view)

        tapMeButton.setOnClickListener { view ->
            incrementScore()
        }
    }

    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.score_text_view_name, score.toString())
        val initialTimeLeft = initialCountDown/1000
        timeLeftTextView.text = getString(R.string.time_left_text_view_name, initialTimeLeft.toString())
    }

    private fun incrementScore() {
        score += 1
        val newScore = getString(R.string.score_text_view_name, score.toString())
        gameScoreTextView.text = newScore
    }


}
