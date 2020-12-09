package com.example.apirest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apirest.Model.Persona;

import java.util.List;
import java.util.Map;

public class PersonaAdapter extends ArrayAdapter<Persona> {

    private Context context;
    private  List<Persona>personas;

    public PersonaAdapter(@NonNull Context context, int resource, @NonNull List<Persona> objects) {
        super(context, resource, objects);
        this.context=context;
        this.personas=objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView txtidPersona=(TextView)rowView.findViewById(R.id.IdPersona);
        TextView txtNombre=(TextView)rowView.findViewById(R.id.Nombre);;
        TextView txtApellidos=(TextView)rowView.findViewById(R.id.Apellidos);;

        txtidPersona.setText(String.format("ID:%d",personas.get(position).getId()));
        txtNombre.setText(String.format("NOMBRE:%s",personas.get(position).getNombres()));
        txtApellidos.setText(String.format("APELLIDOS: %s",personas.get(position).getApellidos()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(context, PersonaActivity.class);
               intent.putExtra("ID",String.valueOf(personas.get(position).getId()));
               intent.putExtra("NOMBRE",personas.get(position).getNombres());
                intent.putExtra("APELLIDOS",personas.get(position).getApellidos());
               context.startActivity(intent);
            }
        });
        return rowView;

    }

}
