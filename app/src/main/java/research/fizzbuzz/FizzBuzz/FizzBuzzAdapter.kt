package research.fizzbuzz.FizzBuzz

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import research.fizzbuzz.R
import research.fizzbuzz.databinding.FizzbuzzNumberBinding

class FizzBuzzAdapter(context: Context, values: List<Int>) : ArrayAdapter<Int>(context, 0, values ) {

    private fun inflate(view: Int) : View {
        return (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(view, null)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val number = getItem(position)
        val by3 = number % 3 == 0
        val by5 = number % 5 == 0

        return if(by3 && by5){
            inflate(R.layout.fizzbuzz_fizzbuzz)
        } else if (by3){
            inflate(R.layout.fizzbuzz_fizz)
        } else if (by5) {
            inflate(R.layout.fizzbuzz_buzz)
        } else {
            val view = inflate(R.layout.fizzbuzz_number)
            val binding = DataBindingUtil.bind<FizzbuzzNumberBinding>(view)
            binding.model = NumberData(number.toString())
            view
        }
    }
}