
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Mina mina = new Mina(500);
		int cont = 0;

		Thread hiloMinero;
		ArrayList<Minero> mineros = new ArrayList();
		for (int i = 0; i < 10; i++) {
			Minero minero = new Minero(mina);
			mineros.add(minero);
			hiloMinero = new Thread(minero);
			hiloMinero.setName("Minero " + (i + 1));
			hiloMinero.start();

		}
		Ventilador v = new Ventilador();
		Thread encendido = new Thread(new Runnable() {
			@Override
			public void run() {
				v.encenderVentilador();
			}
		});
		Thread apagado = new Thread(new Runnable() {
			@Override
			public void run() {
				v.apagarVentilador();
			}
		});
		encendido.start();
		apagado.start();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int h = 0; h < mineros.size(); h++) {
			cont += mineros.get(h).bolsa;
		}

		System.out.println("Stock de la mina:\t" + mina.stock);
		System.out.println("Total de extracciones:\t" + cont);

	}

}
