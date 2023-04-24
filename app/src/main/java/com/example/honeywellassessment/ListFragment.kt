package com.example.honeywellassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.honeywellassessment.adapter.RecyclerListAdapter
import com.example.honeywellassessment.databinding.FragmentListBinding
import com.example.honeywellassessment.model.Item


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

        val recyclerview = binding.rvList
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this.requireContext())

        val data = ArrayList<Item>()
        for (i in 1..20) {
            data.add(
                Item(
                    image = R.drawable.ic_launcher_background,
                    name = "Item " + i,
                    color = "black"
                )
            )
        }

        recyclerview.adapter = RecyclerListAdapter(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}