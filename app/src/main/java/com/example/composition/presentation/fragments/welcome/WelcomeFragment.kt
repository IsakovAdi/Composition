package com.example.composition.presentation.fragments.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.FragmentWelcomeBinding
import com.example.composition.presentation.fragments.chooselevel.ChooseLevelFragment

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchChooseLevelFragment() {
//        Без навигации, переход из одного фрагмента в другой осуществляется в ручную
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.main_container, ChooseLevelFragment.newInstance())
//            .addToBackStack(null)
//            .commit()

//        С использованием navHostFragment
        findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment2)
    }
}