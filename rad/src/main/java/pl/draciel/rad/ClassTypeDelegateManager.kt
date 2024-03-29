package pl.draciel.rad

import android.util.ArrayMap
import androidx.recyclerview.widget.RecyclerView

class ClassTypeDelegateManager<T : Any, VH : RecyclerView.ViewHolder, D : RecyclerDelegate<T, VH>> private constructor(
    private val arrayMap: ArrayMap<Class<out T>, D>
) : DelegateManager<T, VH, D> {

    override fun delegateByItem(item: T): D {
        return arrayMap[item::class.java]
            ?: throw IllegalStateException("Delegate not registered for the item type ${item::class.java}")
    }

    override fun delegateByViewType(viewType: Int): D {
        return arrayMap.valueAt(viewType)
            ?: throw IllegalStateException("Delegate not registered for the view type $viewType")
    }

    override fun getViewType(item: T): Int {
        return arrayMap.indexOfKey(item::class.java)
    }

    class Builder<T : Any, VH : RecyclerView.ViewHolder, D : RecyclerDelegate<T, VH>>(size: Int? = null) {
        private val map: ArrayMap<Class<out T>, D> = if (size == null) ArrayMap() else ArrayMap(size)
        private var isBuilt = false

        @Suppress("UNCHECKED_CAST")
        fun register(type: Class<out T>, delegate: RecyclerDelegate<out T, out VH>): Builder<T, VH, D> {
            if (!isBuilt) {
                map[type] = delegate as D
            }
            return this
        }

        fun build(): ClassTypeDelegateManager<T, VH, D> {
            isBuilt = true
            return ClassTypeDelegateManager(map)
        }
    }
}
