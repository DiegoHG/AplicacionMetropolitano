package com.desarrollo.metropolitano;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class consultaViaje4 extends Activity {
	private TextView lblParaderoI;
	private TextView lblParaderoF;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consultaviaje4);
		
		lblParaderoI = (TextView)findViewById(R.id.ResulIni);
		lblParaderoF = (TextView)findViewById(R.id.ResulFin);
		Bundle bundle = getIntent().getExtras();
		String txt1 = bundle.getString("Inicio");
		String txt2 = bundle.getString("Fin");
		Editable str1 = Editable.Factory.getInstance().newEditable(txt1);
		Editable str2 = Editable.Factory.getInstance().newEditable(txt2);
		str1.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, txt1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		str2.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, txt2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		lblParaderoI.setText(str1);
		lblParaderoF.setText(str2);
		
		
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("EEEE");
		java.text.SimpleDateFormat sdf2=new java.text.SimpleDateFormat("hh aa", new Locale("es_ES"));
		String day = sdf.format(date);
		String hour = sdf2.format(date);		
		TextView dia = (TextView)findViewById(R.id.DiaActual);
		TextView hora = (TextView)findViewById(R.id.HoraActual);
		dia.setText(day);
		hora.setText(hour);
	}
	
	
}
