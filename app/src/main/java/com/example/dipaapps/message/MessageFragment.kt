package com.example.dipaapps.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dipaapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://ui-avatars.com/api/?name=Alya&background=random"),
        MessageModel("Budi", "Sudah makan?", "https://ui-avatars.com/api/?name=Budi&background=random"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://ui-avatars.com/api/?name=Citra&background=random"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://ui-avatars.com/api/?name=Dika&background=random"),
        MessageModel("Eka", "Nice job kemarin!", "https://ui-avatars.com/api/?name=Eka&background=random"),
        MessageModel("Fajar", "Lagi ngapain?", "https://ui-avatars.com/api/?name=Fajar&background=random"),
        MessageModel("Gita", "Boleh minta tolong?", "https://ui-avatars.com/api/?name=Gita&background=random"),
        MessageModel("Hana", "Lihat email ya", "https://ui-avatars.com/api/?name=Hana&background=random"),
        MessageModel("Irfan", "Oke noted", "https://ui-avatars.com/api/?name=Irfan&background=random"),
        MessageModel("Joko", "Sampai jumpa besok", "https://ui-avatars.com/api/?name=Joko&background=random")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Messages"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}