package rubenpla.develop.autocompletetextview_sample

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar

class AutoCompleteTextViewExtended(context: Context, attrs: AttributeSet?)
    : AutoCompleteTextViewBasic(context, attrs) {

    private var autoCompleteDelay = DEFAULT_AUTOCOMPLETE_DELAY
    private var loadingIndicator: ProgressBar? = null

    private val autoCompleteHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            super@AutoCompleteTextViewExtended.performFiltering(msg.obj as CharSequence, msg.arg1)
        }
    }

    fun setLoadingIndicator(progressBar: ProgressBar) {
        loadingIndicator = progressBar
    }

    fun setAutoCompleteDelay(delay : Int) {
        autoCompleteDelay = delay
    }

    override fun performFiltering(text: CharSequence?, keyCode: Int) {
        if (loadingIndicator != null) {
            loadingIndicator!!.visibility = View.VISIBLE
        }

        autoCompleteHandler.removeMessages(MESSAGE_TEXT_CHANGED)
        autoCompleteHandler.sendMessageDelayed(handler.obtainMessage(MESSAGE_TEXT_CHANGED, text),
                autoCompleteDelay.toLong())
    }

    override fun onFilterComplete(count: Int) {
        if (loadingIndicator != null) {
            loadingIndicator!!.visibility = View.GONE
        }

        super.onFilterComplete(count)
    }

    companion object {
        const val MESSAGE_TEXT_CHANGED = 100
        const val DEFAULT_AUTOCOMPLETE_DELAY = 750
    }
}

