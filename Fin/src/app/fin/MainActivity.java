package app.fin;


import java.util.concurrent.TimeUnit;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public TextView tiempoRestante, tvCorrectas, tvIncorrectas;
	public String tiempo = "0";
	public int correctas;
	public int incorrectas;

	private double startTime = 0;

	private Handler handler1 = new Handler();
	private Runnable Hilo = new Runnable() {
		public void run() {
			acTiempo();
			Pop();
		}
	};

	MediaPlayer mp;
	int posicion = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tiempoRestante = (TextView) findViewById(R.id.tvTiempoRestante);
		tvCorrectas = (TextView) findViewById(R.id.tvCorrectas);
		tvIncorrectas = (TextView) findViewById(R.id.tvIncorrectas);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void iniciarHilo() {
		final Thread thread1 = new Thread() {
			public void run() {
				try {

					while (true) {
						Thread.sleep(1000);
						handler1.post(Hilo);

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		};
		thread1.start();
	}

	public void destruir() {
		if (mp != null)
			mp.release();
	}

	public void iniciar(View v) {
		destruir();
		mp = MediaPlayer.create(this, R.raw.pelicula);
		mp.start();

		incorrectas = 0;
		tvIncorrectas.setText(Integer.toString(incorrectas));
		correctas = 0;
		tvCorrectas.setText(Integer.toString(correctas));
		tiempoRestante.setText("0");

		iniciarHilo();
	}

	public void pausar(View v) {
		if (mp != null && mp.isPlaying()) {
			posicion = mp.getCurrentPosition();
			mp.pause();
		}
	}

	public void continuar(View v) {
		if (mp != null && mp.isPlaying() == false) {
			mp.seekTo(posicion);
			mp.start();
		}
	}

	public void detener(View v) {
		if (mp != null) {
			mp.stop();
			posicion = 0;
			incorrectas = 0;
			tvIncorrectas.setText(Integer.toString(incorrectas));
			correctas = 0;
			tvCorrectas.setText(Integer.toString(correctas));
			tiempoRestante.setText("0");

		}
	}

	@SuppressLint("NewApi")
	public void acTiempo() {

		System.out.println(mp.getCurrentPosition());
		startTime = mp.getCurrentPosition();

		tiempoRestante.setText(String.format(
				"%d min, %d sec",
				TimeUnit.MILLISECONDS.toMinutes((long) startTime),
				TimeUnit.MILLISECONDS.toSeconds((long) startTime)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes((long) startTime))));

		tiempo = tiempoRestante.getText().toString();

		System.out.println(tiempo);
	}

	public void Pop() {
		final View v = null;

		if (tiempo.equals("0 min, 10 sec")) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = { "On the street.",
					"In a tree.", };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Where hung?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item]
									.equals("On the street.")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

		}

		if (tiempo.equals("0 min, 30 sec")) {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = { "Future", "On the street", "live" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("who want to steal?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item].equals("On the street")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

		}

		if (tiempo.equals("1 min, 00 sec")) {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = { "My grandmother", "My brother", "Mon and Dad" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("who lived up?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item].equals("Mon and Dad")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

		}

		if (tiempo.equals("1 min, 15 sec")) {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = { "Nixon", "Pedro", "Alex" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Who has died?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item].equals("Nixon")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

		}

		if (tiempo.equals("1 min, 30 sec")) {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = {
					"Wisconsin",
					"Colorado",
					"In the monstains" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Where are the rock?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item].equals("Wisconsin")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

		}
		
		if (tiempo.equals("1 min, 40 sec")) {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pausar(v);

			final CharSequence[] items = {
					"A car",
					"A dog",
					"A dug" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Who want to steal?");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int item) {

							if (items[item].equals("A car")) {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Correcta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								correctas++;
								tvCorrectas.setText(Integer.toString(correctas));
								continuar(v);
							} else {

								Toast toast = Toast.makeText(
										getApplicationContext(),
										"Haz elegido la opcion Incorrecta: "
												+ items[item],
										Toast.LENGTH_SHORT);
								toast.show();
								dialog.cancel();
								incorrectas++;
								tvIncorrectas.setText(Integer
										.toString(incorrectas));
								iniciar(v);

							}

						}
					});
			AlertDialog alert = builder.create();
			alert.show();

	}
		}
}