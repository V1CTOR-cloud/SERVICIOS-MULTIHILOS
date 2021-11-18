
public class Ventilador {
	boolean estado = true;
	int tiempo = 2000;

	public void encenderVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (!estado)
						wait();

					System.out.println("Encendido");
					Thread.sleep(tiempo);
					estado = false;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void apagarVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (estado)
						wait();
					System.err.println("Apagado");
					Thread.sleep(tiempo);
					estado = true;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
