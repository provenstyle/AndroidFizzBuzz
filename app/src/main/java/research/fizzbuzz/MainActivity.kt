package research.fizzbuzz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import research.fizzbuzz.FizzBuzz.FizzBuzzAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        findViewById<GridView>(R.id.fizz_buzz_grid).also {
            it.adapter = FizzBuzzAdapter(this, (1..30).toList())
        }
    }
}

