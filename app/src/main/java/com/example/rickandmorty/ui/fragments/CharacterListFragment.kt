package com.example.rickandmorty.ui.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rickandmorty.data.repository.CharacterListRepositoryImpl
import com.example.rickandmorty.databinding.FragmentCharacterListBinding
import com.example.rickandmorty.domain.state.DataState
import com.example.rickandmorty.ui.adapters.ItemListAdaptor
import com.example.rickandmorty.ui.viewmodels.CharacterListViewModel

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val adapter = ItemListAdaptor()
    private val viewModel : CharacterListViewModel by viewModels{
        CharacterListViewModel.Factory(
            CharacterListRepositoryImpl()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCharacters.adapter = adapter


        viewModel.characters.observe(viewLifecycleOwner) { state -> when(state){
            is DataState.Loading -> {
                Toast.makeText(context, "Загрузка", Toast.LENGTH_SHORT).show()
            }
            is DataState.Error -> {
                Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            }
            is DataState.Loaded -> {
                adapter.submitList(state.data)
            }
        } }



    }


}