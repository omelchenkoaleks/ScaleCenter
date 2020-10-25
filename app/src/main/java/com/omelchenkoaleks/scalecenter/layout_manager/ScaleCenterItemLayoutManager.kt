package com.omelchenkoaleks.scalecenter.layout_manager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScaleCenterItemLayoutManager(
    context: Context,
    orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
        lp!!.width = width // проблема - так лучше не делать (!!)
        return true
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        scaleMiddleItem()
    }

    private fun scaleMiddleItem() {
        val mid = width / 2.0f
        val d1 = 0.9f * mid
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childMid = (getDecoratedRight(child!!) + getDecoratedLeft(child)) / 2.0f
            val d = Math.min(d1, Math.abs(mid - childMid))
            val scale = 1f - 0.15f * d / d1
            child.scaleX = scale
            child.scaleY = scale
        }
    }


    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        return if (orientation == RecyclerView.HORIZONTAL) {
            scaleMiddleItem()
            scrolled
        } else 0
    }
}