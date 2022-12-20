package ru.anb.friends.main.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ru.anb.friends.main.repository.NetworkRepositoryImpl
import ru.anb.friends.main.state.GroupsState

class MainViewModel : ViewModel() {
    val _data = MutableLiveData<GroupsState>()
    val networkReposutory: NetworkRepositoryImpl = NetworkRepositoryImpl()
    fun getGroups(){

        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(GroupsState.Loading())
            networkReposutory.getGroups().collect{
                _data.postValue(it)
            }
        }
    }

}