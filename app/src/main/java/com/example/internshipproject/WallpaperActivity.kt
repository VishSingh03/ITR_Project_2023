package com.example.internshipproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WallpaperActivity : AppCompatActivity() {
    private val imageUrls = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/f/fe/EIk22BhUYAEF_k3.jpg",
        // "https://example.com/image2.jpg",
        // Add more image URLs here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ImageAdapter(imageUrls)
        recyclerView.adapter = adapter
    }

    inner class ImageAdapter(private val imageUrls: List<String>) :
        RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = layoutInflater.inflate(R.layout.item_wallpaper, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageUrl = imageUrls[position]
            val imageView = holder.itemView.findViewById<ImageView>(R.id.imageButton)

            // Load the image from the URL using a library like Picasso or Glide
            // For this example, we'll use placeholder images
            imageView.setImageResource(R.drawable.dice_1)

            // Set a click listener to share the image
            imageView.setOnClickListener {
                shareImage(imageUrl)
            }
        }

        override fun getItemCount(): Int {
            return imageUrls.size
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        private fun shareImage(imageUrl: String) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, imageUrl)
            startActivity(Intent.createChooser(intent, "Share Image"))
        }
    }




}

