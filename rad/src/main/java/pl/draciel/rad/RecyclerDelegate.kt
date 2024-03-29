package pl.draciel.rad

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface RecyclerDelegate<T : Any, VH : RecyclerView.ViewHolder> {

    fun createViewHolder(parent: ViewGroup): VH

    fun bindViewHolder(viewHolder: VH, item: T)

}
