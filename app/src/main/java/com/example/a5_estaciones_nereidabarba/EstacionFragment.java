package com.example.a5_estaciones_nereidabarba;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.a5_estaciones_nereidabarba.databinding.FragmentEstacionBinding;

public class EstacionFragment extends Fragment {
    private FragmentEstacionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentEstacionBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RotacionViewModel rotacionViewModel = new ViewModelProvider(this).get(RotacionViewModel.class);

        rotacionViewModel.obtenerEstacion(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer estacion) {
                Glide.with(EstacionFragment.this).load(estacion).into(binding.estacion);
            }
        });

        rotacionViewModel.obtenerMes(getViewLifecycleOwner(),new Observer<String>(){

            @Override
            public void onChanged(String mes) {

                binding.mes.setText(mes);
            }
        });
    }

}