
public class Minero implements Runnable {
	int bolsa;
	int tiempoExtraccion;
	Mina mina;

	public Minero(Mina m) {
		bolsa = 0;
		tiempoExtraccion = 150;
		mina = m;
	}

	public void extraerRecurso() {
		while (mina.stock > 0) {
			synchronized (mina) {
				bolsa++;
				mina.stock--;
				System.out.println(Thread.currentThread().getName() + "\tBolsa:\t" + bolsa + "\tStock:\t" + mina.stock);
			}
			try {
				Thread.sleep(tiempoExtraccion);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
	@Override
	public void run() {
		extraerRecurso();
	}
}
