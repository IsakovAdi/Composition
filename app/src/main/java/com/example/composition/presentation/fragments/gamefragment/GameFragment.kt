package com.example.composition.presentation.fragments.gamefragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.composition.R
import com.example.composition.databinding.FragmentGameBinding
import com.example.composition.domain.entities.GameResult
import com.example.composition.domain.entities.Level
import com.example.composition.presentation.fragments.gamefinish.GameFinishedFragment
import com.example.composition.presentation.viewmodelfactory.GameViewModelFactory

class GameFragment : Fragment() {
//    private lateinit var level:Level
    private val args by navArgs<GameFragmentArgs>()         // метод получения переданных аргументов (1)
    private val viewModelFactory by lazy {
//    val args = GameFragmentArgs.fromBundle(requireArguments())  // метод получения переданных аргументов (2)
        GameViewModelFactory(args.level, requireActivity().application
        )
    }

//    при первом обращению к этому объекту он будет проинициализирован
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }

    private val tvOptions by lazy {
        mutableListOf<TextView>().apply {
            add(binding.tvOption1)
            add(binding.tvOption2)
            add(binding.tvOption3)
            add(binding.tvOption4)
            add(binding.tvOption5)
            add(binding.tvOption6)
        }
    }


    private var _binding:FragmentGameBinding?=null

    private val binding:FragmentGameBinding
    get()=_binding?:throw RuntimeException("FragmentGameBinding == null")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setClickListenersToOptions()
    }

    private fun setClickListenersToOptions(){
        for (tvOption in tvOptions){
            tvOption.setOnClickListener{
                viewModel.chooseAnswer(tvOption.text.toString().toInt())
            }
        }
    }

    private fun observeViewModel(){
        viewModel.question.observe(viewLifecycleOwner){
            binding.apply {
                tvSum.text = it.sum.toString()
                tvLeftNum.text = it.visibleNumber.toString()
            }

            for(i in 0 until tvOptions.size){
                tvOptions[i].text = it.options[i].toString()    // в textView установим необходимый вариант ответа
            }
        }

        viewModel.percentageOfRightAnswers.observe(viewLifecycleOwner){
            binding.progressBar.setProgress(it, true)
        }
        viewModel.enoughCountOfRightAnswers.observe(viewLifecycleOwner){
            binding.tvAnswerProgress.setTextColor(getColorByState(it))
        }
        viewModel.enoughPercentOfRightAnswers.observe(viewLifecycleOwner){
         val color = getColorByState(it)
            binding.progressBar.progressTintList = ColorStateList.valueOf(color)    // устанавливаем цвет на прогресс бар
        }
        viewModel.formattedTime.observe(viewLifecycleOwner){
            binding.tvTimer.text = it
        }
        viewModel.minPercent.observe(viewLifecycleOwner){
            binding.progressBar.secondaryProgress = it
        }
        viewModel.gameResult.observe(viewLifecycleOwner){
            launchGameFinishedFragment(it)
        }
        viewModel.progressAnswers.observe(viewLifecycleOwner){
            binding.tvAnswerProgress.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getColorByState(goodState:Boolean):Int{
        val colorResId = if (goodState){
            android.R.color.holo_green_light
        }else{
            android.R.color.holo_red_light
        }
        return ContextCompat.getColor(requireContext(), colorResId)
    }
//    нужен при навигации между фрагментами в ручную
//    private fun parseArgs(){
//        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
//            level = it
//        }
//    }




    private fun launchGameFinishedFragment(gameResult: GameResult){
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
//            .addToBackStack(null)
//            .commit()

        findNavController().navigate(
            GameFragmentDirections.actionGameFragment2ToGameFinishedFragment(gameResult)
        )
    }

//    нужен при навигации между фрагментами в ручную
//    companion object{
//        const val NAME = "GameFragment"
//        const val KEY_LEVEL = "level"
//        fun newInstance(level: Level): GameFragment {
//            return GameFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(KEY_LEVEL, level)
//                }
//            }
//        }
//    }

}