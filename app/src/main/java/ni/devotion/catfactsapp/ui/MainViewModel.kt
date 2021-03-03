package ni.devotion.catfactsapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ni.devotion.catfactsapp.repository.CatRepository
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainViewModel @HiltViewModel constructor(
    private val catRepository: CatRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
}