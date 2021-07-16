package br.com.catalogodemusicas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.catalogodemusicas.databinding.MusicItemBinding
import br.com.catalogodemusicas.model.Music

class MusicAdapter(
    private val musicList: List<Music>,
    private val onClickListener: (binding: MusicItemBinding) -> Unit
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bind(musicList[position], onClickListener) }

    override fun getItemCount() = musicList.size

    class ViewHolder(
        private val binding: MusicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            music: Music,
            onClickListener: (binding: MusicItemBinding) -> Unit
        ) {
            binding.musicImage.setImageResource(music.imageId)
            binding.musicName.text = music.name
            binding.musicArtist.text = music.artist
            binding.musicDuring.text = music.during
            binding.musicAlbum.text = music.album

            binding.card.setOnClickListener { onClickListener(binding) }
        }
    }
}