package ferr738.capacidad;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by focam on 13/4/2018.
 */

public class MainInicio extends AppCompatActivity {

    // Estas variables permitiran obtener los controles creados y asi poder manipularlos
    EditText edtNombre;
    EditText edtApellido;
    EditText edtDni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);

        // Mapeamos las variables creadas con los controles.
        // De esta manera podemos setear valores u obtenerlos.

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        edtDni = (EditText) findViewById(R.id.edtDni);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Estamos asignando el menu al activity
        getMenuInflater().inflate(R.menu.menu_padres, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // De acuerdo al icono seleccionado, se debe realizar una accion
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_add:

                // Aca debemos trabajar con todos los controles que definen el padre
                // para poder ingresarlo.
                String nombre = edtNombre.getText().toString();
                String apellido = edtApellido.getText().toString();
                String dni = edtDni.getText().toString();

                // Validamos que se ingresen todos los campos
                if (nombre.length() > 0 && apellido.length() > 0 && dni.length() > 0){
                    // Abrimos la base de datos de Padres
                    UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this,"DBPadres", null, 1 );
                    SQLiteDatabase db = usuario.getWritableDatabase();

                    db.execSQL("INSERT INTO Padres (Nombre, Apellido, Dni) VALUES ('"+ nombre +"', '"+ apellido +"', "+ dni +" )");
                    db.close();
                    Toast.makeText(this, "El usuario se ha creado exitosamente", Toast.LENGTH_SHORT).show();
                    edtNombre.setText("");
                    edtApellido.setText("");
                    edtDni.setText("");

                }
                else{
                    Toast.makeText(this, "Debe ingresar todos los datos o algun dato es incorrecto.", Toast.LENGTH_SHORT).show();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}


