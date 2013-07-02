package com.desarrollo.metropolitano;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import entidades.ListarParaderos;
import entidades.Paradero;


public class consultaViaje2 extends Activity {
	private TextView lblEtiqueta;
	private ListView lstOpciones;
	private TextView txtParIni;
	
	final Paradero[] datos = ListarParaderos.listado();
			

	public void consultarViaje3Task(View view) {
        Intent i = new Intent(this, consultaViaje3.class );
        i.putExtra("ParaderoInicial", txtParIni.getText().toString());
        startActivity(i);
	}  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consultaviaje2);
		txtParIni = (TextView)findViewById(R.id.LblEtiqueta);
		
		Resources res = getResources();
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("LISTADO",
		    res.getDrawable(android.R.drawable.arrow_down_float));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("mitab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("MAPA",
		    res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);		 
		tabs.setCurrentTab(0);
		
		spec=tabs.newTabSpec("mitab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("CÁMARA",
		    res.getDrawable(android.R.drawable.ic_menu_view));
		tabs.addTab(spec);		 
		tabs.setCurrentTab(0);
		
		AdaptadorParaderos adaptador =
		        new AdaptadorParaderos(this);
		 
		lstOpciones = (ListView)findViewById(R.id.LstOpciones);
		lblEtiqueta = (TextView)findViewById(R.id.LblEtiqueta);
		
		lstOpciones.setAdapter(adaptador);
		lstOpciones.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
            	
            	//Alternativa 1:
            	String opcionSeleccionada = 
            			((Paradero)a.getAdapter().getItem(position)).getTitulo();
            	
            	//Alternativa 2:
            	//String opcionSeleccionada = 
            	//		((TextView)v.findViewById(R.id.LblTitulo))
            	//			.getText().toString();
            	
            	lblEtiqueta.setText(opcionSeleccionada);            	
            }
        });
	}
	
	
	
	
	
	class AdaptadorParaderos extends ArrayAdapter<Paradero> {
    	
    	Activity context;
    	
    	AdaptadorParaderos(Activity context) {
    		super(context, R.layout.listitem_paraderos, datos);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.listitem_paraderos, null);

			TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
			lblTitulo.setText(datos[position].getTitulo());

			TextView lblUbicacion = (TextView)item.findViewById(R.id.LblUbicacion);
			lblUbicacion.setText(datos[position].getUbicacion());

			return(item);
		}
    }
}
