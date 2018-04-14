package ferr738.capacidad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by focam on 13/4/2018.
 */

    public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

        // Creamos una variable que contendra la sentencia SQL de creacion de la tabla
        String sql = "CREATE TABLE Padres (Nombre TEXT, Apellido TEXT, Dni INTEGER)";


        public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Este metodo se ejecuta automaticamente cuando la base de datos no existe
            // es decir, que la primera vez que se hace llamado a la clase, crea la BD


            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            // Este metodo se ejecuta cuando se detecta que la version de la base de datos
            // cambio, por lo que se debe definir todos los procesos de migracion de la estructura
            // anterior a la estructura nueva. Por simplicidad del ejemplo, lo que haremos es eliminar
            // la tabla existente y crearla nuevamente.

            db.execSQL("DROP TABLE IF EXISTS Padres");
            db.execSQL(sql);
        }
}
