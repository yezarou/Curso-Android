package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class FiltroAzulThread implements FiltroImagen {

	public void filtra(Bitmap imagen) {
		int nThreads = Thread.activeCount();
		int numtasks = nThreads;
		Thread[] threads = new Thread[nThreads];
		int count = 0;

		while (count < numtasks) {
			// Se van ha crear tantos threads como tareas especificadas pero en tandas de nThreads cada vez
			int nth = 0;
			while (nth < nThreads && count < numtasks) {
				// se crean nThreads y se ponen a trabajar (start)
				threads[nth] = new Thread(new myTask(count, numtasks, imagen));
				threads[nth].start();
				nth++;
				count++;
			}
			for (int i = 0; i < nth; i++) {
				// se espera a que terminen los nThreads que estan trabajando antes de crear otros
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void filtraChunk(Bitmap imagen, int myId, int nTask) {
		int fWidth = imagen.getWidth();
		int fHeightIni = (myId * imagen.getHeight()) / nTask;
		int fHeightFin = ((myId + 1) * imagen.getHeight()) / nTask;

		for (int y = fHeightIni; y < fHeightFin; y++) {
			for (int x = 0; x < fWidth; x++) {
				int azul = Color.blue(imagen.getPixel(x, y));
				imagen.setPixel(x, y, Color.rgb(0, 0, azul));
			}
		}
	}

	public class myTask implements Runnable {
		private int myId;
		private int nTasks;
		private Bitmap img;

		myTask(int _myId, int _nTasks, Bitmap _img) {
			myId = _myId;
			nTasks = _nTasks;
			img = _img;
		}

		@Override
		public void run() {
			filtraChunk(img, myId, nTasks);
		}
	}

}
