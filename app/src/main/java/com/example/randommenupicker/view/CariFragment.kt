package com.example.randommenupicker.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randommenupicker.R
import com.example.randommenupicker.databinding.FragmentCariBinding
import com.example.randommenupicker.databinding.FragmentMenuBinding
import com.example.randommenupicker.model.Menu
import com.example.randommenupicker.model.MenuAttribute
import com.example.randommenupicker.model.Page
import com.example.randommenupicker.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_cari.*
import kotlinx.android.synthetic.main.fragment_cari.view.*

class CariFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding : FragmentCariBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCariBinding.inflate(inflater, container, false);

        var adapter = ArrayAdapter.createFromResource(requireActivity(), R.array.spinner_kategori, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerKategori.adapter = adapter
        binding.spinnerKategori.onItemSelectedListener = this
        binding.btnCari.setOnClickListener {
            var atr : MenuAttribute
            when(binding.spinnerKategori.selectedItemPosition) {
                0 -> atr = MenuAttribute.NAMA
                1 -> atr = MenuAttribute.DESKRIPSI
                2 -> atr = MenuAttribute.TAG
                3 -> atr = MenuAttribute.BAHAN
                else -> atr = MenuAttribute.RESTO
            }
            viewModel.searchMenu(binding.etKeyword.text.toString(), atr)
            viewModel.setPage(Page.LIST_MENU)
        }
        return binding.root
    }


    companion object {
        fun newInstance() : CariFragment{
            var fragment : CariFragment = CariFragment()
            return fragment
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var text = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}