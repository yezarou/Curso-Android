package musculacion;

import com.opencsv.CSVReader;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;

public class Musculacion {
    private final static int MAQUINA_ID = 18;
    private final static int MAQUINA_NOMBRE = 19;
    private final static int MAQUINA_URL_ICON = 21;
    private final static int MAQUINA_NIVEL = 20;
    private final static int MAQUINA_FUNCION = 22;
    private final static int MAQUINA_DESCRIPCION = 23;
    private final static int ZONA_ID = 14;
    private final static int ZONA_NOMBRE = 15;
    private final static int ZONA_URL_ICON = 17;
    private final static int ZONA_UBICACION = 2;

    private String ciudad;
    private Map<Integer, Zona> zonas;

    public Musculacion (String ciudad){
        this.ciudad = ciudad;
        zonas = new TreeMap<>();
    }

    public String getCiudad() { return ciudad; }

    public void leeDatosUrl(String urlCSV) throws IOException {
        URL url = new URL(urlCSV);
        try (InputStream in = url.openStream();
             InputStreamReader isr = new InputStreamReader(in);
             BufferedReader bin = new BufferedReader(isr);
             CSVReader reader = new CSVReader(bin)) {
            leeDatos(reader);
        }
    }

    public void leeDatosLocal(String ficheroCSV) throws IOException {
        try (InputStream in = new FileInputStream(ficheroCSV);
             InputStreamReader isr = new InputStreamReader(in);
             BufferedReader bin = new BufferedReader(isr);
             CSVReader reader = new CSVReader(bin)) {
            leeDatos(reader);
        }
    }

    private void leeDatos(CSVReader reader) throws IOException {
        reader.readNext(); // Ignoramos la primera linea
        List<String[]> datos = reader.readAll();// Leemos todas
        for(String[] tokens : datos) {
            Maquina maquina = new Maquina(Integer.parseInt(tokens[MAQUINA_ID]), tokens[MAQUINA_NOMBRE]);
            maquina.setUrlImagen(tokens[MAQUINA_URL_ICON]);
            maquina.setNivel(Integer.parseInt(tokens[MAQUINA_NIVEL]));
            maquina.setFuncion(tokens[MAQUINA_FUNCION]);
            maquina.setDescripcion(tokens[MAQUINA_DESCRIPCION]);

            Zona zona = zonas.get(Integer.parseInt(tokens[ZONA_ID]));
            if (zona == null){
                zona = new Zona(Integer.parseInt(tokens[ZONA_ID]), tokens[ZONA_NOMBRE]);
                zonas.put(zona.getZonaId(), zona);

                String[] ubicacion = tokens[ZONA_UBICACION].split("[( )]+");
                zona.setLatitud(Double.parseDouble(ubicacion[1]));
                zona.setLongitud(Double.parseDouble(ubicacion[2]));
                zona.setUrlImagen(tokens[ZONA_URL_ICON]);
            }

            zona.agrega(maquina);
        }
    }

    public Set<Zona> getZonas(){
        Set<Zona> listaZonas = new TreeSet<>();

        for (Map.Entry<Integer, Zona> zona : zonas.entrySet()) {
            listaZonas.add(zona.getValue());
        }

        return listaZonas;
    }

    public Set<Maquina> getMaquinasEnZonaId(int zonaId){
        Zona zona = zonas.get(zonaId);
        return zona.getMaquinas();
    }

    public Set<Zona> getZonasConMaquinaId(int maquinaId){
        Set<Zona> listaZonas = new TreeSet<>();

        for (Map.Entry<Integer, Zona> zona : zonas.entrySet()) {
            for (Maquina maquina : zona.getValue().getMaquinas())
                if (maquina.getMaquinaId() == maquinaId)
                    listaZonas.add(zona.getValue());
        }

        return listaZonas;
    }
}
