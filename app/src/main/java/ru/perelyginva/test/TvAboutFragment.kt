package ru.perelyginva.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.perelyginva.test.databinding.FragmentTvAboutBinding
import ru.perelyginva.test.di.AppModule
import ru.perelyginva.test.models.TvShowItem
import ru.perelyginva.test.viewmodel.TvShowViewModel

@AndroidEntryPoint
class TvAboutFragment : Fragment() {

    private var _binding: FragmentTvAboutBinding? = null
    private val binding: FragmentTvAboutBinding
        get() = _binding ?: throw RuntimeException("TvAboutFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentTvAboutBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}