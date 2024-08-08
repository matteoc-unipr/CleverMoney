package com.example.clevermoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clevermoney.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        updateTotalExpenses()
    }

    private fun setupRecyclerView() {
        binding.expensesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        // Qui dovresti impostare l'adapter con i dati delle spese dal database
    }

    private fun updateTotalExpenses() {
        // Qui dovresti calcolare il totale delle spese dal database
        val totalExpenses = 0.00 // Placeholder
        binding.totalExpensesTextView.text = "Spese totali: €%.2f".format(totalExpenses)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}