package com.ksnk.auto

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> {
                return CalcCarFragment.newInstance(position)
            }
            1->{
                return CalcElectroFragment.newInstance(position)
            }

        }
        return CalcCarFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    companion object {
        private const val ITEM_COUNT = 2
    }
}