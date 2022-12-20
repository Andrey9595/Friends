package ru.anb.friends.main.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.anb.friends.R
import ru.anb.friends.main.viewmodel.MainViewModel
import ru.anb.friends.main.adapter.FriendsAdapter
import ru.anb.friends.main.bottomsheet.BottomSheet
import ru.anb.friends.main.dto.Group
import ru.anb.friends.main.state.GroupsState
import kotlin.properties.Delegates

class MainFragment : Fragment() {
    private var numberOfColumns by Delegates.notNull<Int>()

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById((R.id.fragmentRecyclerView))
        recyclerView.layoutManager = LinearLayoutManager(context)
        val openBottomSheetCallback: () -> Unit = { ->
            val bottomSheet: BottomSheet = BottomSheet()
            bottomSheet.show(parentFragmentManager, "String")
        }
        recyclerView.adapter = FriendsAdapter(
            listOf<Group>(

            ), openBottomSheetCallback
        )


        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            numberOfColumns = 3
        } else {
            numberOfColumns = 4
        }
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)

        viewModel.getGroups()
        viewModel._data.observe(viewLifecycleOwner){
            when(it){
                is GroupsState.Empty -> TODO()
                is GroupsState.Error -> TODO()
                is GroupsState.Loading -> Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                is GroupsState.Success -> Log.e(javaClass.name, it.listGroup.toString())
            }
        }
    }
}