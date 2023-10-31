package com.example.a5_estaciones_nereidabarba;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.example.a5_estaciones_nereidabarba.databinding.FragmentEstacionBinding;

import kotlin.jvm.functions.Function1;


public class RotacionViewModel extends AndroidViewModel {

    Rotacion rotacion;

    LiveData<Integer> estacionLiveData;
    LiveData<String> mesLiveData;

    FragmentEstacionBinding binding;

    public RotacionViewModel(@NonNull Application application) {
        super(application);

        rotacion = new Rotacion();

        estacionLiveData = Transformations.switchMap(rotacion.cambioLiveData, new Function1<String, LiveData<Integer>>() {

            String estacionAnterior;

            @Override
            public LiveData<Integer> invoke(String cambio) {

                String estacion = cambio.split(":")[0];

                if(!estacion.equals(estacionAnterior)){
                    estacionAnterior = estacion;
                    int imagen;
                    switch (estacion) {
                        default:
                        case "1":
                            imagen = R.drawable.winter;
                            break;
                        case "2":
                            imagen = R.drawable.winter;
                            break;
                        case "3":
                            imagen = R.drawable.spring;
                            break;
                        case "4":
                            imagen = R.drawable.spring;
                            break;
                        case "5":
                            imagen = R.drawable.spring;
                            break;
                        case "6":
                            imagen = R.drawable.summer;
                            break;
                        case "7":
                            imagen = R.drawable.summer;
                            break;
                        case "8":
                            imagen = R.drawable.summer;
                            break;
                        case "9":
                            imagen = R.drawable.autumn;
                            break;
                        case "10":
                            imagen = R.drawable.autumn;
                            break;
                        case "11":
                            imagen = R.drawable.autumn;
                            break;
                        case "12":
                            imagen = R.drawable.winter;
                            break;
                    }

                    return new MutableLiveData<>(imagen);
                }
                return null;
            }
        });

        mesLiveData = Transformations.switchMap(rotacion.cambioLiveData, new Function1<String, LiveData<String>>() {

            String mesAnterior;

            @Override
            public LiveData<String> invoke(String cambio) {
                String mes = cambio.split(":")[1];


                if(!mes.equals(mesAnterior)) {
                    mesAnterior = mes;
                    String nombreMes;
                    switch (mes) {
                        default:
                        case "1":
                         nombreMes = "ENERO";
                            break;
                        case "2":
                            nombreMes = "FEBRERO";
                            break;
                        case "3":
                            nombreMes = "MARZO";
                            break;
                        case "4":
                            nombreMes = "ABRIL";
                            break;
                        case "5":
                            nombreMes = "MAYO";
                            break;
                        case "6":
                            nombreMes = "JUNIO";
                            break;
                        case "7":
                            nombreMes = "JULIO";
                            break;
                        case "8":
                            nombreMes = "AGOSTO";
                            break;
                        case "9":
                            nombreMes = "SEPTIEMBRE";
                            break;
                        case "10":
                            nombreMes = "OCTUBRE";
                            break;
                        case "11":
                            nombreMes = "NOVIEMBRE";
                            break;
                        case "12":
                            nombreMes = "DICIEMBRE";
                            break;
                    }
                    return new MutableLiveData<>(nombreMes);
                }
                 return null;
            }
        });
    }
    LiveData<Integer> obtenerEstacion(LifecycleOwner viewLifecycleOwner, Observer<Integer> observer){
        return estacionLiveData;
    }

    LiveData<String> obtenerMes(LifecycleOwner viewLifecycleOwner, Observer<String> observer){
        return mesLiveData;
    }


}


