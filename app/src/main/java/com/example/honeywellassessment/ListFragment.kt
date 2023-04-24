package com.example.honeywellassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.honeywellassessment.adapter.RecyclerListAdapter
import com.example.honeywellassessment.databinding.FragmentListBinding
import com.example.honeywellassessment.model.Item
import com.example.honeywellassessment.viewmodel.ListViewModel


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel: ListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerListAdapter(viewModel.getDummyData())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}