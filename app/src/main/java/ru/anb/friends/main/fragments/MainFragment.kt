package ru.anb.friends.main.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.anb.friends.R
import ru.anb.friends.main.viewmodel.MainViewModel
import ru.anb.friends.main.adapter.FriendsAdapter
import ru.anb.friends.main.dto.Group
import kotlin.properties.Delegates

class MainFragment : Fragment() {
    private var numberOfColums by Delegates.notNull<Int>()

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
        recyclerView.adapter = FriendsAdapter(
            listOf<Group>(
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1), Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
                Group(name = "Name", id = 0),
                Group(name = "Name2", id = 1),
            )
        )
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            numberOfColums = 3
        } else {
            numberOfColums = 4
        }
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColums)
    }
}