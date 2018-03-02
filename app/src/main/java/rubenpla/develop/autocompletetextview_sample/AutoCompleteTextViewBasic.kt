package rubenpla.develop.autocompletetextview_sample

import android.content.Context
import android.util.AttributeSet
import android.widget.AutoCompleteTextView

open class AutoCompleteTextViewBasic(context: Context, attrs: AttributeSet?) :
        AutoCompleteTextView(context, attrs) {

    override fun enoughToFilter(): Boolean { return !text.isNullOrEmpty()
    }
}