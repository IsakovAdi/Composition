package com.example.composition.presentation.fragments.gamefinish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.composition.R
import com.example.composition.databinding.FragmentGameFinishedBinding

import com.example.composition.domain.entities.GameResult
import com.example.composition.presentation.fragments.gamefragment.GameFragment


class GameFinishedFragment : Fragment() {

//    private lateinit var gameResult: GameResult

    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    //    нужен при навигации между фрагментами в ручную
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        parseArguments()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        bindViews()

    }

    private fun bindViews() {
        binding.gameResult = args.gameReslut
//        with(binding) {
//            emojiResult.setImageResource(getSmileResId())
////            tvRequiredAnswers.text = String.format(
////                getString(R.string.required_score),
////                args.gameReslut.gameSettings.minCountOfRightAnswers
////            )
////            tvScoreAnswers.text = String.format(
////                getString(R.string.score_answer),
////                args.gameReslut.countOfRightAnswers
////            )
////            requiredPercentage.text = String.format(
////                getString(R.string.required_percentage),
////                args.gameReslut.gameSettings.minPercentOfRightAnswers
////            )
////            scorePercentage.text = String.format(
////                getString(R.string.score_percentage),
////                getPercentOfRightAnswers()
////            )
//        }
    }

    private fun setupClickListeners() {
//        Слушатель кнопки назад
//        val callback = object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                retryGame()
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

//    private fun getSmileResId(): Int {
//        return if (args.gameReslut.winner) {
//            R.drawable.ic_smile
//        } else {
//            R.drawable.ic_cry
//        }
//    }
//
//    private fun getPercentOfRightAnswers() = with(args.gameReslut) {
//        if (countOfQuestions == 0) {
//            0
//        } else {
//            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
//        }
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    нужен при навигации между фрагментами в ручную
//    private fun parseArguments() {
//        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
//            gameResult = it
//        }
//    }

    private fun retryGame() {
//        requireActivity().supportFragmentManager.popBackStack(
//            GameFragment.NAME,
//            FragmentManager.POP_BACK_STACK_INCLUSIVE
//        )

        findNavController().popBackStack()

    }

//    нужен при навигации между фрагментами в ручную
//    companion object {
//        const val KEY_GAME_RESULT = "game_result"
//        fun newInstance(gameResult: GameResult): GameFinishedFragment {
//            return GameFinishedFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(KEY_GAME_RESULT, gameResult)
//                }
//            }
//        }
//    }
}