package com.example.a5_estaciones_nereidabarba;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.lifecycle.LiveData;


public class Rotacion {

    LiveData<String> cambioLiveData = new LiveData<String>() {
        @Override
        protected void onActive() {
            super.onActive();

            iniciarRotacion(new RotacionListener() {
                @Override
                public void cuandoCambieElMes(String orden) {
                    postValue(orden);
                }
            });
        }

        @Override
        protected void onInactive() {
            super.onInactive();

            pararRotacion();
        }
    };

    interface RotacionListener {
        void cuandoCambieElMes(String cambio);
    }

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> rotando;

    void iniciarRotacion(RotacionListener rotacionListener) {
        if (rotando == null || rotando.isCancelled()) {
            rotando = scheduler.scheduleAtFixedRate(new Runnable() {
                int mes = 1;

                @Override
                public void run() {
                    if (mes == 13) {
                        mes = 1;
                    }else {
                        mes ++;
                    }
                    rotacionListener.cuandoCambieElMes("MES" + mes);
                }
            }, 0, 1, SECONDS);
        }
    }
    void pararRotacion() {
        if (rotando != null) {
            rotando.cancel(true);
        }
    }
}


