package pl.draciel.rad

import androidx.recyclerview.widget.RecyclerView

class SingleTypeDelegateManager<T : Any, VH : RecyclerView.ViewHolder, D : RecyclerDelegate<T, VH>>(
    recyclerDelegate: RecyclerDelegate<out T, out VH>
) : DelegateManager<T, VH, D> {

    @Suppress("UNCHECKED_CAST")
    private val recyclerDelegate: D = recyclerDelegate as D

    override fun delegateByItem(item: T): D {
        return recyclerDelegate
    }

    override fun delegateByViewType(viewType: Int): D {
        return recyclerDelegate
    }

    override fun getViewType(item: T): Int {
        return 0
    }
}
