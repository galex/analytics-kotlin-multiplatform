package com.analytics.analyticsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.analytics.core.helper.EventsHelper
import com.analytics.core.model.Screen

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onResume() {
        super.onResume()
        EventsHelper.enterScreen(Screen.DASHBOARD)
    }

    override fun onPause() {
        super.onPause()
        EventsHelper.exitScreen(Screen.DASHBOARD)
    }
}
