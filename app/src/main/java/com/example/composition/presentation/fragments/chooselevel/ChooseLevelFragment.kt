package com.example.composition.presentation.fragments.chooselevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.FragmentChooseLevelBinding
import com.example.composition.domain.entities.Level
import com.example.composition.presentation.fragments.gamefragment.GameFragment


class ChooseLevelFragment : Fragment() {

    private var _binding : FragmentChooseLevelBinding?=null
    private val binding: FragmentChooseLevelBinding
    get() = _binding?:throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnTestLevel.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            btnEasyLevel.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            btnNormalLevel.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            btnHardLevel.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level){
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.main_container, GameFragment.newInstance(level))
//            .addToBackStack(GameFragment.NAME)
//            .commit()

        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragment2ToGameFragment2(level)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    нужен при навигации между фрагментами в ручную
//    companion object{
//        const val NAME = "ChooseLevelFragment"
//        fun newInstance(): ChooseLevelFragment {
//            return ChooseLevelFragment()
//        }
//    }
}