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
        timeLeftTextView = findViewById(R.id.time_left_text_view)
        resetGame()

        tapMeButton.setOnClickListener { view ->
            incrementScore()
        }
    }

    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.score_text_view_name, score.toString())
        val initialTimeLeft = initialCountDown / 1000
        timeLeftTextView.text = getString(R.string.time_left_text_view_name, initialTimeLeft.toString())

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timeLeftTextView.text = getString(R.string.time_left_text_view_name, timeLeft.toString())
            }

            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        gameStarted = false
    }

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        score += 1
        val newScore = getString(R.string.score_text_view_name, score.toString())
        gameScoreTextView.text = newScore
    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }
}
