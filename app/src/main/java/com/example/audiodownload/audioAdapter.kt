package com.example.audiodownload

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView

class audioAdapter(var context: Context, var audiolist:List<audioData>):RecyclerView.Adapter<audioAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var textname: TextView = view.findViewById(R.id.txtname)
        var btnDownload: Button= view.findViewById(R.id.btndownload)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.audio,parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return audiolist.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textname.text = audiolist[position].name

        holder.btnDownload.setOnClickListener {
            val url = audiolist[position].url // URL of the audio file you want to download
            val request = DownloadManager.Request(Uri.parse(url))
                .setTitle(audiolist[position].name) // Set the title of the download notification
                .setDescription("Downloading") // Set the description of the download notification
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED) // Show notification when download is complete
                .setAllowedOverMetered(true) // Allow downloading over a metered network (e.g., mobile data)
                .setAllowedOverRoaming(true) // Allow downloading over a roaming network

            val downloadManager = context.getSystemService(AppCompatActivity.DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)
        }



    }
}