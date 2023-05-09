package com.example.honeywellassessment.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.honeywellassessment.adapter.RecyclerListAdapter
import com.example.honeywellassessment.databinding.FragmentListBinding
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
        setupRecyclerView()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setupRecyclerView(){
        ViewModelProvider(this).get(ListViewModel::class.java).let {viewModel ->
            binding.rvList.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerListAdapter(viewModel.items.value!!)
            }

            binding.btnAdd.setOnClickListener {
                viewModel.addItem()
            }

            viewModel.items.observe(this.viewLifecycleOwner, Observer {
                binding.rvList.adapter?.notifyItemInserted(viewModel.items.value?.size!!)
            })

            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    viewModel.items.value?.removeAt(viewHolder.absoluteAdapterPosition)
                    binding.rvList.adapter?.notifyItemRemoved(viewHolder.absoluteAdapterPosition)
                }
            }).attachToRecyclerView(binding.rvList)

        }


    }
}