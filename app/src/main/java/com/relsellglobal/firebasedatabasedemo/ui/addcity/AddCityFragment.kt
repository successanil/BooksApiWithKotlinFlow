/*
 * Copyright (c) 2019. Relsell Global
 */

package com.relsellglobal.firebasedatabasedemo.ui.addcity

import android.content.Context
import com.relsellglobal.firebasedatabasedemo.viewmodels.CitiesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.firebasedatabasedemo.R
import com.relsellglobal.firebasedatabasedemo.databinding.FragmentAddCityBinding
import com.relsellglobal.firebasedatabasedemo.viewmodels.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AddCityFragment.OnListFragmentInteractionListener] interface.
 */
class AddCityFragment @Inject constructor() : DaggerFragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var recyclerView:RecyclerView? = null


    private lateinit var binding : FragmentAddCityBinding

    @Inject
    lateinit var cityViewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_city, container, false)
        //recyclerView = binding.list
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        recyclerView!!.layoutManager = GridLayoutManager(activity,2,GridLayoutManager.VERTICAL,false);
//        var model =
//            ViewModelProvider(this)[CitiesViewModel::class.java]
        var model = ViewModelProvider(requireActivity(), cityViewModelFactory).get(CitiesViewModel::class.java)




    }

    override fun onDetach() {
        super.onDetach()
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            AddCityFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
