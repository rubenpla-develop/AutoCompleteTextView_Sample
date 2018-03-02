package rubenpla.develop.autocompletetextview_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        autocomplete_original.onItemClickListener = this
        autocomplete_textview_extended.onItemClickListener = this
    }

    private fun setAdapter() {
        autocomplete_original.setAdapter(AutoCompleteAdapter(this))
        autocomplete_textview_extended.setAdapter(AutoCompleteAdapter(this))
        autocomplete_original.threshold = THRESHOLD
        autocomplete_textview_extended.threshold = THRESHOLD
        autocomplete_textview_extended.setLoadingIndicator(pb_loading_indicator)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "item : " +
                autocomplete_original.adapter.getItem(position), Toast.LENGTH_LONG).show()
    }

    companion object {
        const val THRESHOLD = 1
    }
}
