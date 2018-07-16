package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class FiltroAzulExecutor implements FiltroImagen {

	public void filtra(Bitmap imagen) {
		int numTask = 20;
		ExecutorService executor = Executors.newFixedThreadPool(Thread.activeCount());
		// se crean todas las tasks indicadas y se mandan a ejecutar en el executor
		for (int i = 0; i < numTask; i++) {
			executor.execute(new myTask(i, numTask, imagen));
		}

		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
