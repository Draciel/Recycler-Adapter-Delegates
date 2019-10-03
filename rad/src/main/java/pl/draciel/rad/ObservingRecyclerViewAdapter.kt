package pl.draciel.rad

import androidx.recyclerview.widget.RecyclerView

open class ObservingRecyclerViewAdapter<T, VH, D>(delegateManager: DelegateManager<T, VH, D>) :
    BasicRecyclerViewAdapter<T, VH, D>(delegateManager) where T : Any,
                                                              VH : RecyclerView.ViewHolder,
                                                              D : RecyclerDelegate<T, VH> {
    private val items: MutableList<T> by lazy { ArrayList<T>(20) }

    fun setItems(items: List<T>) {
        if (this.items.size > 0)
            this.items.clear()

        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<T>) {
        val pos = this.items.size
        this.items.addAll(items)
        notifyItemRangeInserted(pos, items.size)
    }

    fun addItems(pos: Int, items: List<T>) {
        this.items.addAll(pos, items)
        notifyItemRangeInserted(pos, items.size)
    }

    fun addItem(item: T) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItem(pos: Int, item: T) {
        items.add(pos, item)
        notifyItemInserted(pos)
    }

    fun removeItem(pos: Int) {
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun removeItem(item: T) {
        val pos = this.items.indexOf(item)
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun clear() {
        items.clear()
        notifyItemRangeRemoved(0, items.size)
    }

    fun setItem(pos: Int, item: T) {
        items[pos] = item
        notifyItemChanged(pos)
    }

    fun moveItem(from: Int, to: Int) {
        val item = items.removeAt(from)
        items.add(to, item)
        notifyItemMoved(from, to)
    }

    fun items(): List<T> = items

    override fun getItem(position: Int): T = items[position]

    override fun getItemCount(): Int = items.size

}
