/*
 * Copyright (c) 2019. Relsell Global
 */

package com.relsellglobal.firebasedatabasedemo

import android.content.Context
import com.relsellglobal.firebasedatabasedemo.databinding.FragmentItemListBinding
import com.relsellglobal.firebasedatabasedemo.viewmodels.CitiesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.firebasedatabasedemo.utils.Utils
import com.relsellglobal.firebasedatabasedemo.viewmodels.ViewModelFactory
import com.relsellglobal.modelslib.CityContent
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [FrontListFragment.OnListFragmentInteractionListener] interface.
 */
class FrontListFragment @Inject constructor() : DaggerFragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var recyclerView:RecyclerView? = null
    private var myItemRecyclerViewAdapter : MyItemRecyclerViewAdapter? = null

    private lateinit var binding : FragmentItemListBinding

    @Inject
    lateinit var cityViewModelFactory: ViewModelFactory

    var mCityContentList = ArrayList<CityContent>()


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

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_list, container, false)
        recyclerView = binding.list
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView!!.layoutManager = GridLayoutManager(activity,2,GridLayoutManager.VERTICAL,false);

        recyclerView?.addItemDecoration(SpacesItemDecoration(16));

        myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(mCityContentList,activity)
        recyclerView!!.adapter = myItemRecyclerViewAdapter

        var model = ViewModelProvider(requireActivity(), cityViewModelFactory).get(CitiesViewModel::class.java)

//        model.
//        getAllCitiesForLocalDB().observe(viewLifecycleOwner,{ listOfCitiesForUser ->
//            var cityContentList = Utils.mappingCitiesForUserToCityContent(listOfCitiesForUser)
//
//            for(cityContent in cityContentList) {
//                if(!mCityContentList.contains(cityContent)) {
//                    mCityContentList.add(cityContent)
//                }
//            }
//
//            myItemRecyclerViewAdapter?.notifyDataSetChanged()
//
//
//        })
//
//
//
//        CoroutineScope(Dispatchers.IO).launch {
//            model.insertDataIntoCitiesForUser()
//        }



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
            FrontListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}

fun fetchCitiesfromNetwork() {
    //        CoroutineScope(Dispatchers.Main).launch{
//            model.getCitiesList().observe(viewLifecycleOwner, androidx.lifecycle.Observer { cityContentNetworkList ->
//                var cityContentList = Utils.mappingCityContentNetworkToCityContent(cityContentNetworkList)
//
//                myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(cityContentList,activity)
//                recyclerView!!.adapter = myItemRecyclerViewAdapter
//
//            })
//        }
}
