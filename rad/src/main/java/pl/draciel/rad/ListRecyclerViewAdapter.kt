package pl.draciel.rad

import androidx.recyclerview.widget.RecyclerView

open class ListRecyclerViewAdapter<T, VH, D>(delegateManager: DelegateManager<T, VH, D>) :
    BasicRecyclerViewAdapter<T, VH, D>(delegateManager) where T : Any,
                                                              VH : RecyclerView.ViewHolder,
                                                              D : RecyclerDelegate<T, VH> {

    private var items: List<T> = emptyList()

    fun setItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): T = items[position]

    override fun getItemCount(): Int = items.size

}
