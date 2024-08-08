package com.example.clevermoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.clevermoney.databinding.FragmentManualEntryBinding
import java.text.SimpleDateFormat
import java.util.*

class ManualEntryFragment : Fragment() {

    private var _binding: FragmentManualEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentManualEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDatePicker()
        setupPeriodicCheckBox()
        setupFrequencySpinner()
        setupSaveButton()
    }

    private fun setupDatePicker() {
        binding.dateEditText.setOnClickListener {
            // Implementa un DatePickerDialog qui
        }
    }

    private fun setupPeriodicCheckBox() {
        binding.periodicCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.frequencySpinner.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
    }

    private fun setupFrequencySpinner() {
        val frequencies = arrayOf("Settimanale", "Mensile", "Annuale")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, frequencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.frequencySpinner.adapter = adapter
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {
            saveExpense()
        }
    }

    private fun saveExpense() {
        val title = binding.titleEditText.text.toString()
        val amount = binding.amountEditText.text.toString().toDoubleOrNull()
        val date = binding.dateEditText.text.toString()
        val description = binding.descriptionEditText.text.toString()
        val isPeriodic = binding.periodicCheckBox.isChecked
        val frequency = if (isPeriodic) binding.frequencySpinner.selectedItem.toString() else null

        // Qui dovresti salvare la spesa nel database locale
        // Per ora, stampiamo solo i dati
        println("Spesa salvata: $title, $amount, $date, $description, isPeriodic: $isPeriodic, frequency: $frequency")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}