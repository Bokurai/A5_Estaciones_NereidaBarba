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
                        case "MES1":
                            imagen = R.drawable.winter;
                            break;
                        case "MES2":
                            imagen = R.drawable.winter;
                            break;
                        case "MES3":
                            imagen = R.drawable.spring;
                            break;
                        case "MES4":
                            imagen = R.drawable.spring;
                            break;
                        case "MES5":
                            imagen = R.drawable.spring;
                            break;
                        case "MES6":
                            imagen = R.drawable.summer;
                            break;
                        case "MES7":
                            imagen = R.drawable.summer;
                            break;
                        case "MES8":
                            imagen = R.drawable.summer;
                            break;
                        case "MES9":
                            imagen = R.drawable.autumn;
                            break;
                        case "MES10":
                            imagen = R.drawable.autumn;
                            break;
                        case "MES11":
                            imagen = R.drawable.autumn;
                            break;
                        case "MES12":
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
                        case "MES1":
                         nombreMes = "ENERO";
                            break;
                        case "MES2":
                            nombreMes = "FEBRERO";
                            break;
                        case "MES3":
                            nombreMes = "MARZO";
                            break;
                        case "MES4":
                            nombreMes = "ABRIL";
                            break;
                        case "MES5":
                            nombreMes = "MAYO";
                            break;
                        case "MES6":
                            nombreMes = "JUNIO";
                            break;
                        case "MES7":
                            nombreMes = "JULIO";
                            break;
                        case "MES8":
                            nombreMes = "AGOSTO";
                            break;
                        case "MES9":
                            nombreMes = "SEPTIEMBRE";
                            break;
                        case "MES10":
                            nombreMes = "OCTUBRE";
                            break;
                        case "MES11":
                            nombreMes = "NOVIEMBRE";
                            break;
                        case "MES12":
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


