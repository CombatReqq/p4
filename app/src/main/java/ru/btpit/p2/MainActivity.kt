package ru.btpit.p2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var shareCount = 11900
    var likeCount = 1200
    var isLiked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val likeCountText = findViewById<TextView>(R.id.likeCount)
        updateCountText(likeCount, likeCountText)
        val shareCountText = findViewById<TextView>(R.id.shareCount)
        updateCountText(shareCount, shareCountText)
    }



    private fun formatNumber(number: Int): String {
        return when {
            number >= 1000000 -> {
                val value = number / 1000000
                val remainder = number % 1000000
                if (remainder > 0) {
                    if (remainder >= 100000) {
                        String.format("%.1f M", value + remainder / 1000000.0)
                    } else {
                        String.format("%d.%d M", value, remainder / 100000)
                    }
                } else {
                    "$value M"
                }
            }
            number in 1000..9999 -> {
                String.format("%.1fK", number / 1000.0)
            }
            number >= 10000 -> {
                String.format("%dK", number / 1000)
            }
            else -> number.toString()
        }
    }

    fun updateCountText(count: Int, textView: TextView) {
        val text = formatNumber(count)
        textView.text = text
    }

    fun LikeBTN(view: View) {
        val likeButton = findViewById<ImageButton>(R.id.like)
        val likeCountText = findViewById<TextView>(R.id.likeCount)

        if (isLiked) {
            likeCount--
        } else {
            likeCount++
        }

        updateCountText(likeCount, likeCountText)
        likeButton.setImageResource(if (isLiked) R.drawable.like1 else R.drawable.like_red)
        isLiked = !isLiked
    }

    fun ShareCount(view: View) {
        val shareCountTextView: TextView = findViewById(R.id.shareCount)
        shareCount++
        updateCountText(shareCount, shareCountTextView)
    }
}