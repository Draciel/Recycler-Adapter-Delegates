package pl.draciel.rad

import androidx.recyclerview.widget.RecyclerView

interface ComplexRecyclerDelegate<T : Any, VH : RecyclerView.ViewHolder> : RecyclerDelegate<T, VH> {

    fun test(item: T): Boolean

}
