package ua.tryvoha.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var root: LinearLayout
    private lateinit var title: TextView
    private lateinit var info: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }

        title = TextView(this).apply {
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        info = TextView(this).apply {
            textSize = 20f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 30, 0, 30)
        }

        root.addView(title)
        root.addView(info)

        addButton("🟢 Зелений — відбій", "green")
        addButton("🟡 Жовтий — увага", "yellow")
        addButton("🔴 Червоний — тривога", "red")

        setContentView(root)
        setStatus("yellow")
    }

    private fun addButton(label: String, status: String) {
        val button = Button(this)
        button.text = label
        button.setOnClickListener { setStatus(status) }
        root.addView(button)
    }

    private fun setStatus(status: String) {
        when (status) {
            "green" -> {
                root.setBackgroundColor(Color.rgb(35, 125, 75))
                title.text = "ВІДБІЙ"
                info.text = "🟢 Зелений рівень"
            }
            "yellow" -> {
                root.setBackgroundColor(Color.rgb(205, 155, 0))
                title.text = "РІВЕНЬ УВАГИ"
                info.text = "🟡 Жовтий рівень"
            }
            else -> {
                root.setBackgroundColor(Color.rgb(180, 35, 45))
                title.text = "ПОВІТРЯНА ТРИВОГА"
                info.text = "🔴 Червоний рівень"
            }
        }
    }
}
